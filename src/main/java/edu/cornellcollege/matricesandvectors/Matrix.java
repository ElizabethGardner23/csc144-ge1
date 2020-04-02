package edu.cornellcollege.matricesandvectors;

/**
 *
 * @author Elizabeth Gardner
 * @ version 31 March 2020
 */
public class Matrix {

    private double[][] elements = new double[2][2];

    public Matrix() {
        this.elements[0][0] = 1.0;
        this.elements[0][1] = 0.0;
        this.elements[1][0] = 0.0;
        this.elements[1][1] = 1.0;
    } // Operator()

    public Matrix(double m00, double m01, double m10, double m11) {
        this.elements[0][0] = m00;
        this.elements[0][1] = m01;
        this.elements[1][0] = m10;
        this.elements[1][1] = m11;
    } // Operator(double, double, double, double)

    public void rotation(double angle) {
        this.elements[0][0] = Math.cos(angle);
        this.elements[0][1] = -Math.sin(angle);
        this.elements[1][0] = Math.sin(angle);
        this.elements[1][1] = Math.cos(angle);
    } // rotation(double)

    public Matrix multiply(Matrix otherMatrix) {
        double left00 = this.elements[0][0];
        double left01 = this.elements[0][1];
        double left10 = this.elements[1][0];
        double left11 = this.elements[1][1];
        double right00 = otherMatrix.elements[0][0];
        double right01 = otherMatrix.elements[0][1];
        double right10 = otherMatrix.elements[1][0];
        double right11 = otherMatrix.elements[1][1];
        double p00 = (left00 * right00) + (left01 * right10);
        double p01 = (left00 * right01) + (left01 * right11);
        double p10 = (left10 * right00) + (left11 * right10);
        double p11 = (left10 * right01) + (left11 * right11);
        return new Matrix(p00, p01, p10, p11);
    } // multiply(Matrix)
    
    public String multiplyVector2D(Vector2D vector) {
        double matrix00 = this.elements[0][0];
        double matrix01 = this.elements[0][1];
        double matrix10 = this.elements[1][0];
        double matrix11 = this.elements[1][1];
        double vector0 = vector.getX();
        double vector1 = vector.getY();
        double p0 = (matrix00 * vector0) + (matrix01 * vector1);
        double p1 = (matrix10 * vector0) + (matrix11 * vector1);
        return "[(" + p0 + "), (" + p1 + ")]";
    } // multiplyVector2D(Vector2D)

    @Override
    public String toString() {
        double m00 = this.elements[0][0];
        double m01 = this.elements[0][1];
        double m10 = this.elements[1][0];
        double m11 = this.elements[1][1];
        String row0 = "(" + m00 + ", " + m01 + ")";
        String row1 = "(" + m10 + ", " + m11 + ")";
        return "[" + row0 + ", " + row1 + "]";
    } // toString()

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Matrix identity = new Matrix();
        System.out.println("Identity = " + identity);
        Matrix product = identity.multiply(identity);
        System.out.println("Product = " + product);
        Matrix ccw = new Matrix();
        ccw.rotation(Math.PI/4);
        Matrix cw = new Matrix();
        cw.rotation(-Math.PI/4);
        Matrix totalRotation = ccw.multiply(cw);
        System.out.println("ccw = " + ccw);
        System.out.println("cw = " + cw);
        System.out.println("total rotation = " + totalRotation);
        Matrix testMatrix = new Matrix();
        Vector2D testVector = new Vector2D(1,0);
        String testProduct = testMatrix.multiplyVector2D(testVector);
        System.out.println(testMatrix + " * " + testVector.toString() + " = " + testProduct);
    } // main(String[])  
} // Matrix