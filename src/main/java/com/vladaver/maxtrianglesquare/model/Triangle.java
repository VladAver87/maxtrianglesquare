package com.vladaver.maxtrianglesquare.model;


public class Triangle{
    private Point a;
    private Point b;
    private Point c;
    private double ab;
    private double bc;
    private double ac;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
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
