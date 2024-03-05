package j2375.dsrc.itsasbeta1;

import java.util.Vector;

public class Vector2f {
    private double x;
    private double y;

    public Vector2f(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    public double dotProduct(Vector2f other) {
        return this.x * other.x + this.y * other.y;
    }

    public static double dotProduct(Vector2f v1, Vector2f v2) {
        return v1.getX() * v2.getX() + v1.getY() * v2.getY();
    }

    public static Vector2f findPerpendicular(Vector2f v1, Vector2f v2, double d) {
        // Calculate midpoint
        double midX = (v1.getX() + v2.getX()) / 2.0;
        double midY = (v1.getY() + v2.getY()) / 2.0;

        // Calculate the slope of the line
        double slope = (v2.getY() - v1.getY()) / (v2.getX() - v1.getX());

        // Calculate the negative reciprocal of the slope to get the perpendicular line slope
        double pslope = -1 / slope;

        // Calculate the coord of the perpendicular point
        double newX = midX + d / Math.sqrt(1 + pslope * pslope);
        double newY = midY + pslope * (newX - midX);

        return new Vector2f(newX, newY);
    }

   public double length() {
        return Math.sqrt(x*x + y*y);
   }

    public Vector2f normalVector() {
        double d = Math.sqrt((x * x) + (y * y));
        return new Vector2f(x/d, y/d);
    }

    public Vector2f new_length(double d) {
        double length = Math.sqrt((x * x) + (y * y));
        Vector2f return_vector = new Vector2f(x * d / length, y * d / length);
        return return_vector;
    }
}



