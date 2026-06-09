package org.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableRow;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import org.bll.QuestionBLL;
import org.entity.Question;
import org.entity.Topic;

import java.util.ArrayList;
import java.util.List;

public class RootView extends BorderPane {
    private final TopicTableView table;
    private final QuestionView questionView;
    private final QuestionBLL questionBLL = new QuestionBLL();
    private List<Question> currentQuestions = new ArrayList<>();
    private int currentIndex = -1;

    private final Button btnCreateQ;
    private final Button btnCreateT;

    public RootView() {
        table = new TopicTableView();
        table.loadData();

        Question firstQuestion = questionBLL.getFirstQuestionAvailable();
        if (firstQuestion == null) {
            firstQuestion = new Question();
            firstQuestion.setQContent("No question");
            firstQuestion.setQPicture("");
            firstQuestion.setQA("");
            firstQuestion.setQB("");
            firstQuestion.setQC("");
            firstQuestion.setQD("");
        } else {
            currentQuestions = questionBLL.getQuestionsByTopic(firstQuestion.getTopic());
            currentIndex = 0;
        }
        questionView = new QuestionView(firstQuestion);

        setLeft(table);
        setCenter(questionView);

        btnCreateQ = questionView.getCreateQButton();
        btnCreateT = questionView.getCreateTButton();

        questionView.getPrevButton().setOnAction(e -> showPrevious());
        questionView.getNextButton().setOnAction(e -> showNext());

        table.setRowFactory(tv -> {
            TableRow<Topic> row = new TableRow<>();
            row.setOnMouseClicked(e -> {
                if (row.isEmpty())
                    return;
                Topic selected = row.getItem();
                if (e.getClickCount() == 2) {
                    openEditTopic(selected);
                    return;
                }
                if (e.getClickCount() == 1) {
                    currentQuestions = questionBLL.getQuestionsByTopic(selected);
                    if (currentQuestions.isEmpty()) {
                        currentIndex = -1;
                        questionView.setQuestion(null);
                    } else {
                        currentIndex = 0;
                        questionView.setQuestion(currentQuestions.get(currentIndex));
                    }
                }
            });
            return row;
        });

        btnCreateQ.setOnAction(e -> openCreateQuestion());
        btnCreateT.setOnAction(e -> openCreateTopic());
    }
    private void showPrevious() {
        if (currentQuestions.isEmpty())
            return;
        if (currentIndex > 0) {
            currentIndex--;
            questionView.setQuestion(currentQuestions.get(currentIndex));
        }
    }
    private void showNext() {
        if (currentQuestions.isEmpty())
            return;
        if (currentIndex < currentQuestions.size() - 1) {
            currentIndex++;
            questionView.setQuestion(currentQuestions.get(currentIndex));
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
    private void openEditTopic(Topic topic) {
        Stage stage = new Stage();
        TopicEdit form = new TopicEdit(topic);

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