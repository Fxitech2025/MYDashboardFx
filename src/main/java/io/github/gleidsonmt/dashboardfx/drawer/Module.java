package io.github.gleidsonmt.dashboardfx.drawer;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import org.jetbrains.annotations.ApiStatus;

import java.util.Arrays;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  19/07/2024
 */
public class Module implements ModuleCreator {

    private final ObservableList<ModuleCreator> modules;
    private final String name;
    private ModuleCreator parent;
    private Pane container;
    private Node graphic;

    private boolean animated;

    public Module(String name, ModuleCreator... _modules) {
        this.modules = FXCollections.observableArrayList(_modules);
        this.name = name;

        Arrays.stream(_modules).forEach(el -> el.setParent(this));


        modules.addListener((ListChangeListener<ModuleCreator>) change -> {
            if (change.next()) {
                modules.forEach(el -> el.setParent(Module.this));
            }
        });


    }

    @ApiStatus.Experimental
    public void setAnimated(boolean animated) {
        this.animated = animated;
    }

    @Override
    public ObservableList<ModuleCreator> getModules() {
        return modules;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ModuleCreator getParent() {
        return parent;
    }

    @Override
    public Pane getContainer() {
        return container;
    }

    @Override
    public void setContainer(Pane container) {
        this.container = container;
    }

    @ApiStatus.Experimental
    @Override
    public boolean isAnimated() {
        return animated;
    }

    @Override
    public Node getGraphic() {
        return graphic;
    }

    @Override
    public void setParent(ModuleCreator parent) {
        this.parent = parent;
    }

//    public void setGraphic(Node graphic) {
//        setGraphic(graphic, false);
//    }



    @Override
    public String toString() {
        return getName();
    }
}
