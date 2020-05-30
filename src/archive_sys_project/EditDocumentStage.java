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
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.controlsfx.control.CheckListView;

/**
 *
 * @author maibrahim
 */
public class EditDocumentStage {

    public void newStage(Document document) /*throws  FileNotFoundException */ {

        List<Topic> topics = ViewIntegrationFunctions.getTopicCrud().getAll();
        List<Category> categories = ViewIntegrationFunctions.getCategoryCrud().getAll();
        List<Tag> tags = ViewIntegrationFunctions.getTagCrud().getAll();

        Stage stage = new Stage();

        FileChooser fileChooser = new FileChooser();

        Label topicLabel = new Label();
        topicLabel.setMaxWidth(100);
        ComboBox<Topic> topicBox = new ComboBox<Topic>();
        topicBox.setItems(FXCollections.observableArrayList(topics));

//        topicBox.getSelectionModel().selectedItemProperty().addListener(((ObservableValue<? extends Topic> options, Topic oldValue, TopicnewValue) -> {
//
//            if (newValue != null) {
//                document.setTopicId(newValue.getId());
//            } else {
//                document.setTopicId(null);
//            }
//        });

//        topicBox.getSelectionModel().selectedItemProperty().addListener((ObservableValue<Topic> observable, Topic oldValue, Topic newValue) -> {
//
//            System.err.println("sss");
////            if (newValue != null) {
////                document.setTopicId(newValue.getId());
////            } else {
////                document.setTopicId(null);
////            }
//        });
//        

        Label categoryLabel = new Label();
        topicLabel.setMaxWidth(100);
        ComboBox categoryBox = new ComboBox();
        categoryBox.setItems(FXCollections.observableArrayList(categories));

        Label tagLabel = new Label();
        topicLabel.setMaxWidth(100);
        CheckListView tagBox = new CheckListView();
        tagBox.setItems(FXCollections.observableArrayList(tags));

        Label selectFileLabel = new Label("selectFileLabel");
        topicLabel.setMaxWidth(100);
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

        svbtn.setTranslateX(220);
        svbtn.setTranslateY(-150);
        svbtn.setMaxHeight(75);
        svbtn.setMaxWidth(95);
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
        });

        StackPane root = new StackPane();

        VBox vbox = new VBox();

        HBox hbox1, hbox2, hbox3, hbox4, hbox5;

        hbox1 = new HBox();
        hbox1.getChildren().add(topicLabel);
        hbox1.getChildren().add(topicBox);

        hbox2 = new HBox();
        hbox2.getChildren().add(categoryLabel);
        hbox2.getChildren().add(categoryBox);

        hbox3 = new HBox();
        hbox3.getChildren().add(tagLabel);
        hbox3.getChildren().add(tagBox);

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

        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("Add/Edit Document");
        stage.setScene(scene);
        stage.show();
    }
}
