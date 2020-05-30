/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archive_sys_project;

//import java.awt.Image;
import archive_sys_project.entities.Topic;
import archive_sys_project.functions.ObjectHolder;
import archive_sys_project.functions.ViewIntegrationFunctions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static javax.management.Query.value;

/**
 *
 * @author maibrahim
 */
public class Archive_sys_project extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setTranslateX(55);
//        btn.setTranslateY(12);
        //******
        FileChooser fileChooser = new FileChooser();
//        fileChooser.setInitialDirectory(new File("src"));
        //****** 
//        FileInputStream input = new FileInputStream("c:/Users/maibrahim/Documents/NetBeansProjects/Archive_sys_project/src/file.png");
//        Image image = new Image(getClass().getResource("/file.png").toString()); //new Image(input);
//        ImageView imageView = new ImageView(image);
        //******
//        Label lbl = new Label ("Start File Archiving ",imageView);
//        lbl.setTranslateX(-50);
//        lbl.setTranslateY(-115);
//        lbl.setFont(Font.font("Cambria", 32));
        //****

        Label lbl2 = new Label("Choose Archiving Configuration File  -- >> ");
        lbl2.setTranslateX(-130);
        lbl2.setTranslateY(15);
        lbl2.setFont(Font.font("Cambria", 15));

//        lbl.setMaxHeight(75);
//        lbl.setMaxWidth(200);
        //*****    
        Button button = new Button("Open Archve");
        button.setTranslateX(150);
        button.setTranslateY(15);
        button.setMaxHeight(75);
        button.setMaxWidth(200);
        button.setOnAction(e -> {
            File f = fileChooser.showOpenDialog(primaryStage);
            boolean readSuccess = false;
            try {
                readSuccess = ViewIntegrationFunctions.setExistingLibrary(f);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            if (readSuccess == false) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error...");
                alert.setHeaderText("Read error");
                alert.setContentText("Sorrry,an error occured while reading the file !!!");
                alert.showAndWait();

                return;
            }

            mainst();
            //       Stage stage = (Stage) newbtn.getScene().getWindow();
            // do what you have to do
            primaryStage.close();

//            System.out.println("ssss " + f.getAbsolutePath());
//            System.out.println(selectedDirectory.getAbsolutePath());
        });
        //********
        Button newbtn = new Button("New Archive");
        newbtn.setTranslateX(-150);
        newbtn.setTranslateY(120);
        newbtn.setMaxHeight(75);
        newbtn.setMaxWidth(200);

        newbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                // System.out.println("Hello World!");

                ViewIntegrationFunctions.setNewLibrary(true);

                System.err.println("starting new library");
                mainst();
                //       Stage stage = (Stage) newbtn.getScene().getWindow();
                // do what you have to do
                primaryStage.close();
                //this.setVisible(false);
            }
        });
        //**
//        Button opnbtn = new Button("Open Archive");
//        opnbtn.setTranslateX(150);
//        opnbtn.setTranslateY(120);
//        opnbtn.setMaxHeight(75);
//        opnbtn.setMaxWidth(200);

//        opnbtn.setOnAction(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent event) {
//                
//                directoryChooser.showDialog(primaryStage);
//                // System.out.println("Hello World!");
//                mainst();
//                //       Stage stage = (Stage) newbtn.getScene().getWindow();
//                // do what you have to do
//                primaryStage.close();
//                //this.setVisible(false);
//            }
//        });
        //*
        //*******
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//               
//                Stage stage = (Stage) btn.getScene().getWindow();
//  // do what you have to do
//  stage.close();
//                //this.setVisible(false);
//            }
//        });
        StackPane root = new StackPane();

//        root.getChildren().add(btn);
        root.getChildren().add(button);
//        root.getChildren().add(lbl);
        root.getChildren().add(newbtn);
//        root.getChildren().add(opnbtn);
        root.getChildren().add(lbl2);
