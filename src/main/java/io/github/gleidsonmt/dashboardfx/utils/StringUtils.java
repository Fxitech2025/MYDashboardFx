package io.github.gleidsonmt.dashboardfx.utils;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  14/03/2025
 */
public class StringUtils {

    public static String capitalize(String string) {
        return string.substring(0,1).toUpperCase() + string.substring(1).toLowerCase();
    }
}
