package quadratischeFunktionen;

/**
 * @version 0.1 22.12.2015
 * @author Thomas
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    Button button;

    public static void main(String[] args) {
        // launch(args);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben Sie bitte die Parameter einer quadratischen Funktionen nach \"ax² + bx + c\" an.");

        System.out.print("a: ");
        double a = Double.parseDouble(scanner.next());
        System.out.print("b: ");
        double b = Double.parseDouble(scanner.next());
        System.out.print("c: ");
        double c = Double.parseDouble(scanner.next());

        QuadraticFunction testFunction = new QuadraticFunction(a, b, c);
        System.out.println(testFunction.toNormalString());
        System.out.println(testFunction.toVertexString());
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
