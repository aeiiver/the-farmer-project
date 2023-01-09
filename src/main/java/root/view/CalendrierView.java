package root.view;


import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import root.data.SingleConnection;
import root.data.TourneeDao;
import root.model.Producteur;
import root.model.Tournee;
import root.model.session.SingleSession;

/**
 * Vue du calendrier.
 */
public class CalendrierView implements Initializable {
  @FXML
  private GridPane calendrier;

  private Stage fenetre;

  /**
   * Initialise la vue.
   *
   * @param url            L'url.
   * @param resourceBundle Le bundle.
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    Calendar now = Calendar.getInstance();
    int month = now.get(Calendar.MONTH);
    int year = now.get(Calendar.YEAR);

    Calendar cal = Calendar.getInstance();
    cal.set(year, month, 1);
    int firstDayOfMonth = cal.get(Calendar.DAY_OF_WEEK);

    Producteur producteur = (Producteur) SingleSession.getSession().getUtilisateur();

    ArrayList<Tournee> tournees = new TourneeDao(
        SingleConnection.getInstance()).getTourneeCourante(producteur);
    ArrayList<Integer> datesTournees = new ArrayList<>();
    for (Tournee tournee : tournees) {
      Date date = tournee.getCommandes().get(0).getDateCom();
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(date);
      int monthCommande = calendar.get(Calendar.MONTH);
      if (monthCommande == month) {
        datesTournees.add(calendar.get(Calendar.DAY_OF_MONTH));
      }
    }

    int firstDay = 1;
    switch (firstDayOfMonth) {
      case Calendar.TUESDAY -> firstDay = 2;
      case Calendar.WEDNESDAY -> firstDay = 3;
      case Calendar.THURSDAY -> firstDay = 4;
      case Calendar.FRIDAY -> firstDay = 5;
      case Calendar.SATURDAY -> firstDay = 6;
      default -> firstDay = 7;
    }
    int day = 1;

    int dayNow = now.get(Calendar.DAY_OF_MONTH);
    for (int i = firstDay; i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH) + dayNow; i++) {
      Label label = new Label();
      label.setText(String.valueOf(day));
      label.setMaxWidth(Double.MAX_VALUE);
      GridPane.setHalignment(label, HPos.CENTER);
      VBox vbox = new VBox();
      GridPane.setHalignment(vbox, HPos.CENTER);
      label.alignmentProperty().set(Pos.CENTER);
      label.setAlignment(Pos.CENTER);
      if (day == dayNow) {
        label.setStyle("-fx-background-color: #1AF237");
      } else if (day < dayNow) {
        label.setStyle("-fx-background-color: #AAAAAA");
      } else if (datesTournees.contains(day)) {
        label.setStyle("-fx-background-color: #F21A1A");
      } else {
        label.setStyle("-fx-background-color: #EEEEEE");
      }
      if (i % 7 == 0) {
        vbox.getChildren().add(label);
        calendrier.add(vbox, 7, (i / 7));
      } else {
        vbox.getChildren().add(label);
        calendrier.add(vbox, (i % 7), i / 7 + 1);
      }
      day++;
    }
  }
}
