package Controller;

import Controller.dataController.DataController;
import Models.Reserve;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;

public class CalendarPageController extends PageSwitchController{
    @FXML protected Text dateInList;
    @FXML protected GridPane calendarTable;
    @FXML protected ListView listView;
    @FXML protected Button previousBtn;
    @FXML protected Button nextBtn;
    @FXML protected Text monthText;
    @FXML protected AnchorPane previousPane;

    private ArrayList<DateNodeController> allCalendarDays = new ArrayList<>(35);
    private YearMonth currentYearMonth;
    private DataController dataController;
    private ArrayList<Reserve> reserves;

    public CalendarPageController(){
        try {
            dataController = new DataController();
            reserves = dataController.getReserves();
            previousPane = new AnchorPane();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML private void initialize()throws ClassNotFoundException {
        dateInList.setText(LocalDate.now().toString());
        currentYearMonth = YearMonth.now();

        // Create rows and columns with anchor panes for the calendar
        createGridCalendar();
        // Days of the week labels
        Text[] dayNames = new Text[]{ new Text("SUN"), new Text("MON"), new Text("TUE"),
                new Text("WED"), new Text("THU"), new Text("FRI"),
                new Text("SAT") };

        Integer col = 0;
        for (Text txt : dayNames) {
            AnchorPane ap = new AnchorPane();
            ap.setPrefSize(200, 50);
            ap.setTopAnchor(txt, 8.0);
            ap.setLeftAnchor(txt, 15.0);
            ap.setStyle("-fx-background-color: #dcddff;");
            ap.getChildren().add(txt);
            calendarTable.add(ap, col++, 0);
        }

        populateCalendar(YearMonth.now());
    }

    private void createGridCalendar() {
        for (int i = 1; i <= 5; i++)
            for (int j = 0; j < 7; j++) {
                DateNodeController ap = new DateNodeController();
                ap.setOnMouseClicked((MouseEvent event) -> showListOnSelectedDate(ap.getDate(),event));
                ap.setPrefSize(200, 200);
                calendarTable.add(ap, j, i);
                allCalendarDays.add(ap);
            }
    }

    /**
     * Set the days of the calendar to correspond to the appropriate date
     * @param yearMonth year and month of month to render
     */
    public void populateCalendar(YearMonth yearMonth) {
        // Get the date we want to start with on the calendar
        LocalDate calendarDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonthValue(), 1);
        // Dial back the day until it is SUNDAY (unless the month starts on a sunday)
        while (!calendarDate.getDayOfWeek().toString().equals("SUNDAY") ) {
            calendarDate = calendarDate.minusDays(1);
        }
        // Populate the calendar with day numbers
        for (DateNodeController ap : allCalendarDays) {
            if (ap.getChildren().size() != 0) {
                ap.getChildren().remove(0);
            }
            Text txt = new Text(String.valueOf(calendarDate.getDayOfMonth()));
            ap.setDate(calendarDate);
            ap.setTopAnchor(txt, 5.0);
            ap.setRightAnchor(txt, 5.0);
            ap.getChildren().add(txt);

            calendarDate = calendarDate.plusDays(1);
        }
        // Change the title of the calendar
        String title = yearMonth.getMonth().toString() + " " + String.valueOf(yearMonth.getYear());
        monthText.setText(title);
    }

    public void handleOnclickPreviousBtn(ActionEvent e) {
        currentYearMonth = currentYearMonth.minusMonths(1);
        populateCalendar(currentYearMonth);
    }

    public void handleOnclickNextBtn(ActionEvent e) {
        currentYearMonth = currentYearMonth.plusMonths(1);
        populateCalendar(currentYearMonth);
    }

    public void showListOnSelectedDate(LocalDate date, MouseEvent event){
        AnchorPane pane = (AnchorPane) event.getSource();
        previousPane.setStyle("");
        pane.setStyle("-fx-background-color: #ffdab9;");
        ObservableList<String> list = FXCollections.observableArrayList(
              "น้องโตโต้เช็คอิน", "น้องไอซ์เช็คอิน", "น้องฟุ้คเช็คเอ้าท์"
        );
        listView.setItems(list);
        dateInList.setText(date.toString());
        System.out.println("This pane's date is: " + date);
        previousPane = pane;
    }
}
