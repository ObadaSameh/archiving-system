package archive_sys_project.entities;

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

    private int currentIndex;
    private File file;
    private List<Document> documents;
    private List<Tag> tags;
    private List<Topic> topics;
    private List<Category> categories;

    public static Archive fromFile(File file) {
        try {

            Archive arc = new Archive();

            List<String> s = Files.readAllLines(Paths.get(file.getPath()));

            return arc;
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

        return arc;
    }

    public boolean save(Stage stage) {
        File f = this.file;

        if (f == null) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Image");
//            System.out.println(pic.getId());
            f = fileChooser.showSaveDialog(stage);

            if (f == null) {
                return false;
            }

        }
        return true;
    }

    /**
     * @return the currentIndex
     */
    public int getCurrentIndex() {
        return currentIndex;
    }

    public int getNextId() {
        currentIndex++;
        return currentIndex + 1;

    }

    /**
     * @param currentIndex the currentIndex to set
     */
    private void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
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
