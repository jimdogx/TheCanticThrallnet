package com.theornithologist.thecanticthrallnet;

import com.theornithologist.thecanticthrallnet.datahandling.DataParser;
import com.theornithologist.thecanticthrallnet.datahandling.DatabaseUpdater;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        DataParser dataParser = new DataParser();
        DatabaseUpdater databaseUpdater = new DatabaseUpdater();
        databaseUpdater.generateDB();
        databaseUpdater.initializeTable();
        databaseUpdater.populateData();
//        dataParser.parseData(FileConstants.DATASHEETS_FILE);
//        databaseUpdater.populateFactions();
//        databaseUpdater.populateUpdateTime();
//        databaseUpdater.fileUpdate();

    }

    public static void main(String[] args) {
        launch();
    }
}