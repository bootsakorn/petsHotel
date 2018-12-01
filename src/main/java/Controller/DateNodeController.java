package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DateNodeController extends AnchorPane {

    private LocalDate date;
    private CalendarPageController controller = new CalendarPageController();

    public DateNodeController(Node... children) {
        super(children);
        // Add action handler for mouse clicked
//        this.setOnMouseClicked(e -> controller.showListOnSelectedDate(date));
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList(
                "น้องโตโต้เช็คอิน", "น้องไอซ์เช็คอิน", "น้องฟุ้คเช็คเอ้าท์"
        );
        controller.listView.setItems(list);
        System.out.println("This pane's date is: " + date);
    }
}
