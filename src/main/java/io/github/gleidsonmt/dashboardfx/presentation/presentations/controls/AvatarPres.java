package io.github.gleidsonmt.dashboardfx.presentation.presentations.controls;

import io.github.gleidsonmt.dashboardfx.presentation.internal.Tutorial;
import io.github.gleidsonmt.dashboardfx.utils.Assets;
import io.github.gleidsonmt.glad.controls.avatar.AvatarCircleView;
import io.github.gleidsonmt.glad.controls.avatar.AvatarRectView;
import io.github.gleidsonmt.glad.controls.avatar.AvatarView;
import io.github.gleidsonmt.glad.controls.avatar.StackedAvatar;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  13/03/2025
 */
public class AvatarPres extends StackPane {

    public AvatarPres() {
        getChildren().add(
                new Tutorial()
                        .h3("Avatar View")
                        .text("A simple shape using ImagePattern, to build a shape with an image.")
                        .legend("io.github.gleidsonmt.glad.controls.avatar.AvatarView")
                        .legend("All classes in (Shapes) can by apply in avatar.")

                        .h4("Creating", "Avatar View")
                        .demo(new Node[]{
                                        new AvatarView(Assets.getImage("default_avatar.jpg"), 0,40),
                                        new AvatarView(Assets.getImage("default_avatar.jpg"), 0,60),
                                        new AvatarView(Assets.getImage("default_avatar.jpg"), 0,80)
                                }
                        )
                        .code("""
                                AvatarView avatar = new AvatarView();
                                avatar.setImage(Assets.getImage("default_avatar.jpg")); // Can be pass in constructor
                                avatar.setRadius(20); // First 
                                avatar.setRadius(40); // Second
                                avatar.setRadius(60); // Third
                                """)

                        .h5("Circle", "Creating")
                        .demo(new Node[]{
                                new AvatarView(Assets.getImage("default_avatar.jpg"), 40,40),
                                new AvatarView(Assets.getImage("default_avatar.jpg"), 60,60),
                                new AvatarView(Assets.getImage("default_avatar.jpg"), 80,80),
                        })
                        .code("""
                                avatar.setRadius(20); // to get fully round use the same height
                                """)


                        .h4("Stroke", "Avatar View")
                        .h4("Size", "Stroke")
                        .demo(new Node[]{
                                createDemo("stroke-1", "stroke-primary"),
                                createDemo("stroke-2", "stroke-primary"),
                                createDemo("stroke-3", "stroke-primary")
                        })
                        .code("avatar.getStyleClass().add(\"stroke-[1|2..5]\");")
                        .h4("Color", "Stroke")
//                        .node(createLink("Pallet Color"))
//                        .node(createLink("Home"))
                        .demo(new Node[]{
                                createDemo("stroke-primary", "stroke-3"),
                                createDemo( "stroke-2", "stroke-success", "stroke-primary"),
                                createDemo( "stroke-3", "stroke-unique", "stroke-primary")
                        })
                        .code("avatar.getStyleClass().add(\"stroke-[primary|success|unique..]\");")

                        .h4("Effect", "Avatar View")
                        .h3("Depth", "Effect")
                        .text("A little shadow.")
                        .demo(new Node[]{
                                createDemo("depth-1"),
                                createDemo("stroke-2", "depth-2"),
                                createDemo( "stroke-2", "depth-2")
//                                createDemo("depth-2")
                        })
                        .code("avatar.getStyleClass().add(\"depth-[1|2]\");")
                        .h3("Raised", "Effect")
                        .text("A a shadow when clicked.")
                        .legend("Click on it.")
                        .demo(new Node[]{
                                createDemo("raised"),
                                createDemo("stroke-2", "depth-2", "raised"),
                                createDemo("stroke-2", "depth-2", "raised")
                        })
                        .code("avatar.getStyleClass().add(\"depth-[1|2]\");")
                        .h3("Grouping")
                        .demo(
                                createCustom()
                        )
                        .code("""
                                // first max items, second size and the avatar views
                                return new StackedAvatar(
                                        4, 40,
                                        new AvatarView(Assets.getImage("default_avatar.jpg")),
                                        new AvatarView(Assets.getImage("default_avatar.jpg")),
                                        new AvatarView(Assets.getImage("default_avatar.jpg")),
                                        new AvatarView(Assets.getImage("default_avatar.jpg")),
                                        new AvatarView(Assets.getImage("default_avatar.jpg")),
                                        new AvatarView(Assets.getImage("default_avatar.jpg")),
                                        new AvatarView(Assets.getImage("default_avatar.jpg"))
                                );""")
                        .build().getRoot()
        );
    }


    private Node createCustom() {
//        new AvatarView().setRadius(0);
        // first max items, second size and the avatar views
        return new StackedAvatar(
                4, 40,
                new AvatarView(Assets.getImage("default_avatar.jpg")),
                new AvatarView(Assets.getImage("default_avatar.jpg")),
                new AvatarView(Assets.getImage("default_avatar.jpg")),
                new AvatarView(Assets.getImage("default_avatar.jpg")),
                new AvatarView(Assets.getImage("default_avatar.jpg")),
                new AvatarView(Assets.getImage("default_avatar.jpg")),
                new AvatarView(Assets.getImage("default_avatar.jpg"))
        );
    }


    private Node createDemo(String... classes) {
        AvatarView avatar = new AvatarView(Assets.getImage("default_avatar.jpg"), 20, 80);
        avatar.getStyleClass().addAll(classes);
        return avatar;
    }

    private Node createRectDemo(int size, String... classes) {
        return createRectDemo(size, 0, classes);
    }

    private Node createRectDemo(int size, double arc, String... classes) {
        AvatarRectView avatar = new AvatarRectView(Assets.getImage("default_avatar.jpg"), size, size, arc);
        avatar.getStyleClass().addAll(classes);
        return avatar;
    }
}
