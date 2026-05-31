package org.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
        private final Button create;
        
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

                create = new Button("Create");
                getChildren().addAll(question, picture, answers, nav,  create);
        }

        public Button getCreateButton() {return create;}
        public Button getPrevButton() {return prev;}
        public Button getNextButton() {return next;}
}