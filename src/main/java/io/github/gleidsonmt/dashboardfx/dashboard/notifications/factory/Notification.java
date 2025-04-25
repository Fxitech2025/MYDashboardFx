package io.github.gleidsonmt.dashboardfx.dashboard.notifications.factory;

import io.github.gleidsonmt.dashboardfx.model.User;

import java.time.LocalDateTime;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  23/04/2025
 */
public interface Notification {

    User getUser();

    LocalDateTime getDateTime();

    NotificationType getType();

    boolean visualized();

}
