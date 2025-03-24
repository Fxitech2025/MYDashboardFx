package io.github.gleidsonmt.dashboardfx.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  02/03/2024
 */
public class Entity extends Model {

    private final StringProperty name = new SimpleStringProperty();

    public Entity() {
        this(null);
    }

    public Entity(String name) {
        this.name.set(name);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

//    public String toString() {
//        final StringBuffer sb = new StringBuffer("Entity{");
//        sb.append("name=").append(name);
//        sb.append('}');
//        return sb.toString();
//    }

}
