/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archive_sys_project.functions;

import archive_sys_project.entities.Archive;
import archive_sys_project.entities.Category;
import archive_sys_project.entities.Document;
import archive_sys_project.entities.Tag;
import archive_sys_project.entities.Topic;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.stage.Stage;

/**
 *
 * @author sameh
 */
public class ViewIntegrationFunctions {

    static Archive archive;

    public static boolean setExistingLibrary(File f) throws IOException {

        try {

            archive = Archive.fromFile(f);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean setNewLibrary(boolean isNew) {
        archive = Archive.getNew();
        return true;
    }

    public static boolean saveArchive(Stage stage) {

        return archive.save(stage);
    }

    /**
     * @return the category
     */
    public static CrudInterface<Category> getCategoryCrud() {
        return category;
    }

    /**
     * @return the topic
     */
    public static CrudInterface<Topic> getTopicCrud() {
        return topic;
    }

    /**
     * @return the document
     */
    public static CrudInterface<Document> getDocumentCrud() {
        return document;
    }

    /**
     * @return the tag
     */
    public static CrudInterface<Tag> getTagCrud() {
        return tag;
    }

    public static List<Document> filterDocuments(Topic topic, Category category, Tag tag) {
        return filterDocuments((topic == null) ? null : topic.getId(), (category == null) ? null : category.getId(), (tag == null) ? null : tag.getId());
    }

    public static List<Document> filterDocuments(Integer topicId, Integer categoryId, Integer tagId) {
        List<Document> result = new ArrayList<>();

        List<Document> documents = archive.getDocuments();

        result = documents.stream()
                .filter((Document d) -> {
                    if (topicId != null && !Objects.equals(d.getTopicId(), topicId)) {
                        return false;
                    }

                    if (categoryId != null && !Objects.equals(d.getCategoryId(), topicId)) {
                        return false;
                    }

                     if (tagId != null && d.getTagsIds().contains(tagId)) {
                        return false;
                    }

                    return true;
                })
                .map((Document e) -> (Document) e.clone()).collect(Collectors.toList());

        return result;
    }

    public static String getdocumentContent(Document doc) {

        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(doc.getName()));
        } catch (IOException ex) {
            Logger.getLogger(ViewIntegrationFunctions.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }

        String content = "";
        for (String l : lines) {
            content += l;
        }

        return content;
    }

    private static CrudInterface<Category> category = new EntityCrud<Category>(ViewIntegrationFunctions::categoryListgetter, ViewIntegrationFunctions::getNextId);
    private static CrudInterface<Topic> topic = new EntityCrud<Topic>(ViewIntegrationFunctions::topicListgetter, ViewIntegrationFunctions::getNextId);
    private static CrudInterface<Document> document = new EntityCrud<Document>(ViewIntegrationFunctions::documentListgetter, ViewIntegrationFunctions::getNextId);
    private static CrudInterface<Tag> tag = new EntityCrud<Tag>(ViewIntegrationFunctions::tagListgetter, ViewIntegrationFunctions::getNextId);

    private static List<Document> documentListgetter() {
        return archive.getDocuments();
    }

    private static List<Tag> tagListgetter() {
        return archive.getTags();
    }

    private static List<Topic> topicListgetter() {
        return archive.getTopics();
    }

    private static List<Category> categoryListgetter() {
        return archive.getCategories();
    }

    private static Integer getNextId() {
        return archive.getNextId();
    }

}
