package com.vladaver.maxtrianglesquare.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Point {
    private final double x;
    private final double y;

    public double distanceTo(Point p) {
        double dx = this.x - p.x;
        double dy = this.y - p.y;
        return Math.sqrt(dx*dx + dy*dy);
    }
}
