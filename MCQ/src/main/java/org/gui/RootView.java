package org.gui;

import javafx.scene.layout.BorderPane;
import org.entity.Question;

public class RootView extends BorderPane {
    private final TopicTableView table;
    private final QuestionView questionView;
    private final FormCreate formCreate;

    public RootView(Question q) {
        table = new TopicTableView();
        questionView = new QuestionView(q);
        formCreate = new FormCreate();

        setLeft(table);
        setCenter(questionView);

        formCreate.setVisible(false);
        formCreate.setManaged(false);

        setRight(formCreate);

        questionView.getCreateButton().setOnAction(e -> {
            boolean show = !formCreate.isVisible();

            formCreate.setVisible(show);
            formCreate.setManaged(show);
        });
    }

    public TopicTableView getTable() {
        return table;
    }

    public QuestionView getQuestionView() {
        return questionView;
    }

    public FormCreate getFormCreate() {
        return formCreate;
    }
}