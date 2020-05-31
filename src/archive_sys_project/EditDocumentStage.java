/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archive_sys_project;

import archive_sys_project.entities.Category;
import archive_sys_project.entities.Document;
import archive_sys_project.entities.Tag;
import archive_sys_project.entities.Topic;
import archive_sys_project.functions.ViewIntegrationFunctions;
import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import jdk.nashorn.internal.ir.BreakableNode;
import org.controlsfx.control.CheckListView;

public class EditDocumentStage {

    public static void newStage(Document document) /*throws  FileNotFoundException */ {

        List<Topic> topics = ViewIntegrationFunctions.getTopicCrud().getAll();
        List<Category> categories = ViewIntegrationFunctions.getCategoryCrud().getAll();
        List<Tag> tags = ViewIntegrationFunctions.getTagCrud().getAll();

        Stage stage = new Stage();

        FileChooser fileChooser = new FileChooser();

        Label topicLabel = new Label("Topic: ");
//        topicLabel.setMaxWidth(100);
        ComboBox<Topic> topicBox = new ComboBox<Topic>();
        topicBox.setItems(FXCollections.observableArrayList(topics));
        topicBox.setPadding(new Insets(10));
        topicBox.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Topic> ov, Topic oldValue, Topic newValue) -> {
            if (newValue != null) {
                document.setTopicId(newValue.getId());
            } else {
                document.setTopicId(null);
            }
        });
        if (document.getTopicId() != null) {
            for (Topic t : topics) {
                if (t.getId() == document.getTopicId()) {
                    topicBox.setValue(t);
                    break;
                }
            }
        }

        Label categoryLabel = new Label("Category: ");
//        topicLabel.setMaxWidth(100);
        ComboBox<Category> categoryBox = new ComboBox<Category>();
        categoryBox.setItems(FXCollections.observableArrayList(categories));
        categoryBox.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Category> ov, Category oldValue, Category newValue) -> {
            if (newValue != null) {
                document.setCategoryId(newValue.getId());
            } else {
                document.setCategoryId(null);
            }
        });
        if (document.getCategoryId() != null) {
            for (Category t : categories) {
                if (t.getId() == document.getCategoryId()) {
                    categoryBox.setValue(t);
                    break;
                }
            }
        }

        Label tagLabel = new Label("Tags: ");
//        topicLabel.setMaxWidth(100);

        ListView<Tag> tagBox = new ListView<Tag>();

        VBox taglist = new VBox();

        for (Tag t : tags) {

            CheckBox cb = new CheckBox(t.getName());
            boolean selected = false;
            for (Integer tId : document.getTagsIds()) {
                if (tId == t.getId()) {
                    selected = true;
                    break;
                }
            }

            cb.setSelected(selected);

            cb.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                if (newValue == true) {
                    document.getTagsIds().add(t.getId());
                } else {
                    document.getTagsIds().remove(t.getId());
                }
            });

//            cb.setOnAction((ActionEvent e) -> {
//                
//                int index = document.getTagsIds().indexOf(t.getId());
//                
//                if (cb.isSelected()) {
//                    if (index < 0) {
//                        document.getTagsIds().add(t.getId());
//                    }
//                } else {
//                    if (index >= 0) {
//                        document.getTagsIds().remove(index);
//                    }
//                }
//            });
            taglist.getChildren().add(cb);
        }

        ScrollPane tagScroller = new ScrollPane();
        tagScroller.setMaxSize(100, 200);
        tagScroller.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        tagScroller.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        tagScroller.setContent(taglist);

//        tagBox.setItems(FXCollections.observableArrayList(tags));
//        tagBox.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//        if (document.getId() != null) {
//            List<Tag> selectedTags = document.getTagsIds().stream().map((Integer tagId) -> {
//                for (Tag t : tags) {
//                    if (Objects.equals(t.getId(), tagId)) {
//                        return t;
//                    }
//                }
//                return null;
//            }).filter((Tag t) -> t != null).collect(Collectors.toList());
//            
//            for (Tag t : selectedTags) {
//                tagBox.getSelectionModel().getSelectedItems().add(t);
//            }
//            
//        }
        Label selectFileLabel = new Label("File: ");
//        topicLabel.setMaxWidth(100);
        Button selectbtn = new Button("Select File");

        selectbtn.setOnAction(e -> {

            File f = fileChooser.showOpenDialog(stage);

            if (f == null) {
                return;
            }

            document.setName(f.getAbsolutePath());
        });

        //**
        Button svbtn = new Button("OK");

//        svbtn.setTranslateX(220);
//        svbtn.setTranslateY(-150);
//        svbtn.setMaxHeight(75);
//        svbtn.setMaxWidth(95);
        svbtn.setOnAction(e -> {

            if (document.getCategoryId() == null || document.getName() == null || document.getName().equals("") || document.getTopicId() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error...");
                alert.setHeaderText("Invalid input");
                alert.setContentText("Sorrry,can't accept invalid input !!!");
                alert.showAndWait();
                return;
            }

            if (document.getId() == null) {
                ViewIntegrationFunctions.getDocumentCrud().create(document);
            } else {
                ViewIntegrationFunctions.getDocumentCrud().update(document);
            }

            stage.close();
            DocumentsStage.newStage();
        });

        StackPane root = new StackPane();

        VBox vbox = new VBox();

        HBox hbox1, hbox2, hbox3, hbox4, hbox5;

        hbox1 = new HBox();
//        hbox1.getChildren().add(topicLabel);
        hbox1.getChildren().add(topicBox);

        hbox2 = new HBox();
        hbox2.getChildren().add(categoryLabel);
        hbox2.getChildren().add(categoryBox);

        hbox3 = new HBox();
        hbox3.getChildren().add(tagLabel);
        hbox3.getChildren().add(tagScroller);

        hbox4 = new HBox();
        hbox4.getChildren().add(selectFileLabel);
        hbox4.getChildren().add(selectbtn);

        hbox5 = new HBox();
        hbox5.getChildren().add(svbtn);

        vbox.getChildren().add(hbox1);
        vbox.getChildren().add(hbox2);
        vbox.getChildren().add(hbox3);
        if (document.getId() == null) {
            vbox.getChildren().add(hbox4);
        }

        vbox.getChildren().add(hbox5);

        root.getChildren().add(vbox);
        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("Add/Edit Document");
        stage.setScene(scene);
        stage.show();
    }
}
