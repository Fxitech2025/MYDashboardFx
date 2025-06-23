//package io.github.gleidsonmt.dashboardfx;
//
//import io.github.gleidsonmt.dashboardfx.utils.Assets;
//import io.github.gleidsonmt.glad.base.RootImpl;
//import io.github.gleidsonmt.glad.theme.Css;
//import io.github.gleidsonmt.glad.theme.Font;
//import io.github.gleidsonmt.glad.theme.ThemeProvider;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//
//
///**
// * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
// * Create on  20/02/2025
// */
//public class AppOld extends Application {
//
//    private StackPane body = null;
//
//    @Override
//    public void start(Stage stage) {
//
//        Main main = new Main();
//
//        RootImpl rootImpl = new RootImpl(new Layout(new Button("Welcome")));
//
//        Scene scene = new Scene(main, 800, 600);
//
//        ThemeProvider.install(scene, Font.POPPINS, Font.INSTAGRAM);
//        ThemeProvider.install(scene,
//                Css.DEFAULT,
//                Css.TABLE_VIEW,
//                Css.TAB_PANE,
//                Css.IMMERSIVE_SCROLL,
//                Css.HYPERLINK,
//                Css.SHAPES,
//                Css.LIST_VIEW,
//                Css.CONTEXT_MENU,
//                Css.PROGRESS_BAR,
//                Css.COMBO_BOX,
//                Css.TEXT_FIELD,
//                Css.RADIO_BUTTON,
//                Css.CHECK_BOX,
//                Css.TREE_VIEW,
//                Css.TEXT_BOX,
//                Css.BUTTON,
//                Css.TOGGLE_BUTTON
//        );
//
//        scene.getStylesheets().addAll(
//                Assets.getCss("drawer.css"),
//                Assets.getCss("master.css")
//        );
//
//        stage.getIcons().addAll(Assets.getImage("logo_128.png"));
//        stage.setScene(scene);
//        stage.setMaximized(true);
//        stage.show();
//
//
////        ScenicView.show(stage.getScene());
////        CSSFX.start(stage);
//    }
//
//
//}
