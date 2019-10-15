package com.vladaver.maxtrianglesquare.model;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    private static final double DELTA = 0.01;
    private Point p = new Point(0, 10);
    private Point p2 = new Point(-5, -1);

    @Test
    public void distanceToTest(){
        Assert.assertEquals(12.08, p.distanceTo(p2), DELTA);
    }
}
