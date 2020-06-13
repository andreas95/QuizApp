package main.java.com.andreas.quizapp.misc;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Parent;
import javafx.util.Duration;

public class Transitions {

    public static void fadeInPanel(Parent root) {
        DoubleProperty opacity = root.opacityProperty();
        Timeline fadeIn = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                new KeyFrame(new Duration(2000), new KeyValue(opacity, 1.0))
        );
        fadeIn.play();
    }
}
