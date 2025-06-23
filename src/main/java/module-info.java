module io.github.gleidsonmt.dashboardfx {

    requires io.github.gleidsonmt.glad;

    requires org.jetbrains.annotations;
    requires org.scenicview.scenicview;
//    requires fr.brouillard.oss.cssfx;
    requires java.net.http;

    exports io.github.gleidsonmt.dashboardfx.drawer;

    requires eu.hansolo.colors;
    requires javafx.media;
    requires io.github.gleidsonmt.presentation;
    requires io.github.gleidsonmt.blockcode;
    requires java.desktop;

    opens io.github.gleidsonmt.dashboardfx to javafx.fxml;
    exports io.github.gleidsonmt.dashboardfx;
    exports io.github.gleidsonmt.dashboardfx.dashboard;
    opens io.github.gleidsonmt.dashboardfx.dashboard to javafx.fxml;

    opens io.github.gleidsonmt.dashboardfx.model to javafx.base;
    exports io.github.gleidsonmt.dashboardfx.material;
    opens io.github.gleidsonmt.dashboardfx.material to javafx.fxml;

    opens io.github.gleidsonmt.dashboardfx.presentation.drawer to javafx.base;
}