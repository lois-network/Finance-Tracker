package com.mycompany.pft;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import static javafx.application.Application.launch;


public class PFT extends Application{
    public static void main(String[] args) throws SQLException {
       
        launch(args);
    }

    @Override
    public void start(Stage stage) throws SQLException{
        DatabaseInitialiser.initialiser();
        Scene scene = new Scene(createContent());
        stage.setScene(scene);
        stage.show();
    }
    
    private Region createContent(){
        return new Label("Hello application!");
    }
    
}

