package org.gui;

import org.entity.*;
import org.bll.*;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FormTopic extends VBox {
    private TextField txtTitle;
    private TextField txtParent;
    private TextField txtStatus;
    private Button btnSave;

    private final TopicTableView topicTable;

    public FormTopic(TopicTableView topicTable) {
        this.topicTable = topicTable;

        setSpacing(12);
        setPadding(new Insets(15));

        setStyle("""
                -fx-border-color: #333;
                -fx-border-width: 1;
                """);

        txtTitle = new TextField();
        txtTitle.setPromptText("Topic title...");

        txtParent = new TextField();
        txtParent.setPromptText("Parent topic ID...");
        txtParent.setTextFormatter(
                new TextFormatter<>(change -> change.getControlNewText().matches("\\d*") ? change : null));

        txtStatus = new TextField();
        txtStatus.setPromptText("Status (0 or 1)...");
        txtStatus.setTextFormatter(
                new TextFormatter<>(change -> change.getControlNewText().matches("\\d*") ? change : null));

        btnSave = new Button("Save");
        btnSave.setOnAction(e -> {
            try {
                if (txtTitle.getText().isBlank()) {
                    new Alert(Alert.AlertType.ERROR, "Title cannot be empty!").showAndWait();
                    return;
                }
                if (txtParent.getText().isBlank() || txtStatus.getText().isBlank()) {
                    new Alert(Alert.AlertType.ERROR, "Không được để trống!").showAndWait();
                    return;
                }
                Topic t = new Topic();
                t.setTpTitle(txtTitle.getText());
                t.setTpParent(Integer.parseInt(txtParent.getText()));
                t.setTpStatus(Integer.parseInt(txtStatus.getText()));

                TopicBLL bll = new TopicBLL();
                bll.createTopic(t);

                topicTable.loadData();
                ((Stage) btnSave.getScene().getWindow()).close();
            } catch (Exception ex) {
                new Alert(Alert.AlertType.ERROR, ex.getMessage()).showAndWait();
            }
        });

        getChildren().addAll(
                new Label("Label: "), txtTitle,
                new Label("Parent ID: "), txtParent,
                new Label("Status: "), txtStatus,
                btnSave);
    }

}
