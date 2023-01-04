package root.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import root.data.CommandeDao;
import root.data.SingleConnection;
import root.model.Tournee;

import java.net.URL;
import java.sql.Date;
import java.util.Calendar;
import java.util.ResourceBundle;

public class Calendrier implements Initializable {
  @FXML
  private GridPane calendrier;

  /**
   * @param url
   * @param resourceBundle
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    Calendar now = Calendar.getInstance();
    int month = now.get(Calendar.MONTH);
    int year = now.get(Calendar.YEAR);
    int dayNow = now.get(Calendar.DAY_OF_MONTH);

    Calendar cal = Calendar.getInstance();
    cal.set(year, month, 1);
    int firstDayOfMonth = cal.get(Calendar.DAY_OF_WEEK);
    System.out.println("firstDayOfMonth = " + firstDayOfMonth);

    int firstDay = 1;
    switch (firstDayOfMonth) {
      case Calendar.TUESDAY -> firstDay = 2;
      case Calendar.WEDNESDAY -> firstDay = 3;
      case Calendar.THURSDAY -> firstDay = 4;
      case Calendar.FRIDAY -> firstDay = 5;
      case Calendar.SATURDAY -> firstDay = 6;
      case Calendar.SUNDAY -> firstDay = 7;
    }
    int day = 1;
    System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH));

    for (int i = firstDay; i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH);i++) {
      Label label = new Label();
      VBox vBox = new VBox();
      label.setText(String.valueOf(day));
      label.setMaxWidth(Double.MAX_VALUE);
      GridPane.setHalignment(label, HPos.CENTER);
      GridPane.setHalignment(vBox, HPos.CENTER);
      label.alignmentProperty().set(Pos.CENTER);
      label.setAlignment(Pos.CENTER);
      if (day == dayNow) {
        label.setStyle("-fx-background-color: #00ff00");
      } else if (day < dayNow) {
        label.setStyle("-fx-background-color: #aaaaaa");
      } else {
        label.setStyle("-fx-background-color: #eeeeee");
      }
      if (i % 7 == 0) {
        vBox.getChildren().add(label);
        calendrier.add(vBox, 7, (i / 7));
      } else {
        vBox.getChildren().add(label);
        calendrier.add(vBox, (i % 7), i / 7 + 1);
      }
      day++;
    }
  }

  public void addDay(Tournee tournee) {
    VBox vBox = new VBox();
    Date date = new CommandeDao(SingleConnection.getInstance()).get(tournee.getNumTournee()).getDateCom();
    if (date.getTime() == Calendar.MONTH) {
      //calendrier.add(vBox, date.getTime() % 7, Calendar.MONTH / 7 + 1);
    }

  }
}
