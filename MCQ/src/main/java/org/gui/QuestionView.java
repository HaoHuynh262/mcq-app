package org.gui;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import org.entity.Question;
import javafx.scene.layout.Region;

public class QuestionView extends VBox {
        private final Label question;
        private final Label picture;

        private final Button qa;
        private final Button qb;
        private final Button qc;
        private final Button qd;

        private final Button prev;
        private final Button next;

        private final Button btnCreateQ;
        private final Button btnCreateT;

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

                VBox questionBox = new VBox(20, question, picture, answers);

                questionBox.setAlignment(Pos.CENTER);
                questionBox.setStyle("""
                                -fx-border-color: #333;
                                -fx-border-width: 2;
                                -fx-padding: 30;
                                -fx-background-color: white;
                                -fx-border-radius: 10;
                                """);
                questionBox.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

                prev = new Button("Previous");
                next = new Button("Next");

                HBox nav = new HBox(10, prev, next);
                nav.setAlignment(Pos.CENTER);

                btnCreateQ = new Button("Create Question");
                btnCreateT = new Button("Create Topic");

                HBox createBox = new HBox(10, btnCreateQ, btnCreateT);
                createBox.setAlignment(Pos.CENTER);

                getChildren().addAll(questionBox, nav, createBox);
        }

        public void setQuestion(Question q) {
                if (q == null) {
                        question.setText("No question");
                        picture.setText("");

                        qa.setText("");
                        qb.setText("");
                        qc.setText("");
                        qd.setText("");
                        return;
                }

                question.setText(q.getQContent());
                picture.setText(q.getQPicture());
                qa.setText(q.getQA());
                qb.setText(q.getQB());
                qc.setText(q.getQC());
                qd.setText(q.getQD());
        }
        public Button getCreateQButton() {
                return btnCreateQ;
        }
        public Button getCreateTButton() {
                return btnCreateT;
        }
        public Button getPrevButton() {
                return prev;
        }
        public Button getNextButton() {
                return next;
        }
}