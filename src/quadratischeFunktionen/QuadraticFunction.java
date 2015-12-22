package quadratischeFunktionen;

/**
 * @author Thomas
 * @version 1.0 22.12.2015
 */
public class QuadraticFunction {
    private double a, b, c, d, e;
    int vergin_x, vergin_y;

    public QuadraticFunction(double a, double b, double c) throws IllegalArgumentException {
        if (a == 0) {
            throw new IllegalArgumentException("a must not be 0!");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        generateVertex();
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public double getE() {
        return e;
    }

    public int getVergin_x() {
        return vergin_x;
    }

    public int getVergin_y() {
        return vergin_y;
    }

    private void generateVertex() {
        d = - b / (2 * a);
        e = (4*a*c - b*b) / (4 * a);
    }

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
