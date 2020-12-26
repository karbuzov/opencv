package org.arb;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.arb.db.SQLite;

import java.sql.SQLException;


public class App extends Application {

    private static OpenCvTest openCvTest;
    private SQLite sqLiteDB;

    public static void main(String[] args) {
        openCvTest = new OpenCvTest();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        createUI(primaryStage);

        sqLiteDB = new SQLite();
        sqLiteDB.connect("jdbc:sqlite:D:/projects/java/opencv/sqlite.db");

        try {
            sqLiteDB.createNewTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        schedule();
    }

    private void createUI(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        String res = "ok";


        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                takePhoto();
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.setTitle("Face Detection and Tracking");
        primaryStage.show();
    }

    private void schedule() {
//        Timeline timeline =
//                new Timeline(new KeyFrame(Duration.seconds(30), e -> {
//                    takePhoto();
//                }));
//        timeline.setCycleCount(Animation.INDEFINITE); // loop forever
//        timeline.play();
    }

    private void takePhoto() {
        try {
            int facesFound = 0;
            boolean faceExists = openCvTest.processImage2();
            if (faceExists) {
                facesFound = 1;
            }
            sqLiteDB.insertActivity(facesFound);
        } catch (Exception er) {
            System.err.println(er);
        }
    }
}
