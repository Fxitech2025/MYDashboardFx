package io.github.gleidsonmt.dashboardfx.model;

import javafx.beans.property.*;
import javafx.scene.image.Image;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  17/03/2025
 */
public class CountryBox extends Model {

    private ObjectProperty<Image> avatar = new SimpleObjectProperty<>();
    private StringProperty title = new SimpleStringProperty();
    private DoubleProperty percentage = new SimpleDoubleProperty();

    public CountryBox(Image image, String title, double percentage) {
        this.title.set(title);
        this.avatar.set(image);
        this.setPercentage(percentage);
    }

    public Image getAvatar() {
        return avatar.get();
    }

    public ObjectProperty<Image> avatarProperty() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar.set(avatar);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public double getPercentage() {
        return percentage.get();
    }

    public DoubleProperty percentageProperty() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage.set(percentage);
    }
}
