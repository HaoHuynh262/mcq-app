package org;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.entity.Question;
import org.gui.RootView;

public class Main extends Application {
        @Override
        public void start(Stage stage) {
                Question q = new Question();

                q.setQContent("Câu hỏi ?");
                q.setQPicture("Ảnh ở đây");
                q.setQA("Đáp án A");
                q.setQB("Đáp án B");
                q.setQC("Đáp án C");
                q.setQD("Đáp án D");

                RootView root = new RootView(q);
                Scene scene = new Scene(root, 1200, 700);

                stage.setTitle("Quiz App");
                stage.setScene(scene);
                stage.show();
        }

        public static void main(String[] args) {
                launch();
        }
}