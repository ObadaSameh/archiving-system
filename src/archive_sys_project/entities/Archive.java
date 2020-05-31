package archive_sys_project.entities;

import archive_sys_project.entities.Category;
import archive_sys_project.entities.Document;
import archive_sys_project.entities.Tag;
import archive_sys_project.entities.Topic;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sameh
 */
public class Archive {

    private int currentMaxIndex;
    private File file;
    private List<Document> documents;
    private List<Tag> tags;
    private List<Topic> topics;
    private List<Category> categories;

    private static Archive loadInternal(Archive archive, List<String> rawData) {

        Category ctr = new Category();
        Document dtr = new Document();
        Tag tgr = new Tag();
        Topic tpr = new Topic();

        archive.currentMaxIndex = Integer.parseInt(rawData.remove(0));

        int count;

        if (rawData.remove(0).equals("TOPICS_LIST") == false) {
            throw new RuntimeException("File read error");
        }
        count = Integer.parseInt(rawData.remove(0));

        for (int i = 0; i < count; i++) {
            archive.topics.add((Topic) tpr.deserializeProps(null, rawData));
        }

        if (rawData.remove(0).equals("CATEGORIES_LIST") == false) {
            throw new RuntimeException("File read error");
        }

        count = Integer.parseInt(rawData.remove(0));

        for (int i = 0; i < count; i++) {
            archive.categories.add((Category) ctr.deserializeProps(null, rawData));
        }

        if (rawData.remove(0).equals("TAGS_LIST") == false) {
            throw new RuntimeException("File read error");
        }
        count = Integer.parseInt(rawData.remove(0));

        for (int i = 0; i < count; i++) {
            archive.tags.add((Tag) tgr.deserializeProps(null, rawData));
        }

        if (rawData.remove(0).equals("DOCUMENTS_LIST") == false) {
            throw new RuntimeException("File read error");
        }
        count = Integer.parseInt(rawData.remove(0));

        for (int i = 0; i < count; i++) {
            archive.documents.add((Document) dtr.deserializeProps(null, rawData));
        }

        return archive;
    }

    private List<String> saveInternal() {
        List<String> rawData = new ArrayList<>();

        rawData.add(currentMaxIndex + "");

        rawData.add("TOPICS_LIST");
        rawData.add(topics.size() + "");
        for (BaseEntity e : topics) {
            e.serializeProps(rawData);
        }

        rawData.add("CATEGORIES_LIST");
        rawData.add(categories.size() + "");
        for (BaseEntity e : categories) {
            e.serializeProps(rawData);
        }

        rawData.add("TAGS_LIST");
        rawData.add(tags.size() + "");
        for (BaseEntity e : tags) {
            e.serializeProps(rawData);
        }

        rawData.add("DOCUMENTS_LIST");
        rawData.add(documents.size() + "");
        for (BaseEntity e : documents) {
            e.serializeProps(rawData);
        }

        return rawData;
    }

    public static Archive fromFile(File file) {
        try {

            Archive archive = getNew();
            archive.file = file;
            List<String> s = Files.readAllLines(Paths.get(file.getPath()));

            return loadInternal(archive, s);

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

    public static Archive getNew() {

        Archive arc = new Archive();

        arc.setCategories(new ArrayList<>());
        arc.setTopics(new ArrayList<>());
        arc.setTags(new ArrayList<>());
        arc.setDocuments(new ArrayList<>());

        System.out.println("returning new archive");
        return arc;
    }

    public boolean save(Stage stage) {
        File f = this.file;

        if (f == null) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Archive");
//            System.out.println(pic.getId());
            f = fileChooser.showSaveDialog(stage);

            if (f == null) {
                return false;
            }

        }

        List<String> rawData = saveInternal();

        String str = "";

        for (String s : rawData) {
            str += s + "\n";
        }

        writeStringToFile(f, str);

        this.file = f;

        return true;
    }

    private static void writeStringToFile(File f, String str) {

        try {

            FileWriter fw = new FileWriter(f);
            fw.write(str);
            fw.close();

        } catch (IOException iox) {
            throw new RuntimeException(iox);
        }

    }

    /**
     * @return the currentIndex
     */
    public int getCurrentMaxIndex() {
        return currentMaxIndex;
    }

    public int getNextId() {
        currentMaxIndex++;
        return currentMaxIndex;

    }

    /**
     * @param currentIndex the currentIndex to set
     */
    private void setCurrentMaxIndex(int currentMaxIndex) {
        this.currentMaxIndex = currentMaxIndex;
    }

    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * @return the documents
     */
    public List<Document> getDocuments() {
        return documents;
    }

    /**
     * @param documents the documents to set
     */
    private void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    /**
     * @return the tags
     */
    public List<Tag> getTags() {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    private void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    /**
     * @return the topics
     */
    public List<Topic> getTopics() {
        return topics;
    }

    /**
     * @param topics the topics to set
     */
    private void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    /**
     * @return the categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * @param categories the categories to set
     */
    private void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}
