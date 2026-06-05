package org.gui;

import javafx.scene.layout.BorderPane;
import org.entity.Question;

public class RootView extends BorderPane {
    private final TopicTableView table;
    private final QuestionView questionView;

    public RootView(Question q) {
        table = new TopicTableView();
        questionView = new QuestionView(q);

        setTop(table);
        setCenter(questionView);

        table.loadData();
    }

    public TopicTableView getTable() {return table;}
    public QuestionView getQuestionView() {return questionView;}
}