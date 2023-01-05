package root.model;

import com.gluonhq.maps.MapLayer;
import com.gluonhq.maps.MapPoint;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.util.Pair;

/**
 * Implémentation de {@link MapLayer} pour représenter une couche de marqueurs.
 */
public class PoiLayer extends MapLayer {

  private final ObservableList<Pair<MapPoint, Node>> marqueurs;

  public PoiLayer() {
    marqueurs = FXCollections.observableArrayList();
  }

  /**
   * Positionne les marqueurs sur la vue en fonction de l'état de la carte et des coordonnées des
   * points.
   *
   * <p>Cette méthode est appelée à chaque fois que l'utilisateur déplace le centre de la carte ou
   * change le niveau de zoom.</p>
   */
  @Override
  protected void layoutLayer() {
    for (Pair<MapPoint, Node> pair : marqueurs) {
      MapPoint mapPoint = pair.getKey();
      Node marqueur = pair.getValue();

      Point2D point = baseMap.getMapPoint(mapPoint.getLatitude(), mapPoint.getLongitude());
      marqueur.setTranslateX(point.getX());
      marqueur.setTranslateY(point.getY());
    }
  }

  /**
   * Fixe un élément JavaFX sur la couche aux coordonnées spécifiées.
   *
   * @param point   Le point contenant les coordonnées.
   * @param element L'élément JavaFX à ajouter.
   */
  public void addMarqueur(MapPoint point, Node element) {
    marqueurs.add(new Pair<>(point, element));
    getChildren().add(element);
    markDirty();
  }

  /**
   * Efface tous les marqueurs placés sur la couche.
   */
  public void effacerMarqueurs() {
    marqueurs.clear();
    getChildren().clear();
    markDirty();
  }

}
