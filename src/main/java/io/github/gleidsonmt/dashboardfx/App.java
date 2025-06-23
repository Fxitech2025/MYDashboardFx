package io.github.gleidsonmt.dashboardfx;

import io.github.gleidsonmt.dashboardfx.drawer.Drawer;
import io.github.gleidsonmt.dashboardfx.utils.Assets;
import io.github.gleidsonmt.glad.base.Container;
import io.github.gleidsonmt.glad.base.Launcher;
import io.github.gleidsonmt.glad.base.Layout;
import io.github.gleidsonmt.glad.base.responsive.Break;
import io.github.gleidsonmt.glad.base.responsive.BreakPoint;
import io.github.gleidsonmt.glad.controls.button.IconButton;
import io.github.gleidsonmt.glad.controls.icon.Icon;
import io.github.gleidsonmt.glad.controls.icon.SVGIcon;
import io.github.gleidsonmt.glad.theme.Css;
import io.github.gleidsonmt.glad.theme.Font;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.scenicview.ScenicView;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  10/06/2025
 */
public class App extends Launcher {

    @Override
    protected void build(Layout layout) {
        Drawer drawer = new Drawer();
        Main main = new Main(layout, drawer);

        layout.addPoint(_ -> {
            layout.setDrawer(null);
        }, Break.MOBILE);

        layout.addPoint(_ -> {
            layout.setDrawer(drawer);
        }, Break.SM, Break.MD, Break.WIDE);

        addFonts(Font.POPPINS, Font.INSTAGRAM);
        addStyleSheets(Css.DEFAULT, Css.BUTTON, Css.HYPERLINK, Css.CONTEXT_MENU, Css.PROGRESS_BAR, Css.LIST_VIEW, Css.TABLE_VIEW, Css.TEXT_FIELD, Css.TEXT_BOX);
        addStyleSheets(Assets.getCss("drawer.css"));
        addIcons(Assets.getImage("logo_128.png"));

        ScenicView.show(getScene());
    }
}
