package com.vladaver.maxtrianglesquare.model;


import com.vladaver.maxtrianglesquare.exception.TriangleSquareException;

public class Triangle{
    private Point a;
    private Point b;
    private Point c;
    private double ab;
    private double bc;
    private double ac;

    public Triangle(Double[] points) throws TriangleSquareException {
        this.a = new Point(points[0], points[1]);
        this.b = new Point(points[2], points[3]);
        this.c = new Point(points[4], points[5]);
        this.ab = a.distanceTo(b);
        this.bc = b.distanceTo(c);
        this.ac = a.distanceTo(c);
    }

    public double getSquare(){
        double p = (ab + bc + ac) / 2;
        double square = Math.sqrt(p * (p-ab) * (p-bc) * (p-ac));
        return square;
    }

    public boolean isIsosceles(){
        if ((ab == bc) || (ab == ac) || (bc == ac)) return true;
        return false;
    }
}
