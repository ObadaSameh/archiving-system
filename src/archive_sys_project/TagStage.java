/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archive_sys_project;

//import archive_sys_project.entities.Tag;
import archive_sys_project.entities.Tag;
import archive_sys_project.functions.ViewIntegrationFunctions;
import java.util.List;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author sameh
 */
public class TagStage {

    public static void newStage() {
        Stage stage = new Stage();
//        ObjectHolder<Tag> selectedTagholder = new ObjectHolder<>();

        List<Tag> items = ViewIntegrationFunctions.getTagCrud().getAll();

        ListView<Tag> tree = new ListView<Tag>(FXCollections.observableArrayList(items));

        TextField textFieldEdit = new TextField();

        Button editBtn = new Button("Edit");

        Button delbtn = new Button("Delete");

        TextField textFieldAdd = new TextField();

        Button newbtn = new Button("Add New");

        Button svbtn = new Button("Close");

        editBtn.setDisable(true);
        delbtn.setDisable(true);

        newbtn.setOnAction((ActionEvent event) -> {
            if (textFieldAdd.getText().length() == 0) {
                return;
            }
            Tag t = new Tag();
            t.setName(textFieldAdd.getText());

            t = ViewIntegrationFunctions.getTagCrud().create(t);

            textFieldAdd.setText("");

            tree.getItems().add(t);

        });

        editBtn.setOnAction(e -> {
            if (textFieldEdit.getText().length() == 0) {
                return;
            }
            Tag t = tree.getSelectionModel().getSelectedItem(); //  selectedTagholder.getObj();
            t.setName(textFieldEdit.getText());

            Tag t2 = ViewIntegrationFunctions.getTagCrud().update(t);

            int index = tree.getItems().indexOf(t);
            tree.getItems().remove(t);

            tree.getItems().add(index, t2);
        });

        //**
        svbtn.setOnAction(e
                -> {
            DocumentsStage.newStage();
            stage.close();
            
        });

        delbtn.setOnAction(e -> {
            Tag t = tree.getSelectionModel().getSelectedItem();

            ViewIntegrationFunctions.getTagCrud().delete(t);

            tree.getItems().remove(t);

        });

        tree.getSelectionModel()
                .selectedItemProperty().addListener((ObservableValue<? extends Tag> observable, Tag oldValue, Tag newValue) -> {
//                    selectedTagholder.setObj(newValue);
                    if (newValue != null) {
                        textFieldEdit.setText(newValue.getName());
                        editBtn.setDisable(false);
                        delbtn.setDisable(false);
                    } else {
                        textFieldEdit.setText("");
                        editBtn.setDisable(true);
                        delbtn.setDisable(true);
                    }
                });

        StackPane root = new StackPane();

        VBox vbox = new VBox(10);

        vbox.getChildren()
                .add(textFieldEdit);

        vbox.getChildren()
                .add(editBtn);
        vbox.getChildren()
                .add(delbtn);

        vbox.getChildren()
                .add(textFieldAdd);

        vbox.getChildren()
                .add(newbtn);
        vbox.getChildren()
                .add(svbtn);

        HBox hbox = new HBox(10);

        hbox.getChildren()
                .add(tree);
        hbox.getChildren()
                .add(vbox);

        root.getChildren()
                .add(hbox);

        Scene scene = new Scene(root, 600, 400);

        stage.setTitle(
                "Tags");
        stage.setScene(scene);

        stage.show();

    }
}
