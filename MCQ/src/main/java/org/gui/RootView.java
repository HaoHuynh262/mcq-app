package org.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.TableRow;
import org.bll.*;
import org.entity.*;

public class RootView extends BorderPane {
    private final TopicTableView table;
    private final QuestionView questionView;

    private final Button btnCreateQ;
    private final Button btnCreateT;

    public RootView() {
        try {
            table = new TopicTableView();
            table.loadData();
            QuestionBLL questionBLL = new QuestionBLL();
            Question firstQuestion = questionBLL.getFirstQuestionAvailable();
            if (firstQuestion == null) {
                firstQuestion = new Question();
                firstQuestion.setQContent("No question");
                firstQuestion.setQPicture("");
                firstQuestion.setQA("");
                firstQuestion.setQB("");
                firstQuestion.setQC("");
                firstQuestion.setQD("");
            }

            questionView = new QuestionView(firstQuestion);

            setLeft(table);
            setCenter(questionView);

            btnCreateQ = questionView.getCreateQButton();
            btnCreateT = questionView.getCreateTButton();

            table.setRowFactory(tv -> {
                TableRow<Topic> row = new TableRow<>();
                row.setOnMouseClicked(e -> {
                    if (row.isEmpty()) {
                        return;
                    }
                    Topic selected = row.getItem();
                    if (e.getClickCount() == 1) {
                        Question q = questionBLL.getFirstQuestionByTopic(selected);
                        questionView.setQuestion(q);
                    }
                    if (e.getClickCount() == 2) {
                        openEditTopic(selected);
                    }
                });
                return row;
            });

            btnCreateQ.setOnAction(e -> openCreateQuestion());
            btnCreateT.setOnAction(e -> openCreateTopic());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
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

    private void openEditTopic(Topic t) {
        Stage stage = new Stage();
        TopicEdit form = new TopicEdit(t);
        stage.setScene(new Scene(form, 600, 700));
        stage.setTitle("Edit Topic");
        stage.show();
    }

    public TopicTableView getTable() {
        return table;
    }

    public QuestionView getQuestionView() {
        return questionView;
    }
}