//          VBox vBox = new VBox(button);
//           Scene scene = new Scene(vBox, 960, 600);
        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("Archiving System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void mainst() /*throws  FileNotFoundException */ {

        Stage Mainstage = new Stage();
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setTranslateX(55);
//        btn.setTranslateY(12);
        //******
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File("src"));
        //****** 
        //  FileInputStream input = new FileInputStream("c:/Users/maibrahim/Documents/NetBeansProjects/Archive_sys_project/src/file.png");
        // Image image = new Image(input);
        // ImageView imageView = new ImageView(image);
        //******

        //Label lbl = new Label ("File",imageView);
        //  lbl.setTranslateX(-150);
        //   lbl.setTranslateY(-40);
//        lbl.setMaxHeight(75);
//        lbl.setMaxWidth(200);
        //*****    
        Button button = new Button("Edit");
        button.setTranslateX(-300);
        button.setTranslateY(250);
        button.setMaxHeight(75);
        button.setMaxWidth(95);
        button.setOnAction(e -> {
            //    File selectedDirectory = directoryChooser.showDialog(MainStage);

            //      System.out.println(selectedDirectory.getAbsolutePath());
        });
        //********
        Button newbtn = new Button("Add New \n Document");
        newbtn.setTranslateX(-400);
        newbtn.setTranslateY(250);
        newbtn.setMaxHeight(75);
        newbtn.setMaxWidth(95);

        newbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//               
//                Stage stage = (Stage) newbtn.getScene().getWindow();
                // do what you have to do
                // stage.close();
                //this.setVisible(false);
            }
        });
        //****
        Button delbtn = new Button("Delete");
        delbtn.setTranslateX(-200);
        delbtn.setTranslateY(250);
        delbtn.setMaxHeight(75);
        delbtn.setMaxWidth(95);
        delbtn.setOnAction(e -> {
            //    File selectedDirectory = directoryChooser.showDialog(MainStage);

            //      System.out.println(selectedDirectory.getAbsolutePath());
        });
        //*******
        Button tagbtn = new Button("Tag");
        tagbtn.setTranslateX(200);
        tagbtn.setTranslateY(250);
        tagbtn.setMaxHeight(75);
        tagbtn.setMaxWidth(95);
        tagbtn.setOnAction(e -> {
            //    File selectedDirectory = directoryChooser.showDialog(MainStage);

            TagStage.newStage();
            //      System.out.println(selectedDirectory.getAbsolutePath());
        });
        //***
        Button ctgbtn = new Button("Category");
        ctgbtn.setTranslateX(300);
        ctgbtn.setTranslateY(250);
        ctgbtn.setMaxHeight(75);
        ctgbtn.setMaxWidth(95);
        ctgbtn.setOnAction(e -> {
            //    File selectedDirectory = directoryChooser.showDialog(MainStage);
            CategoryStage.newStage();
            //      System.out.println(selectedDirectory.getAbsolutePath());
        });
        //***
        Button tpcbtn = new Button("Topic");
        tpcbtn.setTranslateX(400);
        tpcbtn.setTranslateY(250);
        tpcbtn.setMaxHeight(75);
        tpcbtn.setMaxWidth(95);
        tpcbtn.setOnAction(e -> {
            //    File selectedDirectory = directoryChooser.showDialog(MainStage);
            TopicsStage.newStage();
            //      System.out.println(selectedDirectory.getAbsolutePath());
        });
        //**
        Button svbtn = new Button("Save Archive");
        svbtn.setTranslateX(400);
        svbtn.setTranslateY(-250);
        svbtn.setMaxHeight(75);
        svbtn.setMaxWidth(95);
        svbtn.setOnAction(e -> {
            //    File selectedDirectory = directoryChooser.showDialog(MainStage);

            //      System.out.println(selectedDirectory.getAbsolutePath());
        });
        //**
        ComboBox tagBox = new ComboBox();
        tagBox.setTranslateX(-200);
        tagBox.setTranslateY(-250);
        tagBox.setMaxHeight(75);
        tagBox.setMaxWidth(95);
        //----
        tagBox.setPromptText("Tag");
        //**
        ComboBox ctgBox = new ComboBox();
        ctgBox.setTranslateX(-400);
        ctgBox.setTranslateY(-250);
        ctgBox.setMaxHeight(75);
        ctgBox.setMaxWidth(95);
        //----
        ctgBox.setPromptText("Category");
        //**
        ComboBox tpcBox = new ComboBox();
        tpcBox.setTranslateX(-300);
        tpcBox.setTranslateY(-250);
        tpcBox.setMaxHeight(75);
        tpcBox.setMaxWidth(95);
        //----
        tpcBox.setPromptText("Topic");
        //*****

        TreeItem<String> rootItem = new TreeItem<String>("Document List");
        rootItem.setExpanded(true);
        for (int i = 1; i < 6; i++) {
            TreeItem<String> item = new TreeItem<String>("Message" + i);
            rootItem.getChildren().add(item);
        }
        TreeView<String> tree = new TreeView<String>(rootItem);
        tree.setTranslateX(-370);
        tree.setTranslateY(-20);
        tree.setMaxHeight(350);
        tree.setMaxWidth(150);
        //******
        TextArea textField = new TextArea();
        textField.setTranslateX(50);
        textField.setTranslateY(-20);
        textField.setMaxHeight(350);
        textField.setMaxWidth(550);
        //*****

