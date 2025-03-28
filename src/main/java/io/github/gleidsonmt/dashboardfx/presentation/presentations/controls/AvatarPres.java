package io.github.gleidsonmt.dashboardfx.presentation.presentations.controls;

import io.github.gleidsonmt.dashboardfx.components.AvatarStackedCircle;
import io.github.gleidsonmt.dashboardfx.presentation.internal.Tutorial;
import io.github.gleidsonmt.dashboardfx.utils.Assets;
import io.github.gleidsonmt.glad.controls.avatar.AvatarCircleView;
import io.github.gleidsonmt.glad.controls.avatar.AvatarRectView;
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
                        .legend("io.github.gleidsonmt.glad.controls.avatar.AvatarCircleView")
                        .legend("All classes in (Shapes) can by apply in avatar.")
                        .h4("Creating", "Avatar View")
                        .text("There's basic two types of creating.")
                        .h5("Circle", "Creating")
                        .demo(new Node[]{
                                        new AvatarCircleView(Assets.getImage("default_avatar.jpg"), 20),
                                        new AvatarCircleView(Assets.getImage("default_avatar.jpg"), 40),
                                        new AvatarCircleView(Assets.getImage("default_avatar.jpg"), 60)
                                }
                        )
                        .code("""
                                AvatarCircleView avatar = new AvatarCircleView();
                                avatar.setImage(Assets.getImage("default_avatar.jpg")); // Can be pass in constructor
                                avatar.setRadius(20); // First 
                                avatar.setRadius(40); // Second
                                avatar.setRadius(60); // Third
                                """)
                        .h5("Rectangle", "Creating")
                        .code("""
                                AvatarRectView avatar = new AvatarRectView() // Constructor
                                avatar.setImage(Assets.getImage("default_avatar.jpg"); // Can passed in constructor
                                avatar.setSize(40); // First 
                                avatar.setSize(60); // Second
                                avatar.setSize(80); // Third
                                """)
                        .legend("io.github.gleidsonmt.glad.controls.avatar.AvatarRectView")
                        .demo(new Node[]{
                                createRectDemo(40, ""),
                                createRectDemo(60, ""),
                                createRectDemo(80, "")
                        })
                        .h5("Arc", "Rectangle")
                        .demo(new Node[]{
                                createRectDemo(40, 10, ""),
                                createRectDemo(60, 20, ""),
                                createRectDemo(80, 30, "")
                        })
                        .code("""
                                avatar.setArc(10); // First
                                avatar.setArc(20); // Second
                                avatar.setArc(30); // Third
                                """)

                        .h4("Stroke", "Avatar View")
                        .h4("Size", "Stroke")
                        .demo(new Node[]{
                                createDemo("stroke-1", "stroke-primary"),
                                createRectDemo(80, "stroke-2", "stroke-primary"),
                                createRectDemo(80, 20, "stroke-3", "stroke-primary")
                        })
                        .code("avatar.getStyleClass().add(\"stroke-[1|2..5]\");")
                        .h4("Color", "Stroke")
//                        .node(createLink("Pallet Color"))
//                        .node(createLink("Home"))
                        .demo(new Node[]{
                                createDemo("stroke-primary", "stroke-3"),
                                createRectDemo(80, "stroke-2", "stroke-success", "stroke-primary"),
                                createRectDemo(80, 20, "stroke-3", "stroke-unique", "stroke-primary")
                        })
                        .code("avatar.getStyleClass().add(\"stroke-[primary|success|unique..]\");")

                        .h4("Effect", "Avatar View")
                        .h3("Depth", "Effect")
                        .demo(new Node[]{
                                createDemo("depth-1"),
                                createRectDemo(80, "stroke-2", "depth-2"),
                                createRectDemo(80, 20, "stroke-2", "depth-2")
//                                createDemo("depth-2")
                        })
                        .code("avatar.getStyleClass().add(\"depth-[1|2]\");")
                        .h3("Raised", "Effect")
                        .legend("Click on it.")
                        .demo(new Node[]{
                                createDemo("raised"),
                                createRectDemo(80, "stroke-2", "depth-2", "raised"),
                                createRectDemo(80, 20, "stroke-2", "depth-2", "raised")
                        })
                        .code("avatar.getStyleClass().add(\"depth-[1|2]\");")
                        .h3("Grouping")
                        .demo(
                                createCustom()
                        )
                        .code("""
                                AvatarStackedCircle avatarStackedCircle = new AvatarStackedCircle(
                                        4,
                                        Assets.getImage("default_avatar.jpg"),
                                        Assets.getImage("default_avatar.jpg"),
                                        Assets.getImage("default_avatar.jpg"),
                                        Assets.getImage("default_avatar.jpg"),
                                        Assets.getImage("default_avatar.jpg")
                                );
                                """)
                        .build().getRoot()
        );
    }


    private Node createCustom() {
        AvatarStackedCircle avatarStackedCircle = new AvatarStackedCircle(
                4,
                Assets.getImage("default_avatar.jpg"),
                Assets.getImage("default_avatar.jpg"),
                Assets.getImage("default_avatar.jpg"),
                Assets.getImage("default_avatar.jpg"),
                Assets.getImage("default_avatar.jpg"),
                Assets.getImage("default_avatar.jpg"),
                Assets.getImage("default_avatar.jpg")
        );
        return avatarStackedCircle;
    }


    private Node createDemo(String... classes) {
        AvatarCircleView avatar = new AvatarCircleView(Assets.getImage("default_avatar.jpg"), 40);
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
