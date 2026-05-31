package org.gui; 

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class FormCreate extends VBox {
    private TextArea txtContent;
    private TextField txtPicture;

    private TextField txtA, txtB, txtC, txtD;

    private ComboBox<String> cbAnswer;
    private ComboBox<String> cbTopic;
    private ComboBox<String> cbStatus;
    private ComboBox<String> cbLevel;

    private Button btnBrowse;
    private Button btnSave;

    public FormCreate() {
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

        cbTopic = new ComboBox<>();
        cbTopic.setPromptText("Topic");

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
                cbTopic,

                new Label("Status"),
                cbStatus,

                new Label("Level"),
                cbLevel,

                btnBox
        );
    }
}
