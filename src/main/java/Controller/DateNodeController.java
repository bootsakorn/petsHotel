package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import java.time.LocalDate;

public class DateNodeController extends AnchorPane {

    private LocalDate date;
    private CalendarPageController controller = new CalendarPageController();

    public DateNodeController(Node... children) {
        super(children);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
