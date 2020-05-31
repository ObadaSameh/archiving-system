package archive_sys_project;

import archive_sys_project.entities.Category;
import archive_sys_project.entities.Document;
import archive_sys_project.entities.Tag;
import archive_sys_project.entities.Topic;
import archive_sys_project.functions.ViewIntegrationFunctions;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.function.Consumer;
import java.util.function.Function;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
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
public class DocumentsStage {

    public static void newStage() {

        List<Topic> topics = ViewIntegrationFunctions.getTopicCrud().getAll();
        List<Category> categories = ViewIntegrationFunctions.getCategoryCrud().getAll();
        List<Tag> tags = ViewIntegrationFunctions.getTagCrud().getAll();

        ObservableList<Document> documentsList = FXCollections.observableArrayList(ViewIntegrationFunctions.getDocumentCrud().getAll());

        ListView<Document> tree = new ListView<Document>();
        tree.setItems(documentsList);

        Stage Mainstage = new Stage();

        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File("src"));

        Button editbtn = new Button("Edit");

        Button newbtn = new Button("Add New Document");
        newbtn.setOnAction((ActionEvent event) -> {
            Document d = new Document();
            d.setTagsIds(new ArrayList<>());

            EditDocumentStage.newStage(d);
            Mainstage.close();
        });
        Button delbtn = new Button("Delete");

        Button tagbtn = new Button("Tag");
        Button ctgbtn = new Button("Category");
        Button tpcbtn = new Button("Topic");
        Button svbtn = new Button("Save Archive");

        delbtn.setOnAction(e -> {
            Document d = tree.getSelectionModel().getSelectedItem();
            if (d == null) {
                return;
            }
            ViewIntegrationFunctions.getDocumentCrud().delete(d);

            documentsList.remove(d);
        });

        tagbtn.setOnAction(e -> {

            TagStage.newStage();
            Mainstage.close();
        });

        editbtn.setOnAction(e -> {
            Document d = tree.getSelectionModel().getSelectedItem();
            if (d == null) {
                return;
            }
            EditDocumentStage.newStage(d);
            Mainstage.close();
        });

        ctgbtn.setOnAction(e -> {
            CategoryStage.newStage();
            Mainstage.close();
        });

        tpcbtn.setOnAction(e -> {
            TopicsStage.newStage();
            Mainstage.close();
        });

        svbtn.setOnAction(e -> {
            ViewIntegrationFunctions.saveArchive(Mainstage);
        });

        ComboBox tagBox = new ComboBox();
        tagBox.setPromptText("Tag");
        tagBox.setItems(FXCollections.observableArrayList(tags));
        ComboBox ctgBox = new ComboBox();
        ctgBox.setPromptText("Category");
        ctgBox.setItems(FXCollections.observableArrayList(categories));
        ComboBox tpcBox = new ComboBox();
        tpcBox.setPromptText("Topic");
        tpcBox.setItems(FXCollections.observableArrayList(topics));

        Consumer<?> documentsFilter = (Object s) -> {

            Tag tag = (Tag) tagBox.getSelectionModel().getSelectedItem();
            Category category = (Category) ctgBox.getSelectionModel().getSelectedItem();
            Topic topic = (Topic) tpcBox.getSelectionModel().getSelectedItem();

            Integer topicId = null, tagId = null, categoryId = null;
            if (tag != null) {
                tagId = tag.getId();
            }
            if (topic != null) {
                topicId = topic.getId();
            }
            if (category != null) {
                categoryId = category.getId();
            }

            List<Document> docs = ViewIntegrationFunctions.filterDocuments(topicId, categoryId, tagId);

            documentsList.clear();
            documentsList.addAll(docs);

        };

        tpcBox.getSelectionModel().selectedItemProperty().addListener((ObservableValue ov, Object oldValue, Object newValue) -> {
            documentsFilter.accept(null);
        });
        ctgBox.getSelectionModel().selectedItemProperty().addListener((ObservableValue ov, Object oldValue, Object newValue) -> {
            documentsFilter.accept(null);
        });
        tagBox.getSelectionModel().selectedItemProperty().addListener((ObservableValue ov, Object oldValue, Object newValue) -> {
            documentsFilter.accept(null);
        });

        TreeItem<String> rootItem = new TreeItem<String>("Document List");
        rootItem.setExpanded(true);
        for (int i = 1; i < 6; i++) {
            TreeItem<String> item = new TreeItem<String>("Message" + i);
            rootItem.getChildren().add(item);
        }

        TextArea textField = new TextArea();
        textField.setEditable(false);
        tree.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Document> ov, Document oldValue, Document newValue) -> {
            if (newValue != null) {
                String str = ViewIntegrationFunctions.getdocumentContent(newValue);
                textField.setText(str);
            } else {
                String str = "";
                textField.setText(str);
            }
        });

        StackPane root = new StackPane();

        HBox mainBox = new HBox();
        HBox comboHBox = new HBox();
        HBox documentOperationsHBox = new HBox();

        VBox filterationVBox = new VBox();
        VBox systemBtnsVBox = new VBox();
        VBox documentVBox = new VBox();

        mainBox.getChildren().add(filterationVBox);
        mainBox.getChildren().add(documentVBox);
        mainBox.getChildren().add(systemBtnsVBox);
        VBox.setVgrow(documentVBox, Priority.ALWAYS);

        comboHBox.getChildren().add(ctgBox);
        comboHBox.getChildren().add(tpcBox);
        comboHBox.getChildren().add(tagBox);

        filterationVBox.getChildren().add(comboHBox);
        filterationVBox.getChildren().add(tree);
        VBox.setVgrow(tree, Priority.ALWAYS);

        documentOperationsHBox.getChildren().add(newbtn);
        documentOperationsHBox.getChildren().add(editbtn);
        documentOperationsHBox.getChildren().add(delbtn);

        documentVBox.getChildren().add(textField);
        documentVBox.getChildren().add(documentOperationsHBox);
        VBox.setVgrow(textField, Priority.ALWAYS);

        systemBtnsVBox.getChildren().add(svbtn);
        systemBtnsVBox.getChildren().add(tpcbtn);
        systemBtnsVBox.getChildren().add(ctgbtn);
        systemBtnsVBox.getChildren().add(tagbtn);

        root.getChildren().add(mainBox);

//          VBox vBox = new VBox(button);
//           Scene scene = new Scene(vBox, 960, 600);
        Scene scene = new Scene(root, 960, 600);

        Mainstage.setTitle("Archiving System");
        Mainstage.setScene(scene);
        Mainstage.show();
    }
}
