/*
 *
 *    Copyright (C) Gleidson Neves da Silveira
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package io.github.gleidsonmt.dashboardfx.utils.pages;

import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  02/07/2023
 */
@Deprecated(forRemoval = true)
public class ErrorPage extends ScrollPane {

    private final VBox body = new VBox();
    private final VBox boxTitle = new VBox();
    private final VBox boxInfo = new VBox();

    private final Text errorTitle = new Text();
    private final Text title = new Text();
    private final Text legend = new Text();
    private final Text info = new Text();

    private final TextFlow titleFlow = new TextFlow(title);
//    private final Hyperlink see = new Hyperlink("See Routes");
    private final TextFlow infoFlow = new TextFlow(info);

    public ErrorPage(String name) {
        VBox.setVgrow(this, Priority.ALWAYS);
        errorTitle.setText("404");
        title.setText("The module was not found.");
        legend.setText("Sorry, system couldn't find the view.");
        info.setText("View/ModuleView \'" + name + "\' doesn't exist.");
        configLayout();
    }

    private void configLayout() {

        errorTitle.getStyleClass().addAll("bolder", "text-48");
        errorTitle.setStyle("-fx-fill: -fx-accent;");
        title.getStyleClass().addAll("text-bold", "h1");
        title.getStyleClass().addAll("-fx-fill: -text-color;");
        legend.getStyleClass().addAll("-fx-fill: -text-color;");
        info.getStyleClass().addAll( "h6");
        info.setStyle("-fx-fill: -text-color;");
        titleFlow.setTextAlignment(TextAlignment.CENTER);
        infoFlow.setTextAlignment(TextAlignment.CENTER);
        boxInfo.getChildren().addAll(infoFlow);

        body.getChildren().setAll(boxTitle, boxInfo);
        this.setContent(body);
        boxTitle.getChildren().setAll(errorTitle, titleFlow);

        body.setAlignment(Pos.CENTER);
        boxTitle.setAlignment(Pos.CENTER);
        boxInfo.setAlignment(Pos.CENTER);

        this.setFitToWidth(true);
        this.setFitToHeight(true);

    }
}
