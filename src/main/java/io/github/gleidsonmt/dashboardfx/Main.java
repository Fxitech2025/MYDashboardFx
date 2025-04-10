package io.github.gleidsonmt.dashboardfx;

import io.github.gleidsonmt.dashboardfx.breadcrumb.BreadCrumbBar;
import io.github.gleidsonmt.dashboardfx.dashboard.Dashboard;
import io.github.gleidsonmt.dashboardfx.drawer.*;
import io.github.gleidsonmt.dashboardfx.drawer.Module;
import io.github.gleidsonmt.dashboardfx.model.User;
import io.github.gleidsonmt.dashboardfx.presentation.about.AboutPres;
import io.github.gleidsonmt.dashboardfx.presentation.core.Behavior;
import io.github.gleidsonmt.dashboardfx.presentation.core.FlowPres;
import io.github.gleidsonmt.dashboardfx.presentation.core.Introduction;
import io.github.gleidsonmt.dashboardfx.presentation.core.Wrapper;
import io.github.gleidsonmt.dashboardfx.presentation.presentations.charts.*;
import io.github.gleidsonmt.dashboardfx.presentation.presentations.components.CardsPres;
import io.github.gleidsonmt.dashboardfx.presentation.presentations.controls.*;
import io.github.gleidsonmt.dashboardfx.presentation.presentations.layout.RegionPres;
import io.github.gleidsonmt.dashboardfx.presentation.presentations.layout.TextFlowPres;
import io.github.gleidsonmt.dashboardfx.presentation.presentations.pages.HomePage;
import io.github.gleidsonmt.dashboardfx.presentation.presentations.shapes.TextPres;
import io.github.gleidsonmt.dashboardfx.presentation.util.ColorsPres;
import io.github.gleidsonmt.dashboardfx.utils.Assets;
import io.github.gleidsonmt.dashboardfx.utils.pages.BuildingPage;
import io.github.gleidsonmt.dashboardfx.utils.pages.ErrorPage;
import io.github.gleidsonmt.glad.base.Layout;
import io.github.gleidsonmt.glad.base.Root;
import io.github.gleidsonmt.glad.controls.badge.Badge;
import io.github.gleidsonmt.glad.controls.icon.Icon;
import io.github.gleidsonmt.glad.controls.icon.SVGIcon;
import io.github.gleidsonmt.glad.responsive.Break;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  10/03/2025
 */
public class Main extends Root {

    private Drawer drawer;
    private GridPane navBar;
    private BreadCrumbBar crumb;
    private CardUserOptions card;
    private VBox wrapper;
    private ScrollPane body;
    private Button hamb;

