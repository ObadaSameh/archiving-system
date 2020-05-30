/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archive_sys_project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author maibrahim
 */
public class edit_doc_stage {
          public void edit_doc_stage() /*throws  FileNotFoundException */{
            Stage edit_doc_stage=new Stage();

        //******
//        DirectoryChooser directoryChooser = new DirectoryChooser();
//        directoryChooser.setInitialDirectory(new File("src"));
//       //****** 
 
        //******
        
        
    //*****    
        Button button = new Button("Topic");
        button.setTranslateX(-110);
        button.setTranslateY(150);
        button.setMaxHeight(75);
        button.setMaxWidth(95);
         button.setOnAction(e -> {
        //    File selectedDirectory = directoryChooser.showDialog(MainStage);

      //      System.out.println(selectedDirectory.getAbsolutePath());
        });
         //********
         Button newbtn = new Button("Category");
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
        Button delbtn = new Button("Tag");
        delbtn.setTranslateX(0);
        delbtn.setTranslateY(150);
        delbtn.setMaxHeight(75);
        delbtn.setMaxWidth(95);
         delbtn.setOnAction(e -> {
  
        });
         //*******
          Button selectbtn = new Button("Select File");
        selectbtn.setTranslateX(0);
        selectbtn.setTranslateY(150);
        selectbtn.setMaxHeight(75);
        selectbtn.setMaxWidth(95);
         selectbtn.setOnAction(e -> {
  
        });
       
         //**
          Button svbtn = new Button("Save");
        svbtn.setTranslateX(220);
        svbtn.setTranslateY(-150);
        svbtn.setMaxHeight(75);
        svbtn.setMaxWidth(95);
         svbtn.setOnAction(e -> {
      
        });
         //**
         //*****
         
         
       
         //******
         TextField  textField = new TextField  ();
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
       
        root.getChildren().add(textField);

        Scene scene = new Scene(root, 600, 400);
        
       edit_doc_stage.setTitle("Add/Edit");
        edit_doc_stage.setScene(scene);
        edit_doc_stage.show();
    }
}
