package com.vladaver.maxtrianglesquare.util;

import com.vladaver.maxtrianglesquare.exception.TriangleSquareException;
import org.junit.Assert;
import org.junit.Test;

public class InputDataConverterTest {
    private  Double[] result = {0.0, 0.0, 10.0, 2.0, 2.0, 10.0};
    private  String line = "0 0 10 2 2 10";
    private  String line1 = "0 0 10 2 2 Str";
    private  String line2 = "0 10 2 2 10";
    private  String line3 = "";
    private InputDataConverter converter = new InputDataConverter();

    @Test
    public void convertTest() throws TriangleSquareException {
        Assert.assertEquals(result, converter.convert(line));
    }

    @Test(expected = TriangleSquareException.class)
    public void TriangleSquareExceptionTest1() throws TriangleSquareException {
        converter.convert(line1);
    }

    @Test(expected = TriangleSquareException.class)
    public void TriangleSquareExceptionTest2() throws TriangleSquareException {
        converter.convert(line2);
    }

    @Test(expected = TriangleSquareException.class)
    public void TriangleSquareExceptionTest3() throws TriangleSquareException {
        converter.convert(line3);
    }
}
