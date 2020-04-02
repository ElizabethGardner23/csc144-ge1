package edu.cornellcollege.matricesandvectors;

/**
 *
 * @author Elizabeth Gardner
 * @version 31 March 2020
 */
public class Vector2D {

    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    } // Vector2D(double, double)  constructor

    public Vector2D add(Vector2D v) {
        double xCoord = this.getX() + v.getX();
        double yCoord = this.getY() + v.getY();
        return new Vector2D(xCoord, yCoord);
    } // add(Vector2D)

    public Vector2D subtract(Vector2D v) {
        double xCoord = this.getX() - v.getX();
        double yCoord = this.getY() - v.getY();
        return new Vector2D(xCoord, yCoord);
    } // subtract(Vector2D)
    
    public double dot(Vector2D v) {
        double xProduct = this.getX() * v.getX();
        double yProduct = this.y * v.getY();
        return xProduct + yProduct;
    } // dot(Vector2D)
    
    public double magnitude() {
        return Math.sqrt(this.dot(this));
    } // magnitude()

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ")";
    } // toString()

    public double getX() {
        return this.x;
    } // getX()

    public double getY() {
        return this.y;
    } // getY()
} // Vector2D