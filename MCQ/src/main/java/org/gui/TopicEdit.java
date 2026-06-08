package org.gui;

import org.entity.Topic;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TopicEdit extends VBox {
    private TextField txtTitle;
    private TextField txtParent;
    private TextField txtStatus;
    private Button btnSave; 
    private Button btnDelete;

    public TopicEdit(Topic topic) {
        setSpacing(12);
        setPadding(new Insets(15));

        setStyle("""
                -fx-border-color: #333;
                -fx-border-width: 1;
                """);

        txtTitle = new TextField(topic.getTpTitle());
        txtParent = new TextField(String.valueOf(topic.getTpParent()));
        txtStatus = new TextField(String.valueOf(topic.getTpStatus()));

        btnSave = new Button("Save");
        btnDelete = new Button("Delete");

        HBox btn = new HBox(10, btnSave, btnDelete);
        btn.setAlignment(Pos.CENTER);

        getChildren().addAll(
            new Label("Title: "), txtTitle,
            new Label("Parent ID: "), txtParent,
            new Label("Status: "), txtStatus, btn);
    }

}
