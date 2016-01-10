package quadratischeFunktionen;

/**
 * @version 0.1 22.12.2015
 * @author Thomas Kirz, Sebastian Vogt
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.Scanner;

public class Main extends Application {

    Button button;

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new SwingGUI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // launch(args);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben Sie bitte die Parameter einer quadratischen Funktionen nach \"ax² + bx + c\" an.");

        QuadraticFunction testFunction;

        System.out.print("a: ");
        double a = Double.parseDouble(scanner.next());
        System.out.print("b: ");
        double b = Double.parseDouble(scanner.next());
        System.out.print("c: ");
        double c = Double.parseDouble(scanner.next());

        try {
            testFunction = new QuadraticFunction(a, b, c);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return;
        }

        System.out.println(testFunction.toNormalString());
        System.out.println(testFunction.toVertexString());
        System.out.println(testFunction.toZeroString());
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Quadratische Funktionen");
        button = new Button("Klick mich!");

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
