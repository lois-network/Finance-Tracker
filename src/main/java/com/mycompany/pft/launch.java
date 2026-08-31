package com.mycompany.pft;

import java.sql.SQLException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.stage.Stage;


public class launch extends Application{
    public static void main(String[] args) throws SQLException {
        CreateLink.getConnection();
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

