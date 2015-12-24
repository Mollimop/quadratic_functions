package quadratischeFunktionen;

import java.awt.geom.Point2D;

/**
 * @author Thomas
 * @version 1.0 22.12.2015
 */
public class QuadraticFunction {
    //Suggestion for x-values:
    //
    //private int xquantity;                          (result of user input)
    //private double[] fx = new double[xquantity];
    //private double xstep                            (result of user input)
    //privte double xstart                            (result of user input)
    //private double x = xstart
    //for(int i = 0; i <= xquantity; i++){
    //   fx[i] =  a * (Math.pow(x, 2)) + b * x + c    (the values of the array fx are the program's output)
    //   x = x + xstep
    //}


    /**
     * Parameters of the function (abc for ax² + bx + c and ade for a(x + d)² + e
     */
    private double a, b, c, d, e;

    /**
     * The vertex of the function
     */
    Point2D.Double vertex;

    /**
     * * Initializes a function with a, b and c and generates d, e and the vertex
     *
     * @throws IllegalArgumentException if a is zero
     */
    public QuadraticFunction(double a, double b, double c) throws IllegalArgumentException {
        if (a == 0) {
            throw new IllegalArgumentException("a must not be 0!");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        generateVertex();
    }

    /**
     * @return the parameter a of the function
     */
    public double getA() {
        return a;
    }

    /**
     * @return the parameter b of the function
     */
    public double getB() {
        return b;
    }

    /**
     * @return the parameter c of the function
     */
    public double getC() {
        return c;
    }

    /**
     * @return the parameter d of the function
     */
    public double getD() {
        return d;
    }

    /**
     * @return the parameter e of the function
     */
    public double getE() {
        return e;
    }

    /**
     * Calculates y of the function for a given x
     *
     * @return y
     */
    public double getImageOf(double x) {
        return a * x * x + b * x + c;
    }

    /**
     * Gets the vertex of the function as a Point2D
     *
     * @return the vertex
     */
    public Point2D.Double getVertex() {
        return vertex;
    }

    /**
     * Generates the parameters d and e of the function f(x) = a(x + d)² + e
     * Used in constructor QuadraticFunction(double a, double b, double c)
     */
    private void generateVertex() {
        d = - b / (2 * a);
        e = (4 * a * c - b * b) / (4 * a);

        vertex = new Point2D.Double(-d, e);
    }

    /**
     * Generates a string of the function like ax²+ bx + c
     *
     * @return the string
     */
    public String toNormalString() {
        String part1, part2, part3;

        part1 = a + "x²";

        if (b > 0) {
            part2 = " + " + b + "x";
        } else if (b < 0) {
            part2 = " - " + -b + "x";
        } else {
            part2 = "";
        }

        if (c > 0) {
            part3 = " + " + c;
        } else if (c < 0) {
            part3 = " - " + -c;
        } else {
            part3 = "";
        }

        return part1 + part2 + part3;
    }

    /**
     * Generates a string of the function like a(x + d)²+ e
     * @return the string
     */
    public String toVertexString() {
        String part1, part2;
        if (d > 0) {
            part1 = a + "(x + " + d + ")²";
        } else if (d < 0) {
            part1 = a + "(x - " + -d + ")²";
        } else {
            part1 = a + "x²";
        }

        if (e > 0) {
            part2 = " + " + e;
        } else if (e < 0) {
            part2 = " - " + -e;
        } else {
            part2 = "";
        }

        return part1 + part2;
    }
}
