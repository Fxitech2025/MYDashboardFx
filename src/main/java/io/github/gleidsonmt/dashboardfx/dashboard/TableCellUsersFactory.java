package io.github.gleidsonmt.dashboardfx.dashboard;

import io.github.gleidsonmt.dashboardfx.model.Activity;
import io.github.gleidsonmt.dashboardfx.model.User;
import io.github.gleidsonmt.glad.controls.avatar.AvatarView;
import io.github.gleidsonmt.glad.controls.avatar.StackedAvatar;
import javafx.beans.property.ListProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.util.Callback;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  14/03/2025
 */
public class TableCellUsersFactory implements Callback<TableColumn<Activity, ObservableList<User>>, TableCell<Activity, ObservableList<User>>> {
    @Override
    public TableCell<Activity, ObservableList<User>> call(TableColumn<Activity, ObservableList<User>> activityCompanyTableColumn) {
        return new TableCell<>(){
            @Override
            protected void updateItem(ObservableList<User> item, boolean empty) {
                if (item != null) {
                    setAlignment(Pos.CENTER_LEFT);
                    AvatarView[] imgs = new AvatarView[item.size()];
                    for (int i = 0; i < item.size(); i++) {
                        imgs[i] = new AvatarView(item.get(i).getAvatar());
                    }
                    StackedAvatar avatar = new StackedAvatar();
                    avatar.setAvatarSize(40);
                    avatar.setMax(3);
                    avatar.getAvatarViews().addAll(imgs);

                    setGraphic(avatar);
                    setText(null);

                } else {
                    setItem(null);
                    setText(null);
                }
            }
        };
    }
}
