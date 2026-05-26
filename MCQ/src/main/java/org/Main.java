package org;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
// wtf mat cai view roi
import org.gui.QuestionView;
import org.gui.RootView;
import org.gui.TopicTableView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        // tạo các view con
        TopicTableView tableView = new TopicTableView();
        QuestionView questionView = new QuestionView();
        // truyền vào RootView

        RootView rootView = new RootView(tableView, questionView);

        // scene
        Scene scene = new Scene(rootView, 900, 600);

        primaryStage.setTitle("Quiz App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}