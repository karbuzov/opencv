package org.arb;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    private static OpenCvTest openCvTest;

    public static void main(String[] args) {
        openCvTest = new OpenCvTest();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        String res = "ok";
        try {
            openCvTest.test();
        } catch (Exception e) {
            res = e.getMessage();
            System.err.println(res);
        }


        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String res = "ok";
                try {
                    openCvTest.test();
                } catch (Exception e) {
                    res = e.getMessage();
                }
                System.out.println(res);
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.setTitle("Face Detection and Tracking");
        primaryStage.show();
    }}
