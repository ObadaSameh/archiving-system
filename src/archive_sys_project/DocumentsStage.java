package archive_sys_project;

import archive_sys_project.entities.Category;
import archive_sys_project.entities.Document;
import archive_sys_project.entities.Tag;
import archive_sys_project.entities.Topic;
import archive_sys_project.functions.ViewIntegrationFunctions;
import java.io.File;
import java.util.List;
import java.util.Observable;
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

        Stage Mainstage = new Stage();

        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File("src"));

        Button editbtn = new Button("Edit");

        Button newbtn = new Button("Add New \n Document");
        newbtn.setOnAction((ActionEvent event) -> {

        });
        Button delbtn = new Button("Delete");

        Button tagbtn = new Button("Tag");
        Button ctgbtn = new Button("Category");
        Button tpcbtn = new Button("Topic");
        Button svbtn = new Button("Save Archive");

        delbtn.setOnAction(e -> {
            
        });

        tagbtn.setOnAction(e -> {

            TagStage.newStage();
            Mainstage.close();
        });

        editbtn.setOnAction(e -> {

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

        TreeItem<String> rootItem = new TreeItem<String>("Document List");
        rootItem.setExpanded(true);
        for (int i = 1; i < 6; i++) {
            TreeItem<String> item = new TreeItem<String>("Message" + i);
            rootItem.getChildren().add(item);
        }

        TextArea textField = new TextArea();

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
