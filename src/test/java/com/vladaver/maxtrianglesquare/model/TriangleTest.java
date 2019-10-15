package com.vladaver.maxtrianglesquare.model;

import com.vladaver.maxtrianglesquare.exception.TriangleSquareException;
import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

    private static final double DELTA = 0.01;
    private  Double[] arr1 = {0.0, 0.0, 10.0, 2.0, 2.0, 10.0};
    private  Double[] arr2 = {-1.0, -1.0, -5.0, 0.0, 0.0, -5.0};
    Triangle triangle = new Triangle(arr1);
    Triangle triangle2 = new Triangle(arr2);

    public TriangleTest() throws TriangleSquareException {
    }

    @Test
    public void testSquare(){
        Assert.assertEquals(48, triangle.getSquare(), DELTA);
        Assert.assertEquals(7.5, triangle2.getSquare(), DELTA);
    }
}
