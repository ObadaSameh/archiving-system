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

            DocumentsStage.newStage();
            //       Stage stage = (Stage) newbtn.getScene().getWindow();
            // do what you have to do
            primaryStage.close();

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
                DocumentsStage.newStage();
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

    public static void main(String[] args) {
        launch(args);
    }

}