//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//               
//                Stage stage = (Stage) btn.getScene().getWindow();
//  // do what you have to do
//  stage.close();
//                //this.setVisible(false);
//            }
//        });
        StackPane root = new StackPane();

//        root.getChildren().add(btn);
        root.getChildren().add(button);
        //  root.getChildren().add(lbl);
        root.getChildren().add(newbtn);
        root.getChildren().add(delbtn);
        root.getChildren().add(tagbtn);
        root.getChildren().add(ctgbtn);
        root.getChildren().add(tpcbtn);
        root.getChildren().add(svbtn);
        root.getChildren().add(tagBox);
        root.getChildren().add(ctgBox);
        root.getChildren().add(tpcBox);
        root.getChildren().add(tree);
        root.getChildren().add(textField);
//          VBox vBox = new VBox(button);
//           Scene scene = new Scene(vBox, 960, 600);
        Scene scene = new Scene(root, 960, 600);

        Mainstage.setTitle("Archiving System");
        Mainstage.setScene(scene);
        Mainstage.show();
    }

    /**
     * @param args the command line arguments
     */
    public void catst() /*throws  FileNotFoundException */ {

        Stage categorystage = new Stage();
//        Stage tagstage = new Stage();

        //******
//        DirectoryChooser directoryChooser = new DirectoryChooser();
//        directoryChooser.setInitialDirectory(new File("src"));
//       //****** 
        //******
        //*****    
        Button button = new Button("Edit");
        button.setTranslateX(-110);
        button.setTranslateY(150);
        button.setMaxHeight(75);
        button.setMaxWidth(95);
        button.setOnAction(e -> {
            //    File selectedDirectory = directoryChooser.showDialog(MainStage);

            //      System.out.println(selectedDirectory.getAbsolutePath());
        });
        //********
        Button newbtn = new Button("Add New");
        newbtn.setTranslateX(-220);
        newbtn.setTranslateY(150);
        newbtn.setMaxHeight(75);
        newbtn.setMaxWidth(95);

        newbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

            }
        });
        //****
        Button delbtn = new Button("Delete");
        delbtn.setTranslateX(0);
        delbtn.setTranslateY(150);
        delbtn.setMaxHeight(75);
        delbtn.setMaxWidth(95);
        delbtn.setOnAction(e -> {

        });
        //*******

        //**
        Button svbtn = new Button("Save Tag");
        svbtn.setTranslateX(220);
        svbtn.setTranslateY(-150);
        svbtn.setMaxHeight(75);
        svbtn.setMaxWidth(95);
        svbtn.setOnAction(e -> {

        });
        //**
        //*****

        TreeItem<String> rootItem = new TreeItem<String>("Tag List");
        rootItem.setExpanded(true);
        for (int i = 1; i < 6; i++) {
            TreeItem<String> item = new TreeItem<String>("Message" + i);
            rootItem.getChildren().add(item);
        }
        TreeView<String> tree = new TreeView<String>(rootItem);
        tree.setTranslateX(-190);
        tree.setTranslateY(-20);
        tree.setMaxHeight(250);
        tree.setMaxWidth(200);
        //******
        TextField textField = new TextField();
        textField.setTranslateX(50);
        textField.setTranslateY(-70);
        textField.setMaxHeight(50);
        textField.setMaxWidth(250);
        //*****

        StackPane root = new StackPane();

