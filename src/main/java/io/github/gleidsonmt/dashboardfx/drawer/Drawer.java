package io.github.gleidsonmt.dashboardfx.drawer;

import io.github.gleidsonmt.dashboardfx.presentation.internal.Tutorial;
import io.github.gleidsonmt.glad.controls.TextBoxOld;
import io.github.gleidsonmt.glad.controls.icon.Icon;
import io.github.gleidsonmt.glad.controls.text_box.TextBox;
import io.github.gleidsonmt.presentation.TreeTitle;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Predicate;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  21/07/2024
 */
@ApiStatus.Experimental
public class Drawer extends VBox {

    private ObjectProperty<Module> currentModule = new SimpleObjectProperty<>();

    private List<Module> modules;

    private DrawerContainer drawerContainer;
    private ToggleGroup group = new ToggleGroup();

    private TextBox search = new TextBox(Icon.SEARCH, "Search", true);
//    String text, Icon _icon, boolean animated, boolean mask

    private VBox searchBox = new VBox();
    private VBox defaultBox = new VBox();

    public Drawer(Module... _modules) {
        this(List.of(_modules));
    }

    public Drawer(List<Module> _modules) {
        this.modules = _modules;
        this.setId("drawer");
        this.drawerContainer = new DrawerContainer(defaultBox);
        this.getChildren().addAll(search, drawerContainer);
        search.setPromptText("Search");
        VBox.setMargin(search, new Insets(10, 0, 10, 0));

        VBox.setVgrow(drawerContainer, Priority.ALWAYS);
        search.setMinHeight(40);

        _modules.forEach(this::makeFirstLevel);
        this.setPrefWidth(250);
        this.setMaxWidth(250);
//        getStylesheets().add(Objects.requireNonNull(Start.class.getResource("css/drawer/variante_one.css")).toExternalForm());

        currentModule.addListener((observableValue, oldValue, newValue) -> group.getToggles().forEach(e -> {
            if (e.getUserData() == newValue) {
                group.selectToggle(e);
            }
        }));

        group.selectedToggleProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue != null) {
                r((ToggleButton) newValue, true);
            }
            if (oldValue != null) {
                Node oldParent = getRoot(((ToggleButton) oldValue));
                Node newParent = getRoot(((ToggleButton) newValue));
                if (oldParent != newParent) {
                    r((ToggleButton) oldValue, false);
                    Platform.runLater(() -> {
                        if (newParent instanceof TitledPane parent) {
                            parent.setExpanded(true);
                        }
                        if (oldParent instanceof TitledPane p) {
                            p.setExpanded(false);
                        }
                    });
                }
            }
        });

        if (!group.getToggles().isEmpty()) {
            group.selectToggle(group.getToggles().get(0));
            currentModule.setValue((Module) group.getToggles().get(0).getUserData());
        }

        search.textProperty().addListener((_, _, newVal) -> {

            if (!newVal.isEmpty()) {
                drawerContainer.setContainer(searchBox);
                searchBox.getChildren().clear();
//
                find(name -> name.contains(newVal))
                        .forEach(e -> {
                            Optional<BoxModule> opt = findModuleInSearchBox(e); // verify if box has e
                            if (opt.isEmpty() && e.getParent() != null) { // if box doesn't have a module and module has a parent
                                // add a new BoxModule with module
                                searchBox.getChildren().add(new BoxModule(e.getParent().getName(), createToggle(e)));
                            } else if (e.getParent() != null) { // if module already in search box and module has a parent
                                // find, and add to a BoxModule already in search box.
                                getBoxModule(e).get().getChildren().add(createToggle(e));
                            } else { // eh um module sem pai
                                searchBox.getChildren().add(createToggle(e));
                            }
                        });
            } else {
                drawerContainer.setContainer(defaultBox);
                VBox.setVgrow(drawerContainer, Priority.ALWAYS);
            }
        });
    }

    /**
     * If drawer is in mode of search, find a module.
     *
     * @param module The module in the SearchBox.
     * @return The BoxModule (VBox) that is equal to the module name.
     */
    private Optional<BoxModule> findModuleInSearchBox(Module module) {
        return searchBox
                .getChildren()
                .stream()
                .filter(el -> el instanceof BoxModule)
                .map(el -> (BoxModule) el)
                .filter(el -> module.getParent() != null)
                .filter(el -> el.getName().equals(module.getParent().getName()))
                .findAny();
    }

    private Optional<BoxModule> getBoxModule(Module e) {
        return searchBox.getChildren()
                .stream()
                .filter(el -> el instanceof BoxModule)
                .map(el -> (BoxModule) el)
                .filter(el -> e.getParent().getName().equals(el.getName()))
                .findAny();
    }


    private List<Module> find(Predicate<String> predicate) {
        List<Module> findedList = new ArrayList<>();
        _find(modules, findedList, predicate);
        return findedList;
    }

    private Module _find(@NotNull List<Module> modules, List<Module> findedList, Predicate<String> predicate) {
        for (Module mod : modules) {
            if (predicate.test(mod.getName())) {
                findedList.add(mod);
            } else {
                if (!mod.getModules().isEmpty()) {
                    Module module = _find(mod.getModules(), findedList, predicate);
                    if (module != null) {
                        findedList.add(module);
                    }
                }
            }
        }
        return null;
    }

    private @Nullable Module find(@NotNull List<Module> modules, String name) {
        for (Module mod : modules) {
            if (!mod.getName().equals(name)) {
                if (!mod.getModules().isEmpty()) {
                    Module module = find(mod.getModules(), name);
                    if (module != null) return module;
                }
            } else {
                return mod;
            }
        }
        return null;
    }

    public void navigate(String name, String topic) {
        Module module = find(this.modules, name);
        currentModule.set(module);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Optional<Node> optional = getScene().getRoot().lookupAll("#tutorial-scroll").stream().findFirst();
                if (optional.isPresent() && optional.get() instanceof ScrollPane scroll) {
                    VBox box = (VBox) scroll.getContent();

                    Optional<TreeTitle> opt = box.getChildren().stream()
                            .filter(el -> el instanceof TreeTitle)
                            .map(el -> (TreeTitle) el)
                            .filter(el -> el.getText().equals(topic))
                            .findAny();
//                    Scroll.scrollTo(scroll, opt.get());

                    BorderPane border = (BorderPane) getScene().getRoot().lookup("#tutorial-body");
                    Tutorial tutorial = (Tutorial) border.getUserData();
                    tutorial.select(topic);
                }
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask, 50);
    }

    public void navigate(String name) {
        Module module = find(this.modules, name);
        currentModule.set(module);
    }

    private void update(Node titledPane, boolean active) {
        if (active) {
            if (!titledPane.getStyleClass().contains("module-selected")) {
                titledPane.getStyleClass().addAll("module-selected");
            }
        } else {
            titledPane.getStyleClass().removeAll("module-selected");
        }
    }

    public void setHeader(Node node) {
        this.getChildren().add(0, node);
    }

    public void setFooter(Node node) {
        this.getChildren().add(node);
    }

    private Node getRoot(Node module) {

        if (module != null && module.getStyleClass().contains("module-first")) {
            return module;
        } else {
            if (module != null) return getRoot(module.getParent());
        }
        return null;
    }

    public void r(Node module, boolean active) {
        if (module instanceof TitledPane titledPane && titledPane.getStyleClass().contains("module-first")) {
            update(titledPane, active);
        } else {
            if (module.getParent() == null) return;
            r(module.getParent(), active);
        }
    }

    public ToggleButton createToggle(Module module) {
        ToggleButton b = new ToggleButton(module.getName());
        b.setUserData(module);
        b.getStyleClass().add("drawer-item");
        b.setAlignment(Pos.CENTER_LEFT);
        b.setPrefWidth(Double.MAX_VALUE);
        b.setOnMouseClicked(e -> currentModule.set(module));
        if (module.getGraphic() != null) {
            b.setGraphic(module.getGraphic());
        }
        group.getToggles().add(b);
        return b;
    }

    public void makeFirstLevel(Module module) {
        if (module.getModules().isEmpty()) {
//            this.getChildren().add(createToggle(module));
            ((VBox) this.drawerContainer.getContent()).getChildren().add(createToggle(module));
        } else {
            TitledPane container = createPanel(module, true);

            container.getStyleClass().add("module-first");
//            this.getChildren().add(container);
            ((VBox) this.drawerContainer.getContent()).getChildren().add(container);
            if (!module.getModules().isEmpty()) {
//            VBox.setMargin(b, new Insets(0, 0, 0, 10));
                module.getModules().forEach(el -> {
//                    if (el instanceof View view) {
                    if (!el.getModules().isEmpty()) {
                        TitledPane pane = createPanel(el);
                        ((Pane) container.getContent()).getChildren().add(pane);
                        el.setContainer((Pane) container.getContent());
//                            System.out.println(el.getModules());
                        el.getModules().forEach(e -> {
                            e.setContainer((Pane) pane.getContent());
                            recurse(e);
                        });
                    } else {
                        ToggleButton button = createToggle(el);
                        ((Pane) container.getContent()).getChildren().add(button);
                        button.setOnMouseClicked(e -> currentModule.set(el));
                    }
                });
            }
        }
    }

    public void recurse(Module module) {
        if (module instanceof View) {
            ToggleButton b = createToggle(module);

            if (module.getContainer() != null) {
                module.getContainer().getChildren().add(b);
            } else {
                this.getChildren().add(b);
            }
        } else {

            TitledPane container = createPanel(module);
            module.getContainer().getChildren().add(container);
            if (!module.getModules().isEmpty()) {
                module.getModules().forEach(el -> {
                    el.setContainer((Pane) container.getContent());
                    recurse(el);
                });
            }
        }
    }

    private @NotNull TitledPane createPanel(Module module) {
        return createPanel(module, false);
    }

    private @NotNull TitledPane createPanel(@NotNull Module module, boolean first) {
        VBox content = new VBox();
        content.getStyleClass().add("container");
        TitledPane titledPane = new TitledPane(module.getName(), content);

        if (module.getGraphic() != null) {
            titledPane.setGraphic(module.getGraphic());
        }
        titledPane.setExpanded(false);

        titledPane.setContentDisplay(ContentDisplay.RIGHT);
        titledPane.setAlignment(Pos.TOP_RIGHT);
        titledPane.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        titledPane.getStyleClass().add("drawer-menu");
        content.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);

        if (!module.isAnimated() && !first) {
            ToggleButton b = new ToggleButton(module.getName());
            b.setUserData(module);
            b.getStyleClass().add("drawer-item");
            b.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            b.setAlignment(Pos.CENTER_LEFT);
            b.setPrefWidth(230);
            group.getToggles().add(b);
            titledPane.getStyleClass().add("module-item");

            titledPane.setGraphic(b);
            titledPane.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

            titledPane.setCollapsible(false);
            titledPane.setAnimated(false);

            b.setOnMouseClicked(e ->
            {
                if (!(e.getTarget() instanceof VBox)) {
                    currentModule.set(module);
                }
            });
        }

        return titledPane;
    }

    public Module getCurrentModule() {
        return currentModule.get();
    }

    public ObjectProperty<Module> currentModuleProperty() {
        return currentModule;
    }

}
