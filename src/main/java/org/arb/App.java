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

        schedule();
    }

    private void schedule() {
        Timeline timeline =
                new Timeline(new KeyFrame(Duration.seconds(30), e -> {
                    try {
                        openCvTest.test();
                    } catch (Exception er) {
                        System.err.println(er);
                    }
                }
                ));
        timeline.setCycleCount(Animation.INDEFINITE); // loop forever
        timeline.play();
    }
}
