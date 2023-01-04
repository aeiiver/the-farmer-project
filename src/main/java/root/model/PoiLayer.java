package root.model;

import com.gluonhq.maps.MapLayer;
import com.gluonhq.maps.MapPoint;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.util.Pair;

public class PoiLayer extends MapLayer {

  private ObservableList<Pair<MapPoint, Node>> points;

  public PoiLayer() {
    points = FXCollections.observableArrayList();
  }

  @Override
  protected void layoutLayer() {
    for (Pair<MapPoint, Node> candidate : points) {
      MapPoint point = candidate.getKey();
      Node icon = candidate.getValue(); // new Circle(5, Color.BLUE)

      Point2D mapPoint = baseMap.getMapPoint(point.getLatitude(), point.getLongitude());
      icon.setTranslateX(mapPoint.getX());
      icon.setTranslateY(mapPoint.getY());

      getChildren().add(icon);
    }
  }

  public void addPoint(MapPoint point, Node node) {
    points.add(new Pair<>(point, node));
  }

}
