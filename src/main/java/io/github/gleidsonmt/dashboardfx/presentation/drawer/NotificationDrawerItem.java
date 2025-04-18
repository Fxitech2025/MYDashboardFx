package io.github.gleidsonmt.dashboardfx.presentation.drawer;

import javafx.beans.property.ObjectProperty;
import javafx.scene.Node;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  17/04/2025
 */
public class NotificationDrawerItem extends DrawerItemBase {

    private Node icon;

    public NotificationDrawerItem(String name, Node graphic, Node icon, ObjectProperty<Node> content) {
        super(name, graphic, content);
        this.icon = icon;
    }

    public Node getIcon() {
        return icon;
    }
}
