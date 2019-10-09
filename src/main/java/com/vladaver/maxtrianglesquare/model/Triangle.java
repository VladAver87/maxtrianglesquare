package com.vladaver.maxtrianglesquare.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Triangle implements Shape {
    private Point a;
    private Point b;
    private Point c;

    public double square(){
        double square = (((b.getX() - a.getX())*(c.getY() - a.getY())) - ((c.getX() - a.getX())*(b.getY() - a.getY()))) / 2;
        if (square < 0){
            return square * (-1);
        }
        return square;
    }
}
