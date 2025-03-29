package io.github.gleidsonmt.dashboardfx.dashboard;

import io.github.gleidsonmt.dashboardfx.Main;
import io.github.gleidsonmt.glad.controls.icon.Icon;
import io.github.gleidsonmt.glad.controls.icon.SVGIcon;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  28/03/2025
 */
public class Aside extends VBox {

    public Aside() {
        getChildren().addAll(
                header(),
                createBlock("Appearance", "Set or customize your preferences for the system"),
                createBlock("Language", "Select the language of the platform", createCombo())

        );
        setPadding(new Insets(20));
        getStyleClass().addAll("bg-white", "border-l-2", "border-light-gray-2");
    }

    private ComboBox createCombo() {
        ComboBox comboBox= new ComboBox();
        comboBox.setItems(FXCollections.observableArrayList("English"));
        return comboBox;
    }

    private Node createBlock(String _title, String _legend) {
        return createBlock(_title, _legend, null);
    }

    private Node createBlock(String _title, String _legend, Node node) {
        Text title = new Text(_title);
        title.getStyleClass().addAll("h5", "bold");
        Text legend = new Text(_legend);
        legend.getStyleClass().addAll("h6");

        GridPane grid = new GridPane();
        Separator separator = new Separator();
//        grid.setGridLinesVisible(true);
        grid.add(title, 0,0);
        grid.add(legend, 0,1);
        grid.add(separator, 0,2, GridPane.REMAINING,1);


        if (node != null) {
           grid.add(node, 1,1);
        }
        grid.setVgap(10);
        grid.setHgap(10);
        return grid;
    }

    private HBox header() {
        Button close = new Button();
        close.setGraphic(new SVGIcon(Icon.CLEAR));
        close.getStyleClass().addAll("size-30", "bg-light-gray", "round", "border-light-gray-2");
        close.setStyle("-icon-color: -dark-gray;");
        HBox box = new HBox(close);
        box.setAlignment(Pos.CENTER_RIGHT);
        close.setOnAction(e -> {
            Main main = (Main) getScene().getRoot();
            main.wrapper().hide();
            main.flow().remove(this);
        });
        return box;
    }

}
