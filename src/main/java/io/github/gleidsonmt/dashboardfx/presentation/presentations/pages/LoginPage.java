package io.github.gleidsonmt.dashboardfx.presentation.presentations.pages;

import io.github.gleidsonmt.glad.base.Container;
import io.github.gleidsonmt.glad.controls.TextField;
import io.github.gleidsonmt.glad.controls.button.Button;
import io.github.gleidsonmt.glad.controls.icon.Icon;
import io.github.gleidsonmt.glad.controls.skin.TextBoxBase;
import io.github.gleidsonmt.glad.controls.text_box.PasswordBox;
import io.github.gleidsonmt.glad.controls.text_box.TextBox;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  13/04/2025
 */
public class LoginPage extends Container {



    public LoginPage() {
        init();
        configLayout();
    }

    private void init() {

    }

    private void configLayout() {
        VBox body = new VBox();
        body.setAlignment(Pos.CENTER);
        body.setPrefWidth(500);
        body.maxWidthProperty().bind(body.prefWidthProperty());
        body.getChildren().addAll(
                createTitle(),
                createText(),
                createField(false),
                createField(true),
                createOptions(),
                createBar());
        getChildren().add(body);
    }

    private Text createTitle() {
        Text text = new Text("Welcome");
        text.getStyleClass().addAll("h1", "text-accent", "font-instagram-headline", "bold");

        VBox.setMargin(text, new Insets(0,0,10,0));
        return text;
    }

    private Text createText() {
        Text text = new Text("Welcome back, Please login in your account.");
        text.getStyleClass().addAll("h4",  "font-instagram");
        VBox.setMargin(text, new Insets(0,0,10,0));
        return text;
    }

    private TextBoxBase createField(boolean pass) {
        TextBoxBase textBox = pass ? createPass() : createTextField();
        textBox.getStyleClass().addAll("min-h-50");
        VBox.setMargin(textBox, new Insets(10,0,10,0));
        return textBox;
    }

    private TextBox createTextField() {
        TextBox pass = new TextBox(Icon.ACCOUNT);
        pass.setPromptText("Name");
        pass.setAction(true);
        return pass;
    }

    private PasswordBox createPass() {
        PasswordBox pass = new PasswordBox(Icon.VPN_KEY_FILLED);
        pass.setPromptText("Password");
        pass.setAction(true);
        return pass;
    }

    private GridPane createOptions() {
        GridPane grid = new GridPane();
        CheckBox checkBox = new CheckBox("Remember");
        Hyperlink hyperlink = new Hyperlink("Forgot your password?");

        ColumnConstraints columnOne = new ColumnConstraints();
        ColumnConstraints columnTwo = new ColumnConstraints();
        columnOne.setPercentWidth(50);
        columnTwo.setPercentWidth(50);

        VBox.setMargin(grid, new Insets(20,0,20,0));

        grid.getColumnConstraints().addAll(columnOne, columnTwo);

        GridPane.setHalignment(hyperlink, HPos.RIGHT);

        grid.add(checkBox,0,0);
        grid.add(hyperlink,1,0);
        return grid;
    }

    private ButtonBar createBar() {
        ButtonBar buttonBar = new ButtonBar();
        Button login = new Button("Login");
        login.setPrefWidth(300);
        Button register = new Button("Register");
        register.setCancelButton(true);
        ButtonBar.setButtonData(login, ButtonBar.ButtonData.OK_DONE);
//        ButtonBar.setButtonData(register, ButtonBar.ButtonData.OTHER);
//        ButtonBar.setButtonUniformSize(login, true);
//        ButtonBar.setButtonUniformSize(register, true);
//        buttonBar.maxWidthProperty().bind(buttonBar.widthProperty());
        buttonBar.getButtons().addAll(login, register);
        return buttonBar;
    }


}
