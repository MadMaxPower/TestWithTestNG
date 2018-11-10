package com.test.classes;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPen {

    private Pen pen = new Pen(1000,1.0,"Red");

    @Test
    public void testIsTheColorOfPenIsRight() throws Exception
    {
        Assert.assertEquals("Red",pen.getColor());
    }


}