//        root.getChildren().add(btn);
        root.getChildren().add(button);
        //  root.getChildren().add(lbl);
        root.getChildren().add(newbtn);
        root.getChildren().add(delbtn);
        root.getChildren().add(svbtn);
        root.getChildren().add(tree);
        root.getChildren().add(textField);

        Scene scene = new Scene(root, 600, 400);

        categorystage.setTitle("Category");
        categorystage.setScene(scene);
        categorystage.show();
    }

//    public void tpcst() /*throws  FileNotFoundException */ {
//       
//    }

    public void tagst() /*throws  FileNotFoundException */ {

        Stage tagstage = new Stage();

        //******
//        DirectoryChooser directoryChooser = new DirectoryChooser();
//        directoryChooser.setInitialDirectory(new File("src"));
//       //****** 
        //******
        //*****    
        Button button = new Button("Edit");
        button.setTranslateX(-110);
        button.setTranslateY(150);
        button.setMaxHeight(75);
        button.setMaxWidth(95);
        button.setOnAction(e -> {
            //    File selectedDirectory = directoryChooser.showDialog(MainStage);

            //      System.out.println(selectedDirectory.getAbsolutePath());
        });
        //********
        Button newbtn = new Button("Add New");
        newbtn.setTranslateX(-220);
        newbtn.setTranslateY(150);
        newbtn.setMaxHeight(75);
        newbtn.setMaxWidth(95);

        newbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

            }
        });
        //****
        Button delbtn = new Button("Delete");
        delbtn.setTranslateX(0);
        delbtn.setTranslateY(150);
        delbtn.setMaxHeight(75);
        delbtn.setMaxWidth(95);
        delbtn.setOnAction(e -> {

        });
        //*******

        //**
        Button svbtn = new Button("Save Tag");
        svbtn.setTranslateX(220);
        svbtn.setTranslateY(-150);
        svbtn.setMaxHeight(75);
        svbtn.setMaxWidth(95);
        svbtn.setOnAction(e -> {

        });
        //**
        //*****

        TreeItem<String> rootItem = new TreeItem<String>("Tag List");
        rootItem.setExpanded(true);
        for (int i = 1; i < 6; i++) {
            TreeItem<String> item = new TreeItem<String>("Message" + i);
            rootItem.getChildren().add(item);
        }
        TreeView<String> tree = new TreeView<String>(rootItem);
        tree.setTranslateX(-190);
        tree.setTranslateY(-20);
        tree.setMaxHeight(250);
        tree.setMaxWidth(200);
        //******
        TextField textField = new TextField();
        textField.setTranslateX(50);
        textField.setTranslateY(-70);
        textField.setMaxHeight(50);
        textField.setMaxWidth(250);
        //*****

        StackPane root = new StackPane();

//        root.getChildren().add(btn);
        root.getChildren().add(button);
        //  root.getChildren().add(lbl);
        root.getChildren().add(newbtn);
        root.getChildren().add(delbtn);
        root.getChildren().add(svbtn);
        root.getChildren().add(tree);
        root.getChildren().add(textField);

        Scene scene = new Scene(root, 600, 400);

        tagstage.setTitle("Tag");
        tagstage.setScene(scene);
        tagstage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
