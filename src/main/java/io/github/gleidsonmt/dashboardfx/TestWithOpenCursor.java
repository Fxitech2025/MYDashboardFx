//package io.github.gleidsonmt.dashboardfx;
//
//import io.github.gleidsonmt.glad.base.Container;
//import io.github.gleidsonmt.glad.base.Layout;
//import io.github.gleidsonmt.glad.base.Root;
//import io.github.gleidsonmt.glad.controls.button.Button;
//import io.github.gleidsonmt.glad.theme.Css;
//import io.github.gleidsonmt.glad.theme.ThemeProvider;
//import javafx.application.Application;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
///**
// * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
// * Create on  09/05/2025
// */
//public class TestWithOpenCursor extends Application {
//
//    @Override
//    public void start(Stage stage) throws Exception {
//        Button button = new Button("Click on me");
//        VBox body = new VBox(button);
//        body.setAlignment(Pos.CENTER);
//
//
////        Root rootImpl = new Root(new Layout(body));
//        stage.setScene(new Scene(rootImpl, 800, 800));
//        Container container = new Container();
//        container.setStyle("-fx-background-color: #ff000022;");
//        container.setPrefSize(200, 200);
//        container.getChildren().add(new Label("Hello world"));
//        button.setOnMouseClicked(e -> {
//            rootImpl.flow().openByCursor(container, e, Pos.CENTER, 0,100);
//        });
//
//        ThemeProvider.install(stage.getScene(), Css.DEFAULT, Css.BUTTON);
//
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
