//package io.github.gleidsonmt.dashboardfx;
//
//import io.github.gleidsonmt.dashboardfx.breadcrumb.BreadCrumbBar;
//import io.github.gleidsonmt.dashboardfx.dashboard.Dashboard;
//import io.github.gleidsonmt.dashboardfx.dashboard.notifications.*;
//import io.github.gleidsonmt.dashboardfx.dashboard.notifications.component.NotificationItem;
//import io.github.gleidsonmt.dashboardfx.dashboard.notifications.factory.NotificationManager;
//import io.github.gleidsonmt.dashboardfx.drawer.*;
//import io.github.gleidsonmt.dashboardfx.drawer.ModuleView;
//import io.github.gleidsonmt.dashboardfx.model.User;
//import io.github.gleidsonmt.dashboardfx.presentation.drawer.DrawerExample;
//import io.github.gleidsonmt.dashboardfx.presentation.about.AboutPres;
//import io.github.gleidsonmt.dashboardfx.presentation.core.Behavior;
//import io.github.gleidsonmt.dashboardfx.presentation.core.FlowPres;
//import io.github.gleidsonmt.dashboardfx.presentation.core.Introduction;
//import io.github.gleidsonmt.dashboardfx.presentation.core.Wrapper;
//import io.github.gleidsonmt.dashboardfx.presentation.presentations.charts.*;
//import io.github.gleidsonmt.dashboardfx.presentation.presentations.components.*;
//import io.github.gleidsonmt.dashboardfx.presentation.presentations.controls.*;
//import io.github.gleidsonmt.dashboardfx.presentation.presentations.controls.RegionPres;
//import io.github.gleidsonmt.dashboardfx.presentation.presentations.layout.TextFlowPres;
//import io.github.gleidsonmt.dashboardfx.presentation.presentations.pages.HomePage;
//import io.github.gleidsonmt.dashboardfx.presentation.presentations.pages.LoginPage;
//import io.github.gleidsonmt.dashboardfx.presentation.presentations.shapes.TextPres;
//import io.github.gleidsonmt.dashboardfx.presentation.util.ColorsPres;
//import io.github.gleidsonmt.dashboardfx.utils.Assets;
//import io.github.gleidsonmt.dashboardfx.utils.pages.BuildingPage;
//import io.github.gleidsonmt.dashboardfx.utils.pages.ErrorPage;
//import io.github.gleidsonmt.glad.base.Layout;
//import io.github.gleidsonmt.glad.base.Root;
//import io.github.gleidsonmt.glad.controls.badge.Badge;
//import io.github.gleidsonmt.glad.controls.icon.Icon;
//import io.github.gleidsonmt.glad.controls.icon.SVGIcon;
//import io.github.gleidsonmt.glad.base.responsive.Break;
//import javafx.event.ActionEvent;
//import javafx.geometry.HPos;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.geometry.VPos;
//import javafx.scene.control.Button;
//import javafx.scene.control.ContentDisplay;
//import javafx.scene.control.ScrollPane;
//import javafx.scene.layout.*;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//
///**
// * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
// * Create on  10/03/2025
// */
//public class MainOld extends Root {
//
//    private Drawer drawer;
//    private GridPane navBar;
//    private BreadCrumbBar crumb;
//    private CardUserOptions card;
//    private VBox wrapper;
//    private ScrollPane body;
//    private Button hamb;
//
//    public Main() {
//        super(new Layout());
//        configLayout();
//
//        navBar.setPadding(new Insets(10));
//        navBar.setMinHeight(60);
//        navBar.setAlignment(Pos.CENTER_LEFT);
//
//        crumb = new BreadCrumbBar();
//
//        navBar.add(crumb, 0, 0);
//
//        card = new CardUserOptions(new User(Assets.getImage("default_avatar.jpg", 80), "johndoe54@gmail.com", "Jhon Doe"));
//
//        Badge badgeNotification = new Badge(Icon.NOTIFICATION_IMPORTANT, 5, 10);
//        badgeNotification.setStyle("-fx-box-color: -info;");
//
//        NotificationManager notificationManager = new NotificationManager();
//
//        notificationManager.addAll(
//                new NotificationItem<>(
//                        new FollowNotification(
//                                new User(
//                                        Assets.getImage("default_avatar.jpg", 80),
//                                        "@gleidsonmt", "Gleidson Neves"
//                                ),
//                                LocalDateTime.of(LocalDate.of(2024, 11, 2), LocalTime.of(14, 23)),
//                                false
//                        )
//                ),
//                new NotificationItem<>(
//                        new FollowNotification(new User(Assets.getImage("avatar1.png", 70), "@noelly", "Noelly Richards"), LocalDateTime.of(LocalDate.of(2025, 2, 22), LocalTime.of(12, 12)), false)
//                ),
//                new NotificationItem<>(
//                        new CommentNotification(new User(Assets.getImage("avatar2.jpg", 70), "@noelly", "Noelly Richards"), LocalDateTime.of(LocalDate.of(2025, 2, 22), LocalTime.of(12, 12)), false,
//                                "Love the background on this! Wold love to learn how to create the mesh gradient effect.")
//                ),
//                new NotificationItem<>(
//                        new InviteNotification(new User(Assets.getImage("avatar4.png", 70), "@noelly", "Noelly Richards"), LocalDateTime.of(LocalDate.of(2025, 3, 05), LocalTime.of(12, 12)), false)
//                ),
//                new NotificationItem<>(
//                        new FollowNotification(new User(Assets.getImage("default_avatar.jpg", 70), "@noelly", "Noelly Richards"), LocalDateTime.of(LocalDate.of(2025, 2, 22), LocalTime.of(12, 12)), false)
//                )
//        );
//
//        badgeNotification.setOnMouseClicked(e -> {
//
//            Root rootImpl = (Root) getScene().getRoot();
//
//            Layout layout = rootImpl.getLayout();
//
//            Layout old = rootImpl.getLayout();
//            rootImpl.wrapper().setOnClick(ev -> {
//                rootImpl.wrapper().hide();
//                rootImpl.flow().remove(notificationManager.getRoot());
//            });
//
////            if (!rootImpl.flow().fits(notificationManager.getRoot())) {
////                notificationManager.useHeader(_ -> rootImpl.setLayout(old));
////
////                rootImpl.flow().clearConstraints(notificationManager.getRoot());
////                rootImpl.flow().remove(notificationManager.getRoot());
////
////                rootImpl.setLayout(new Layout(notificationManager.getRoot()));
////                rootImpl.widthProperty().addListener(new ChangeListener<>() {
////                    @Override
////                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
////                        rootImpl.setLayout(old);
////                        rootImpl.widthProperty().removeListener(this);
////                        notificationManager.removeHeader();
////                    }
////                });
////            } else {
////                rootImpl.flow().openByCursor(notificationManager.getRoot(), e, 10, 20);
//            rootImpl.wrapper().show();
//            rootImpl.flow().openByCursor(notificationManager.getRoot(),
//                    e, Pos.BOTTOM_CENTER,  0, navBar.getHeight()/2);
//
////            }
//        });
//
//        Badge badgeMessage = new Badge(Icon.CHAT, 8, 10);
//        badgeMessage.setStyle("-fx-box-color: -red-500;");
//
//        navBar.add(badgeNotification, 2, 0);
//        navBar.add(badgeMessage, 1, 0);
//        navBar.add(card, 3, 0);
//
//        GridPane.setValignment(crumb, VPos.CENTER);
//        GridPane.setValignment(badgeNotification, VPos.CENTER);
//        GridPane.setValignment(badgeMessage, VPos.CENTER);
//        GridPane.setHalignment(card, HPos.RIGHT);
//        GridPane.setValignment(card, VPos.CENTER);
//        GridPane.setHgrow(crumb, Priority.ALWAYS);
//
//        navBar.setHgap(10);
//        navBar.getStyleClass().addAll("border-light-gray-2");
//        navBar.setStyle("-fx-border-width: 0px 0px 2px 0px;");
//
//        hamb = new Button("");
//        hamb.setCancelButton(true);
//        hamb.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
//        hamb.setGraphic(new SVGIcon(Icon.MENU));
//
//        hamb.setOnAction(e -> {
//            behavior().openDrawer();
//        });
//
//        drawer = new Drawer(
//                new View("Dashboard", new Dashboard()),
//                new ModuleSeparator(new SVGIcon(Icon.HUB), "Project"),
//                new ModuleView("Core",
//                        new View("Introduction", new Introduction()),
//                        new View("Wrapper", new Wrapper()),
//                        new View("Flow", new FlowPres()),
//                        new View("Behavior", new Behavior())),
//                new ModuleSeparator(new SVGIcon(Icon.DESIGN_SERVICES), "Theme"),
//                new ModuleView("Shapes",
//                        new View("Text", new TextPres()),
//                        new View("Circle", new BuildingPage())),
//                new ModuleView("Controls",
//                        new View("Region", new RegionPres()),
//                        new View("Labeled", new LabeledPres()),
//                        new View("Text Input", new TextInputPres()),
//                        new View("Progress Bar", new ProgressBarPres()),
//                        new View("Table View", new TableViewPres()),
//                        new View("Tree View", new TreeViewPres()),
//                        new View("List View", new ListViewPres())),
//                new ModuleView("Containers",
//                        new View("TitledPane", new BuildingPage()),
//                        new View("TabPane", new TabPres()),
//                        new View("Text Flow", new TextFlowPres())),
//                new ModuleView("Charts",
//                        new View("Bar Chart", new BarChartPres()),
//                        new View("Area Chart", new AreaChartPres()),
//                        new View("Stacked Area Chart", new StackedAreaChartPres()),
//                        new View("Stacked Bar Chart", new StackedBarChartPres()),
//                        new View("Pie Chart", new DonutChartPres()),
//                        new View("Line Chart", new LineChartPres())),
//                new ModuleSeparator(new SVGIcon(Icon.STACK), "Examples"),
//                new ModuleView("Components",
//
//                        new View("SVGIcon", new SVGIconPres()),
//                        new View("Button", new ButtonExample()),
//                        new View("Badge", new BadgeExample()),
//                        new View("Avatar View", new AvatarPres()),
//                        new View("Toggle Switch", new ToggleSwitchPres())
//
//                ),
//                new ModuleView("Styled",
//                        new View("Drawer", new DrawerExample()),
//                        new View("BreadCrumb", new BuildingPage()),
//                        new View("Tree View", new TreeViewExample()),
//                        new View("Label", new LabelExample()),
//                        new View("Cards", new CardsPres())),
//                new ModuleView("Pages",
//                        new View("Home Page", new HomePage()),
//                        new View("Login", new LoginPage()),
//                        new View("Error Page 404", new ErrorPage("Module not found"))),
//                new ModuleSeparator(new SVGIcon(Icon.HELP), "Theme"),
//                new ModuleView("Utils",
//                        new View("Pallet Color", new ColorsPres()),
//                        new View("Alignment", new BuildingPage())),
//                new View("About", new AboutPres())
//        );
//
//        drawer.setHeader(new DrawerHeader());
//        drawer.setFooter(new DrawerFooter());
//
//        drawer.currentModuleProperty().addListener((_, oldValue, newValue) -> {
//            if (newValue instanceof View view) {
//
//                if (view.getContent() != null) body.setContent(view.getContent());
//                if (view.getOnEnter() != null) view.getOnEnter().handle(new ActionEvent());
//                if (view.getContent() instanceof ModuleLoad mod) mod.load();
//
//            } else {
//                body.setContent(new ErrorPage(newValue.getName()));
//            }
//            if (oldValue != null) {
//                if (oldValue instanceof View view) {
//                    if (view.getOnExit() != null) view.getOnExit().handle(new ActionEvent());
//                }
//            }
//        });
//
//        crumb.currentModuleProperty().bind(drawer.currentModuleProperty());
//
//        if (drawer.getCurrentModule() instanceof View view) {
//            body.setContent(view.getContent());
//        }
//    }
//
//    public Layout getContainer() {
//        return super.getLayout();
//    }
//
//    private void configLayout() {
//        this.wrapper = new VBox();
//        this.navBar = new GridPane();
//        this.body = new ScrollPane();
//        VBox.setVgrow(this.body, Priority.ALWAYS);
//        body.setFitToWidth(true);
//        body.setFitToHeight(true);
//
//        this.wrapper.getChildren().setAll(navBar, body);
//
//        this.getContainer().setCenter(wrapper);
//
//        getContainer().addPoint(_ -> {
//            getContainer().setLeft(null);
//            navBar.getChildren().add(0, hamb);
//            GridPane.setColumnIndex(crumb, 1);
//            GridPane.setColumnIndex(card, 4);
//        }, Break.MOBILE);
//
//        getContainer().addPoint(_ -> {
//            if (behavior().isDrawerAbsolute()) {
//                wrapper().hide();
//            }
//            getContainer().setLeft(drawer);
//            navBar.getChildren().remove(hamb);
//            GridPane.setColumnIndex(crumb, 0);
//            GridPane.setColumnIndex(card, 3);
//        }, Break.values());
//    }
//}