package io.github.gleidsonmt.dashboardfx.breadcrumb;

import io.github.gleidsonmt.dashboardfx.drawer.Module;
import io.github.gleidsonmt.dashboardfx.drawer.View;
import io.github.gleidsonmt.glad.controls.icon.Icon;
import io.github.gleidsonmt.glad.controls.icon.SVGIcon;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Circle;
import org.jetbrains.annotations.ApiStatus;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  12/08/2024
 */
@ApiStatus.Experimental
public class BreadCrumbBar extends FlowPane {

    private ObjectProperty<Module> currentModule;
    private ObjectProperty<BreadSeparator> separator = new SimpleObjectProperty<>(BreadSeparator.BAR);

    public BreadCrumbBar() {
        getStyleClass().add("breadcrumb");
        setAlignment(Pos.CENTER_LEFT);
        this.currentModule = new SimpleObjectProperty<>();
//        this.currentModule.bindBidirectional(currentModule);

        this.currentModule.addListener((observableValue, module, newValue) -> {
            getChildren().clear();
            recur(newValue);
            if (getChildren().size() > 1) {

                if (!separator.get().equals(BreadSeparator.NONE) ){
                    getChildren().remove(getLastChild());
                }
                Hyperlink first = (Hyperlink) getFirstChild();
                first.getStyleClass().add("first");
                Hyperlink last = (Hyperlink) getLastChild();
                last.setStyle(null);
                last.getStyleClass().add("last");
                last.requestFocus();
                last.setVisited(true);
            }

            if (getChildren().size() == 1) {
                getChildren().get(0).getStyleClass().remove("last");
                if (getChildren().get(0) instanceof Hyperlink h) {
                    h.setVisited(false);
                }
                getChildren().get(0).setMouseTransparent(true);
            }
        });

//        getStylesheets().add(getClass().getResource("breadcrumb.css").toExternalForm());
    }

    public void setVariant(String number) {
        getStylesheets().add(getClass().getResource("variant_" + number + ".css").toExternalForm());
        if (number.equals("four")) {
            setSeparator(BreadSeparator.NONE);
            this.setHgap(0);
        }
    }

    public Node getLastChild() {
        return getChildren().get(getChildren().size() - 1);
    }

    public Node getFirstChild() {
        return getChildren().get(0);
    }

    public void setSeparator(BreadSeparator separator) {
        this.separator.set(separator);
    }

    public void recur(Module module) {
        if (module != null) {
//            if (module instanceof View view) {
//                getChildren().add(0, createLink(module));
//            } else {
//                getChildren().add(0, createText(module));
//            }

            getChildren().add(0, createText(module));

            if (separator.get() != BreadSeparator.NONE) {
                getChildren().add(1, createSeparator());
            }
            recur(module.getParent());
        }
    }

    private Hyperlink createLink(Module module) {
        Hyperlink text = new Hyperlink(module.getName());

        if (module.getGraphic() != null) {
            SVGIcon ct = (SVGIcon) module.getGraphic();
            text.setGraphic(new SVGIcon(ct.getIcon()));
        }

        text.setOnAction(e -> {
            currentModule.set(module);
        });
        text.setStyle("-fx-font-weight: bold;");
        return text;
    }

    private Hyperlink createText(Module module) {
        Hyperlink text = new Hyperlink(module.getName());
        text.getStyleClass().addAll("h5");

        if (module instanceof View) {
            text.setOnMouseClicked(e -> {
                currentModule.set(module);
            });
        } else {
            text.setMouseTransparent(true);
        }

//        text.setStyle("-fx-text-fill: -text-color;");

        if (module.getGraphic() != null) {
            SVGIcon ct = (SVGIcon) module.getGraphic();
            if ((boolean) module.getGraphic().getUserData()) {
//                text.setGraphic(new SVGIcon(ct.getIcon(), (boolean) module.getGraphic().getUserData()));
                text.setGraphic(new SVGIcon(ct.getIcon()));
            } else {
                text.setGraphic(new SVGIcon(ct.getIcon()));
            }

        }

        text.setAlignment(Pos.CENTER_LEFT);

        return text;
    }

    private Label createSeparator() {

        Label label = new Label();
        switch (separator.get()) {
            case BAR -> label.setText("/");
            case DOT -> {
                Circle circle = new Circle();
                circle.getStyleClass().add("separator");
                label.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                circle.setRadius(2);
                label.setGraphic(circle);
            }
            case ARROW -> {
                SVGIcon ct = new SVGIcon(Icon.CHEVRON_RIGHT);
                label.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                label.setGraphic(ct);
            }

        }
        return label;
    }

    public Module getCurrentModule() {
        return currentModule.get();
    }

    public ObjectProperty<Module> currentModuleProperty() {
        return currentModule;
    }

    public void setCurrentModule(Module currentModule) {
        this.currentModule.set(currentModule);
    }
}
