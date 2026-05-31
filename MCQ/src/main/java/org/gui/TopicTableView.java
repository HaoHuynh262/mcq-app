package org.gui;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.entity.Topic;

public class TopicTableView extends TableView<Topic> {
        public TopicTableView() {
                TableColumn<Topic, Integer> cotId = new TableColumn<>("ID");
                cotId.setCellValueFactory(new PropertyValueFactory<>("tpID"));

                TableColumn<Topic, String> cotTitle = new TableColumn<>("Title");
                cotTitle.setCellValueFactory(new PropertyValueFactory<>("tpTitle"));

                TableColumn<Topic, Integer> cotParent = new TableColumn<>("Parent");
                cotParent.setCellValueFactory(new PropertyValueFactory<>("tpParent"));

                TableColumn<Topic, Integer> cotStatus = new TableColumn<>("Status");
                cotStatus.setCellValueFactory(new PropertyValueFactory<>("tpStatus"));

                getColumns().addAll(cotId, cotTitle, cotParent, cotStatus);
                setPrefWidth(300);
        }
}