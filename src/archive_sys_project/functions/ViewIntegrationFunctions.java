/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archive_sys_project.functions;

import archive_sys_project.entities.Category;
import archive_sys_project.entities.Document;
import archive_sys_project.entities.Tag;
import archive_sys_project.entities.Topic;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sameh
 */
public class ViewIntegrationFunctions {

    boolean setExistingLibrary(File f) {
        return true;
    }

    boolean setNewLibrary(boolean isNew) {
        return true;
    }
    
     boolean saveArchive() {
         return true;
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

    public static List<Document> filderDocuments(Topic topic, Category category, Tag tag) {
        return new ArrayList<>();
    }

    public static String getdocumentContent(Document doc) {
        return "";
    }

    private static CrudInterface<Category> category;
    private static CrudInterface<Topic> topic;
    private static CrudInterface<Document> document;
    private static CrudInterface<Tag> tag;

}
