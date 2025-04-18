package io.github.gleidsonmt.dashboardfx.presentation.drawer;

import javafx.beans.property.ObjectProperty;
import javafx.scene.Node;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  17/04/2025
 */

public class DrawerItemBase implements DrawerItem {

    private final String name;
    private final Node graphic;
    private final ObjectProperty<Node> content;

    public DrawerItemBase(String name, Node graphic,  ObjectProperty<Node> content) {
        this.name = name;
        this.graphic = graphic;
        this.content = content;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Node getGraphic() {
        return this.graphic;
    }

    @Override
    public ObjectProperty<Node> contentProperty() {
        return this.content;
    }
}
