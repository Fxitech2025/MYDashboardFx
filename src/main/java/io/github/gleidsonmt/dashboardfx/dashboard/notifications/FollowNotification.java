package io.github.gleidsonmt.dashboardfx.dashboard.notifications;

import io.github.gleidsonmt.dashboardfx.dashboard.notifications.factory.NotificationBase;
import io.github.gleidsonmt.dashboardfx.dashboard.notifications.factory.NotificationType;
import io.github.gleidsonmt.dashboardfx.model.User;

import java.time.LocalDateTime;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  23/04/2025
 */
public class FollowNotification extends NotificationBase {

    public FollowNotification(User user, LocalDateTime dateTime, boolean visualized) {
        super(user, dateTime, visualized);
    }

    @Override
    public NotificationType getType() {
        return NotificationType.FOLLOW;
    }

}
