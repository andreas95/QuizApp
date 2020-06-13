package main.java.com.andreas.quizapp.misc;

import javafx.scene.Parent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ThemeManager {
    private static List<Parent> parentNodes = new ArrayList<>();
    private static File themeFile = new File("src/main/resources/css/modern.css");

    public static void refreshTheme() {
        if (themeFile.exists()) {
            String themePath = themeFile.toURI().toString();

            for (Parent parent : parentNodes) {
                parent.getStylesheets().remove(1);
                parent.getStylesheets().add(1, themePath);
            }
        } else {
            System.out.println("No such theme file found.");
        }
    }

    public static void setTheme(Parent parent) {
        if (themeFile.exists()) {
            parent.getStylesheets().add(themeFile.toURI().toString());
        } else {
            System.out.println("No such theme file found.");
        }
    }
}
