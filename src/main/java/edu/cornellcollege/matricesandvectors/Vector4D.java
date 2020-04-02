package edu.cornellcollege.matricesandvectors;

/**
 *
 * @author Elizabeth Gardner
 * @version 1 April 2020
 */
public class Vector4D {

    private double x;
    private double y;
    private double z;
    private double rgba;

    public double getX() {
        return this.x;
    } // getX()

    public double getY() {
        return this.y;
    } // getY()

    public double getZ() {
        return this.z;
    } // getZ()

    public double getRGBA() {
        return this.rgba;
    } // getRGBA()

    public Vector4D(double x, double y, double z, double rgba) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.rgba = rgba;
    } // Vector4D(double, double, double, double) 

    public Vector4D add(Vector4D v) {
        double newX = this.getX() + v.getX();
        double newY = this.getY() + v.getY();
        double newZ = this.getZ() + v.getZ();
        double newRGBA = this.getRGBA() + v.getRGBA();
        return new Vector4D(newX, newY, newZ, newRGBA);
    } // add(Vector4D)

    public Vector4D subtract(Vector4D v) {
        double newX = this.getX() - v.getX();
        double newY = this.getY() - v.getY();
        double newZ = this.getZ() - v.getZ();
        double newRGBA = this.getRGBA() - v.getRGBA();
        return new Vector4D(newX, newY, newZ, newRGBA);
    } // subtract(Vector4D)

    public double dot(Vector4D v) {
        double xProduct = this.getX() * v.getX();
        double yProduct = this.y * v.getY();
        double zProduct = this.getZ() * v.getZ();
        double rgbaProduct = this.rgba * v.getRGBA();
        return xProduct + yProduct + zProduct + rgbaProduct;
    } // dot(Vector4D)

    public double magnitude() {
        return Math.sqrt(this.dot(this));
    } // magnitude()

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + getZ() + ", " + getRGBA()
                + ")";
    } // toString()
} // Vector4D