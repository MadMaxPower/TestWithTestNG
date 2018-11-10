package com.test.classes;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;
import java.util.Iterator;

public class TestPen {

    private Pen pen;

    @BeforeMethod
    public void setUp()
    {
        //System.out.println("Метод тестируется");
    }

    @AfterMethod
    public void tearDown()
    {
        //System.out.println("Метод протестировался");
    }

//    @DataProvider
//    public Object [][] shouldWriteAnythingObject()
//    {
//        return new Object[][]{
//                {"Hello", pen.write("Hello")},
//                {"", pen.write("")},
//                {null, null},
//        };
//    }
//
//    @Test(dataProvider = "shouldWriteAnythingObject")
//    public void testPenWrite_ShouldWriteAnything(String actual, String expected)
//    {
//        pen = new Pen();
//        Assert.assertEquals(actual,expected);
//    }

//    @DataProvider
//    public Object [][] shouldWorkingIfContainerIsNotEmpty()
//    {
//        return new Object[][]{
//                {100, pen.isWork()},
//        };
//    }
//
//    @Test(dataProvider = "shouldWorkingIfContainerIsNotEmpty")
//    public void testPenIsWork_IsPenWork(int inkContainer, Boolean res)
//    {
//        pen = new Pen(inkContainer);
//        Assert.assertTrue(pen.isWork());
//    }


//    @Test
//    public void testPen_constructorWithInkContainer()
//    {
//        int inkContainer = 100;
//        pen = new Pen(inkContainer);
//        //Assert.assertEquals();
//    }

    @Test
    public void testPenGetColor_ShouldPrintRedColor()
    {
        pen = new Pen(1000,1.0,"RED");
        Assert.assertEquals(pen.getColor(),"RED");
    }

//    @DataProvider
//    public Object [][] shouldWriteAnythingObject1()
//    {
//        return new Object[][]{
//                {0,4,"qwertyu",""},
//                {2.0,0,"testString",""},
//                {5.5,4,"qwer","qwer"},
//        };
//    }
//
//    @Test(dataProvider = "shouldWriteAnythingObject1")
//    public void testPenWrite_ShouldWriteAnything1(double sizeLetter, int inkContainer, String actual, String expected)
//    {
//        pen = new Pen(inkContainer, sizeLetter);
//        Assert.assertEquals(pen.write(actual), expected);
//    }

    @Test
    public void testPenGetColor_ShouldNotPrintColor()
    {
        pen = new Pen(1000,1.0,"");
        Assert.assertEquals(pen.getColor(),"");
    }

    @Test
    public void testPenIsWork_ShouldNotWorking()
    {
        pen = new Pen(0);
        Assert.assertFalse(pen.isWork());
    }

    @Test
    public void testPenIsWork_ShouldWorking()
    {
        pen = new Pen(100);
        Assert.assertTrue(pen.isWork());
    }

    @Test
    public void testPenWrite_InkMoreThanSizeWordAndLetter0()
    {
        pen = new Pen(100,0);
        Assert.assertEquals(pen.write("test"),"");
    }

    @Test
    public void testPenWrite_InkMoreThanSizeWordAndLetter1()
    {
        pen = new Pen(100,1.0);
        Assert.assertEquals(pen.write("test"),"test");
    }

    @Test
    public void testPenWrite_InkLessThanSizeWordAndLetter1()
    {
        pen = new Pen(4,1.0);
        Assert.assertEquals(pen.write("testing"),"test");
    }

    @Test
    public void testPenWrite_InkLessThanSizeWordAndLetter0()
    {
        pen = new Pen(4,0);
        Assert.assertEquals(pen.write("testing"),"");
    }

    @Test
    public void testPenWrite_InkEqualSizeWordAndLetter0()
    {
        pen = new Pen(4,0);
        Assert.assertEquals(pen.write("test"),"");
    }

    @Test
    public void testPenWrite_InkEqualSizeWordAndLetter1()
    {
        pen = new Pen(4,1);
        Assert.assertEquals(pen.write("test"),"test");
    }

    @Test
    public void testPenDoSomethingElse_ShouldDoSomethingElse()
    {
//        Comparable c = mock(Comparable.class);
//        when(c.compareTo("Test")).thenReturn(1);
//        Assert.assertEquals(1, c.compareTo("Test"));
        pen = new Pen(1000,1.0,"RED");
        pen.doSomethingElse();
    }

}