    public Main() {
        super(new Layout());
        configLayout();

        this.behavior();
        this.wrapper();
        this.flow();

        navBar.setPadding(new Insets(10));
        navBar.setMinHeight(60);
        navBar.setAlignment(Pos.CENTER_LEFT);

        crumb = new BreadCrumbBar();

        navBar.add(crumb, 0, 0);

        card = new CardUserOptions(new User(
                Assets.getImage("default_avatar.jpg", 80),
                "johndoe54@gmail.com", "Jhon Doe")
        );

        Badge badgeNotification = new Badge(Icon.NOTIFICATION_IMPORTANT, 5);
        badgeNotification.setStyle("-fx-box-color: -info;");
        Badge badgeMessage = new Badge(Icon.CHAT, 8);
        badgeMessage.setStyle("-fx-box-color: -red-500;;");


        navBar.add(badgeNotification, 2, 0);
        navBar.add(badgeMessage, 1, 0);
        navBar.add(card, 3, 0);


        GridPane.setValignment(crumb, VPos.CENTER);
        GridPane.setValignment(badgeNotification, VPos.CENTER);
        GridPane.setValignment(badgeMessage, VPos.CENTER);
        GridPane.setHalignment(card, HPos.RIGHT);
        GridPane.setValignment(card, VPos.CENTER);
        GridPane.setHgrow(crumb, Priority.ALWAYS);

        navBar.setHgap(10);
        navBar.getStyleClass().addAll("border-light-gray-2");
        navBar.setStyle("-fx-border-width: 0px 0px 2px 0px;");

        hamb = new Button("");
        hamb.setCancelButton(true);
        hamb.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        hamb.setGraphic(new SVGIcon(Icon.MENU));

        hamb.setOnAction(e -> {
            behavior().openDrawer();
        });

        drawer = new Drawer(
                new View("Dashboard", new Dashboard()),
                new View("Introduction", new Dashboard()),
                new Module("Core",
                        new View("Introduction", new Introduction()),
                        new View("Wrapper", new Wrapper()),
                        new View("Flow", new FlowPres()),
                        new View("Behavior", new Behavior())
                ),
                new Module("Container",
                        new View("Region", new RegionPres()),
                        new View("Text Flow", new TextFlowPres())
                ),
                new Module("Shapes",
                        new View("Text", new TextPres()),
                        new View("Circle", new BuildingPage())
                ),
                new Module("Controls",
                        new View("SVGIcon", new SVGIconPres()),
                        new View("Avatar View", new AvatarPres()),
                        new View("Label", new LabelPres()),
                        new View("Button", new ButtonPres()),
                        new View("Toggle Button", new ToggleButtonPres()),
                        new View("Toggle Switch", new ToggleSwitchPres()),
                        new View("Radio Button", new RadioButtonPres()),
                        new View("Check Box", new CheckBoxPres()),
                        new View("Hyperlink", new HyperlinkPres()),
                        new View("Progress Bar", new ProgressBarPres()),
                        new View("Text Field", new TextFieldPres()),
                        new View("Table View", new TableViewPres()),
                        new View("Tree View", new TreeViewPres()),
                        new View("List View", new ListViewPres())
                ),
                new Module("Containers",
                        new View("TitledPane", new BuildingPage()),
                        new View("TabPane", new TabPres())
                ),
                new Module("Charts",
                        new View("Bar Chart", new BarChartPres()),
                        new View("Area Chart", new AreaChartPres()),
                        new View("Stacked Area Chart", new StackedAreaChartPres()),
                        new View("Stacked Bar Chart", new StackedBarChartPres()),
                        new View("Pie Chart", new DonutChartPres()),
                        new View("Line Chart", new LineChartPres())
                ),
                new Module("Components",
                        new View("Drawer", new BuildingPage()),
                        new View("BreadCrumb", new BuildingPage()),
                        new View("Cards", new CardsPres())
                ),
                new Module("Pages",
                        new View("Home Page", new HomePage()),
                        new View("Login", new BuildingPage()),
                        new View("Error Page 404")
                ),
                new Module("Utils",
                        new View("Pallet Color", new ColorsPres()),
                        new View("Alignment", new BuildingPage())
                ),
                new View("About", new AboutPres())
        );

        drawer.setHeader(new DrawerHeader());
        drawer.setFooter(new DrawerFooter());

        drawer.currentModuleProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue instanceof View view) {
                if (view.getContent() != null) body.setContent(view.getContent());
                if (view.getOnEnter() != null) view.getOnEnter().handle(new ActionEvent());
            } else {
                body.setContent(new ErrorPage(newValue.getName()));
            }
            if (oldValue != null) {
                if (oldValue instanceof View view) {
                    if (view.getOnExit() != null) view.getOnExit().handle(new ActionEvent());
                }
            }
        });

        crumb.currentModuleProperty().bind(drawer.currentModuleProperty());

        if (drawer.getCurrentModule() instanceof View view) {
            body.setContent(view.getContent());
        }
    }

    public Layout getContainer() {
        return super.getLayout();
    }

    private void configLayout() {
        this.wrapper = new VBox();
        this.navBar = new GridPane();
        this.body = new ScrollPane();
        VBox.setVgrow(this.body, Priority.ALWAYS);
        body.setFitToWidth(true);
        body.setFitToHeight(true);

        this.wrapper.getChildren().setAll(navBar, body);

        this.getContainer().setCenter(wrapper);

        getContainer().addPoint(_ -> {
            getContainer().setLeft(null);
            navBar.getChildren().add(0, hamb);
            GridPane.setColumnIndex(crumb, 1);
            GridPane.setColumnIndex(card, 4);
        }, Break.MOBILE);

        getContainer().addPoint(_ -> {
            if (behavior().isDrawerAbsolute()) {
                wrapper().close();
            }
            getContainer().setLeft(drawer);
            navBar.getChildren().remove(hamb);
            GridPane.setColumnIndex(crumb, 0);
            GridPane.setColumnIndex(card, 3);
        }, Break.values());
    }
}