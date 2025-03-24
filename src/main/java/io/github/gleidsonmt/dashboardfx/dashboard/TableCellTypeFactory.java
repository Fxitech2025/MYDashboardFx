package io.github.gleidsonmt.dashboardfx.dashboard;

import io.github.gleidsonmt.dashboardfx.model.Activity;
import io.github.gleidsonmt.dashboardfx.model.Company;
import io.github.gleidsonmt.dashboardfx.model.Type;
import io.github.gleidsonmt.dashboardfx.utils.StringUtils;
import io.github.gleidsonmt.glad.controls.avatar.AvatarCircleView;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.util.Callback;

import static javafx.scene.layout.GridPane.REMAINING;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  14/03/2025
 */
public class TableCellTypeFactory implements Callback<TableColumn<Activity, Type>, TableCell<Activity, Type>> {
    @Override
    public TableCell<Activity, Type> call(TableColumn<Activity, Type> activityCompanyTableColumn) {
        return new TableCell<>(){
            @Override
            protected void updateItem(Type item, boolean empty) {
                if (item != null) {
                    GridPane grid = new GridPane();
                    Region region = new Region();
                    region.setMinSize(20, 20);
                    region.getStyleClass().addAll("bg-primary", "round", "bg-insets-5", "border-5");

                    switch (item) {
                        case CORPORATE -> {
                            region.getStyleClass().addAll("bg-primary");
                            region.setStyle("-fx-border-color: derive(-primary, 95%);");

                        }
                        case CONVENTIONAL -> {
                            region.getStyleClass().addAll("bg-warning");
                            region.setStyle("-fx-border-color: derive(-warning, 80%);");
                        }
                    }

                    grid.setAlignment(Pos.CENTER_LEFT);
                    grid.setHgap(10);


                    Text title = new Text(StringUtils.capitalize(item.name()));
                    grid.add(region,0,0);
                    grid.add(title,1,0);

                    setGraphic(grid);
                    setText(null);
                } else {
                    setItem(null);
                    setText(null);
                }
            }
        };
    }
}
