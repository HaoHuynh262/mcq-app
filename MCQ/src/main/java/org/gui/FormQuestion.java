package org.gui;

import org.entity.*;
import org.bll.*;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FormQuestion extends VBox {
    private TextArea txtContent;
    private TextField txtPicture;
    private TextField topicTitle;

    private TextField txtA;
    private TextField txtB;
    private TextField txtC;
    private TextField txtD;

    private ComboBox<String> cbAnswer;
    private ComboBox<String> cbStatus;
    private ComboBox<String> cbLevel;

    private Button btnBrowse;
    private Button btnSave;

    private final TopicTableView topicTable;

    public FormQuestion(TopicTableView topicTable) {
        this.topicTable = topicTable;

        setSpacing(12);
        setPadding(new Insets(15));

        setStyle("""
                -fx-border-color: #333;
                -fx-border-width: 1;
                """);

        txtContent = new TextArea();
        txtContent.setPromptText("Question content...");

        HBox pictureBox = new HBox(10);
        pictureBox.setAlignment(Pos.CENTER_LEFT);

        txtPicture = new TextField();
        txtPicture.setPromptText("Picture path...");

        btnBrowse = new Button("Browse");

        pictureBox.getChildren().addAll(txtPicture, btnBrowse);

        txtA = new TextField();
        txtA.setPromptText("Option A");

        txtB = new TextField();
        txtB.setPromptText("Option B");

        txtC = new TextField();
        txtC.setPromptText("Option C");

        txtD = new TextField();
        txtD.setPromptText("Option D");

        cbAnswer = new ComboBox<>();
        cbAnswer.getItems().addAll("A", "B", "C", "D");
        cbAnswer.setPromptText("Correct Answer");

        topicTitle = new TextField();
        topicTitle.setPromptText("Topic Title");

        cbStatus = new ComboBox<>();
        cbStatus.getItems().addAll("ACTIVE", "INACTIVE");
        cbStatus.setValue("ACTIVE");

        cbLevel = new ComboBox<>();
        cbLevel.getItems().addAll("EASY", "MEDIUM", "HARD");
        cbLevel.setValue("EASY");

        btnSave = new Button("Save Question");

        HBox btnBox = new HBox(btnSave);
        btnBox.setAlignment(Pos.CENTER_RIGHT);

        getChildren().addAll(
                new Label("Content"),
                txtContent,

                new Label("Picture"),
                pictureBox,

                new Label("Options"),
                txtA, txtB, txtC, txtD,

                new Label("Correct Answer"),
                cbAnswer,

                new Label("Topic"),
                topicTitle,

                new Label("Status"),
                cbStatus,

                new Label("Level"),
                cbLevel,

                btnBox);

        btnSave.setOnAction(e -> {
            try {
                Question q = new Question();
                q.setQContent(txtContent.getText());
                q.setQPicture(txtPicture.getText());
                q.setQA(txtA.getText());
                q.setQB(txtB.getText());
                q.setQC(txtC.getText());
                q.setQD(txtD.getText());
                q.setQRight(cbAnswer.getValue());
                q.setQLevel(cbLevel.getValue());
                q.setQStatus("ACTIVE".equals(cbStatus.getValue()) ? 1 : 0);
                QuestionBLL bll = new QuestionBLL();
                bll.createQuestion(q, topicTitle.getText().trim());

                topicTable.loadData();

                new Alert(Alert.AlertType.INFORMATION, "Question created successfully");
                ((Stage) btnSave.getScene().getWindow()).close();
            } catch (Exception ex) {
                new Alert(Alert.AlertType.ERROR, ex.getMessage()).showAndWait();
            }
        });
    }
}