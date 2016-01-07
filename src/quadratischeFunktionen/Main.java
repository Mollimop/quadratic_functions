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

import java.util.Scanner;

public class Main extends Application {

    Button button;

    public static void main(String[] args) {
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
        System.out.print("How much values?: ");
        int xquantity =(int) Double.parseDouble(scanner.next());    //decimals will be cut off, in a further release this will throw an Exception
        System.out.print("Step?: ");
        double xstep = Double.parseDouble(scanner.next());
        System.out.print("Start?: ");
        double xstart = Double.parseDouble(scanner.next());

        try {
            testFunction = new QuadraticFunction(a, b, c);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return;
        }

        System.out.println("Your function:" + testFunction.toNormalString());
        System.out.println("Function in vertex form:" + testFunction.toVertexString());
        System.out.println("X-Values:");
        double xValues[] = testFunction.generateXvalues(xquantity, xstep, xstart);
        for(int i = 0; i < xValues.length; i++){
            System.out.println(xValues[i]);
        }
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
