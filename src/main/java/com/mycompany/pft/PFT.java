package com.mycompany.pft;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

/**
 *
 * @author oluwabukunmi
 */
public class PFT extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        Scene scene = new Scene(createContent());
        stage.setScene(scene);
        stage.show();
    }
    
    private Region createContent(){
        return new Label("Hello application!");
    }
}
