package edu.cornellcollege.matricesandvectors;

/**
 *
 * @author Elizabeth Gardner
 * @version 1 April 2020
 */
public class Matrix4x4 {
    
    private double[][] elements = new double[4][4];
    
    public Matrix4x4() {
        this.identity();
    } // Operator()

    public double get(int row, int column) {
        return this.elements[row][column];
    } // get( int, int )

    public void set(int row, int column, double value) {
        this.elements[row][column] = value;
    } // set( int, int, double )

    public final void identity() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    this.set(i, j, 1.0);
                } // if
                else {
                    this.set(i, j, 0.0);
                } // else
            } // for
        } // for
    } // identity()
    
    public void rotationX(double angle) {
        this.identity();
        this.elements[0][0] = 1;
        this.elements[0][1] = 0;
        this.elements[0][2] = 0;
        this.elements[0][3] = 0;
        this.elements[1][0] = 0;
        this.elements[1][1] = Math.cos(angle);
        this.elements[1][2] = -Math.sin(angle);
        this.elements[1][3] = 0;
        this.elements[2][0] = 0;
        this.elements[2][1] = Math.sin(angle);
        this.elements[2][2] = Math.cos(angle);
        this.elements[2][3] = 0;
        this.elements[3][0] = 0;
        this.elements[3][1] = 0;
        this.elements[3][2] = 0;
        this.elements[3][3] = 1;
    } // rotationX(double)
    
    public void rotationY(double angle) {
        this.identity();
        this.elements[0][0] = Math.cos(angle);
        this.elements[0][1] = 0;
        this.elements[0][2] = Math.sin(angle);
        this.elements[0][3] = 0;
        this.elements[1][0] = 1;
        this.elements[1][1] = 0;
        this.elements[1][2] = 0;
        this.elements[1][3] = 0;
        this.elements[2][0] = -Math.sin(angle);
        this.elements[2][1] = 0;
        this.elements[2][2] = Math.cos(angle);
        this.elements[2][3] = 0;
        this.elements[3][0] = 0;
        this.elements[3][1] = 0;
        this.elements[3][2] = 0;
        this.elements[3][3] = 1;    
    } // rotationY(double)
    
    public void rotationZ(double angle) {
        this.identity();
        this.elements[0][0] = Math.cos(angle);
        this.elements[0][1] = -Math.sin(angle);
        this.elements[0][2] = 0;
        this.elements[0][3] = 0;
        this.elements[1][0] = Math.sin(angle);
        this.elements[1][1] = Math.cos(angle);
        this.elements[1][2] = 0;
        this.elements[1][3] = 0;
        this.elements[2][0] = 0;
        this.elements[2][1] = 0;
        this.elements[2][2] = 1;
        this.elements[2][3] = 0;
        this.elements[3][0] = 0;
        this.elements[3][1] = 0;
        this.elements[3][2] = 0;
        this.elements[3][3] = 1;
    } // rotation( double )

    public Matrix4x4 multiply(Matrix4x4 otherMatrix4x4) {
        Matrix4x4 product = new Matrix4x4();
        for( int row = 0; row < 4; row++ ) {
            for( int column = 0; column < 4; column++ ) {
                double sum = 0.0;
                for( int k = 0; k < 4; k++ ) {
                    sum += this.get( row, k) * otherMatrix4x4.get( k, column);
                } // for
                product.set( row, column, sum);
            } // for
        } // for
        return product;
    } // multiply( Operator )
    
    public String multiply(Vector4D vector) {
        double matrix00 = this.elements[0][0];
        double matrix01 = this.elements[0][1];
        double matrix02 = this.elements[0][2];
        double matrix03 = this.elements[0][3];
        double matrix10 = this.elements[1][0];
        double matrix11 = this.elements[1][1];
        double matrix12 = this.elements[1][2];
        double matrix13 = this.elements[1][3];
        double matrix20 = this.elements[2][0];
        double matrix21 = this.elements[2][1];
        double matrix22 = this.elements[2][2];
        double matrix23 = this.elements[2][3];
        double matrix30 = this.elements[3][0];
        double matrix31 = this.elements[3][1];
        double matrix32 = this.elements[3][2];
        double matrix33 = this.elements[3][3];
        double vector0 = vector.getX();
        double vector1 = vector.getY();
        double vector2 = vector.getZ();
        double vector3 = vector.getRGBA();
        double p0 = (matrix00 * vector0) + (matrix01 * vector1) + 
                (matrix02 * vector2) + (matrix03 * vector3);
        double p1 = (matrix10 * vector0) + (matrix11 * vector1) + 
                (matrix12 * vector2) + (matrix13 * vector3);
        double p2 = (matrix20 * vector0) + (matrix21 * vector1) + 
                (matrix22 * vector2) + (matrix23 * vector3);
        double p3 = (matrix30 * vector0) + (matrix31 * vector1) + 
                (matrix32 * vector2) + (matrix33 * vector3);
        return "[(" + p0 + "), (" + p1 + "), (" + p2 + "), (" + p3 + ")]";
    } // multiply(Vector4D)

    private String rowToString( int row ) {
        StringBuilder result = new StringBuilder();
        
        result.append( "(" );
        for( int i = 0; i < 3; i++ ) {
            result.append( this.get(row, i ));
            result.append( ", ");
        } // for
        result.append( this.get(row, 3 ));
        result.append( ")" );
        
        return result.toString();
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        
        result.append( "[" );
        for( int i = 0; i < 3; i++ ) {
            result.append( rowToString(i) );
            result.append( ", " );
        } // for
        result.append( rowToString(3));
        result.append( "]" );
        return result.toString();
    } // toString()

    public static void main(String[] args) {
        Matrix4x4 identity = new Matrix4x4();
        System.out.println("Identity = " + identity);

        Matrix4x4 product = identity.multiply(identity);
        System.out.println("Product = " + product);

        Matrix4x4 ccw = new Matrix4x4();
        ccw.rotationZ(Math.PI / 4);

        Matrix4x4 cw = new Matrix4x4();
        cw.rotationZ(-Math.PI / 4);

        Matrix4x4 totalRotation = ccw.multiply(cw);

        System.out.println("ccw = " + ccw);
        System.out.println("cw = " + cw);
        System.out.println("total rotation = " + totalRotation);
    } // main(String [])
} // Matrix4x4
