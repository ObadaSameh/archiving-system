/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archive_sys_project;

import archive_sys_project.entities.Category;
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
public class CategoryStage {

    public static void newStage() {
        Stage stage = new Stage();
//        ObjectHolder<Category> selectedCategoryholder = new ObjectHolder<>();

        List<Category> items = ViewIntegrationFunctions.getCategoryCrud().getAll();

        ListView<Category> tree = new ListView<Category>(FXCollections.observableArrayList(items));

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
            Category t = new Category();
            t.setName(textFieldAdd.getText());

            t = ViewIntegrationFunctions.getCategoryCrud().create(t);

            textFieldAdd.setText("");

            tree.getItems().add(t);

        });

        editBtn.setOnAction(e -> {
            if (textFieldEdit.getText().length() == 0) {
                return;
            }
            Category t = tree.getSelectionModel().getSelectedItem(); //  selectedCategoryholder.getObj();
            t.setName(textFieldEdit.getText());

            Category t2 = ViewIntegrationFunctions.getCategoryCrud().update(t);

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
            Category t = tree.getSelectionModel().getSelectedItem();

            ViewIntegrationFunctions.getCategoryCrud().delete(t);

            tree.getItems().remove(t);

        });

        tree.getSelectionModel()
                .selectedItemProperty().addListener((ObservableValue<? extends Category> observable, Category oldValue, Category newValue) -> {
//                    selectedCategoryholder.setObj(newValue);
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
                "Categorys");
        stage.setScene(scene);

        stage.show();

    }
}
