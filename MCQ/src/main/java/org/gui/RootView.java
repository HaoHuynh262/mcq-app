package org.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.entity.Question;

public class RootView extends BorderPane {
    private final TopicTableView table;
    private final QuestionView questionView;

    private final Button btnCreateQ;
    private final Button btnCreateT;

    public RootView(Question q) {
        table = new TopicTableView();
        table.loadData();

        questionView = new QuestionView(q);

        setLeft(table);
        setCenter(questionView);

        btnCreateQ = questionView.getCreateQButton();
        btnCreateT = questionView.getCreateTButton();

        btnCreateQ.setOnAction(e -> openCreateQuestion());
        btnCreateT.setOnAction(e -> openCreateTopic());
    }

    private void openCreateQuestion() {
        Stage stage = new Stage();
        FormQuestion form = new FormQuestion(table);
        stage.setScene(new Scene(form, 600, 700));
        stage.setTitle("Create Question");
        stage.show();
    }
    private void openCreateTopic() {
        Stage stage = new Stage();
        FormTopic form = new FormTopic(table);
        stage.setScene(new Scene(form, 600, 700));
        stage.setTitle("Create Topic");
        stage.show();
    }

    public TopicTableView getTable() {return table; }
    public QuestionView getQuestionView() {return questionView; }
}