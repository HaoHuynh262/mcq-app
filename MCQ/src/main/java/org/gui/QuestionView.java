package org.gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.entity.Question;

public class QuestionView extends VBox {
        private final Label question;
        private final Label picture;
        private final Button qa;
        private final Button qb;
        private final Button qc;
        private final Button qd;
        private final Button prev;
        private final Button next;
        private final Button createQ;
        private final Button createT;

        public QuestionView(Question q) {
                setSpacing(20);
                setAlignment(Pos.CENTER);

                question = new Label(q.getQContent());
                picture = new Label(q.getQPicture());

                qa = new Button(q.getQA());
                qb = new Button(q.getQB());
                qc = new Button(q.getQC());
                qd = new Button(q.getQD());

                HBox answers = new HBox(10, qa, qb, qc, qd);
                answers.setAlignment(Pos.CENTER);

                prev = new Button("Previous");
                next = new Button("Next");

                HBox nav = new HBox(10, prev, next);
                nav.setAlignment(Pos.CENTER);

                createQ = new Button("Create Question");
                createT = new Button("Create Topic");

                HBox Createnav = new HBox(10, createQ, createT);
                Createnav.setAlignment(Pos.CENTER);

                getChildren().addAll(question, picture, answers, nav, Createnav);

                createQ.setOnAction(e -> openCreateQuestionWindow());
        }

        private void openCreateQuestionWindow() {
                Stage stage = new Stage();
                FormCreate form = new FormCreate();
                Scene scene = new Scene(form, 600, 700);
                stage.setTitle("Create Question");
                stage.setScene(scene);
                stage.show();
        }

        public Button getCreateButton() {return createQ;}
        public Button getPrevButton() {return prev;}
        public Button getNextButton() {return next;}
}