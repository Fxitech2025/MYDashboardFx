package io.github.gleidsonmt.dashboardfx.dashboard;

import io.github.gleidsonmt.dashboardfx.model.Activity;
import io.github.gleidsonmt.dashboardfx.model.Status;
import io.github.gleidsonmt.dashboardfx.model.Type;
import io.github.gleidsonmt.dashboardfx.utils.StringUtils;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.util.Callback;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  14/03/2025
 */
public class TableCellStatusFactory implements Callback<TableColumn<Activity, Status>, TableCell<Activity, Status>> {
    @Override
    public TableCell<Activity, Status> call(TableColumn<Activity, Status> activityCompanyTableColumn) {
        return new TableCell<>(){
            @Override
            protected void updateItem(Status item, boolean empty) {
                if (item != null) {
                    Label label = new Label(StringUtils.capitalize(item.name()));
                    label.getStyleClass().addAll(item.equals(Status.BUSY) ? "bg-danger" : "bg-success", "text-white", "padding-5", "rounded", "bold");

                    setGraphic(label);
                    setText(null);
                } else {
                    setItem(null);
                    setText(null);
                }
            }
        };
    }
}
