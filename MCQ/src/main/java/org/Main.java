package org;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.gui.RootView;

public class Main extends Application {
        @Override
        public void start(Stage stage) {
                RootView root = new RootView();
                Scene scene = new Scene(root, 1200, 700);

                stage.setTitle("Quiz App");
                stage.setScene(scene);
                stage.show();
        }

        public static void main(String[] args) {
                launch();
        }
}