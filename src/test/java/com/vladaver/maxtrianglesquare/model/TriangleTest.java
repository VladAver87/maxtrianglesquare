package com.vladaver.maxtrianglesquare.model;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

    Triangle triangle = new Triangle(new Point(0, 0), new Point(10, 2), new Point(2, 10));
    Triangle triangle2 = new Triangle(new Point(-1, -1), new Point(-5, 0), new Point(0, -5));

    @Test
    public void testSquare(){
        Assert.assertEquals(48.0, triangle.square(), 0);
        Assert.assertEquals(7.5, triangle2.square(), 0);
    }
}
