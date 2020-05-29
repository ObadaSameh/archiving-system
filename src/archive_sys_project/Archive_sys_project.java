/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archive_sys_project;

//import java.awt.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

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
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File("src"));
       //****** 
//        FileInputStream input = new FileInputStream("c:/Users/maibrahim/Documents/NetBeansProjects/Archive_sys_project/src/file.png");
        Image image = new Image(getClass().getResource("/file.png").toString()); //new Image(input);
        ImageView imageView = new ImageView(image);
        //******
        
        Label lbl = new Label ("File",imageView);
        lbl.setTranslateX(-150);
        lbl.setTranslateY(-40);
//        lbl.setMaxHeight(75);
//        lbl.setMaxWidth(200);
    //*****    
        Button button = new Button("Select File");
        button.setTranslateX(150);
        button.setTranslateY(-50);
        button.setMaxHeight(75);
        button.setMaxWidth(200);
         button.setOnAction(e -> {
            File selectedDirectory = directoryChooser.showDialog(primaryStage);

            System.out.println(selectedDirectory.getAbsolutePath());
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
              mainst(); 
         //       Stage stage = (Stage) newbtn.getScene().getWindow();
  // do what you have to do
  primaryStage.close();
                //this.setVisible(false);
            }
        });
        
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
        root.getChildren().add(lbl);
        root.getChildren().add(newbtn);
//          VBox vBox = new VBox(button);
//           Scene scene = new Scene(vBox, 960, 600);
        Scene scene = new Scene(root, 600, 400);
        
        primaryStage.setTitle("Archiving System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    
    public void mainst() /*throws  FileNotFoundException */{
         
         Stage Mainstage=new Stage();
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
         
         TreeItem<String> rootItem = new TreeItem<String> ("Document List");
        rootItem.setExpanded(true);
        for (int i = 1; i < 6; i++) {
            TreeItem<String> item = new TreeItem<String> ("Message" + i);            
            rootItem.getChildren().add(item);
        }        
        TreeView<String> tree = new TreeView<String> (rootItem); 
        tree.setTranslateX(-370);
        tree.setTranslateY(-20);
         tree.setMaxHeight(350);
        tree.setMaxWidth(150);
         //******
         TextArea  textField = new TextArea  ();
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
    public static void main(String[] args) {
        launch(args);
    }
    
}
