package org.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import org.bll.TopicBLL;
import org.entity.Topic;

public class TopicTableView extends TableView<Topic> {
        private final ObservableList<Topic> data = FXCollections.observableArrayList();
        public TopicTableView() {
                TableColumn<Topic, Integer> cotId = new TableColumn<>("ID");
                cotId.setCellValueFactory(new PropertyValueFactory<>("tpID"));

                TableColumn<Topic, String> cotTitle = new TableColumn<>("Title");
                cotTitle.setCellValueFactory(new PropertyValueFactory<>("tpTitle"));

                TableColumn<Topic, Integer> cotParent = new TableColumn<>("Parent");
                cotParent.setCellValueFactory(new PropertyValueFactory<>("tpParent"));

                TableColumn<Topic, Integer> cotStatus = new TableColumn<>("Status");
                cotStatus.setCellValueFactory(new PropertyValueFactory<>("tpStatus"));

                cotId.setPrefWidth(50);
                cotTitle.setPrefWidth(120);
                cotParent.setPrefWidth(70);
                cotStatus.setPrefWidth(70);

                getColumns().addAll(cotId, cotTitle, cotParent, cotStatus);
                setPrefWidth(310);

                setItems(data);
        }

        public void loadData() {
                TopicBLL bll = new TopicBLL();
                data.setAll(bll.getAllTopics());
                refresh();
        }
}