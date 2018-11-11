package com.test.classes;

import org.testng.Assert;
import org.testng.annotations.*;

import static org.mockito.Mockito.*;

import java.lang.reflect.Field;

public class TestPen {

    private Pen pen;

    @BeforeSuite
    public void setUp()
    {
        System.out.println("System is ready for testing");
    }

    @AfterSuite
    public void tearDown()
    {
        System.out.println("System was tested");
    }

    @DataProvider
    public Object [][] shouldWorkingIfContainerIsNotEmpty()
    {
        return new Object[][]{
                {1000, pen.isWork()},
        };
    }

    @Test(dataProvider = "shouldWorkingIfContainerIsNotEmpty")
    public void testPenIsWork_IsPenWork(Integer inkContainer, Boolean res)
    {
        pen = new Pen(inkContainer);
        Assert.assertTrue(res);
    }

    @DataProvider
    public Object [][] shouldNotWorkingIfContainerIsEmpty()
    {
        return new Object[][]{
                {-1,pen.isWork()},
                {0, pen.isWork()},
        };
    }

    @Test(dataProvider = "shouldNotWorkingIfContainerIsEmpty")
    public void testPenIsWork_IsPenWorkIfContEmpty(int inkContainer, boolean res)
    {
        pen = new Pen(inkContainer);
        Assert.assertFalse(res);
    }

    @Test
    public void testPenDoSomethingElse_ShouldDoSomethingElse()
    {
        Pen pen = mock(Pen.class);
        doNothing().when(pen).doSomethingElse();
    }

    @Test
    public void testPenGetColor_ShouldPrintRightColor()
    {
        pen = new Pen(100,1.0,"RED");
        Assert.assertEquals("RED", pen.getColor());
    }

    @Test
    public void testPenGetColor_ShouldNotPrintColor()
    {
        pen = new Pen(100,1.0,"");
        Assert.assertEquals("", pen.getColor());
    }

    @DataProvider
    public Object [][] shouldWriteAnythingObject()
    {
        return new Object[][]{
                {0,4,"qwertyu",""},
                {-1,0,"testString",""},
                {1,-4,"qwer",""},
                {0,0,"qweqwe",""},
                {1.5,4,"qwqw","qwqw"},
        };
    }

    @Test(dataProvider = "shouldWriteAnythingObject")
    public void testPenWrite_ShouldWriteAnything(double sizeLetter, int inkContainer, String actual, String expected)
    {
        pen = new Pen(inkContainer, sizeLetter);
        Assert.assertEquals(pen.write(actual), expected);
    }

    @DataProvider
    public Object [][] constructorWithOneParametrObject()
    {
        return new Object[][]{
                {100},
        };
    }

    @Test(dataProvider = "constructorWithOneParametrObject")
    public void testPen_constructorWithOneParametr(Integer inkContainer) throws NoSuchFieldException, IllegalAccessException {
        Pen pen = new Pen(inkContainer);

        Field field = Pen.class.getDeclaredField("inkContainerValue");
        field.setAccessible(true);
        Integer value = (Integer) field.get(pen);
        Assert.assertEquals(value, inkContainer);
    }

    @DataProvider
    public Object [][] constructorWithTwoParametrObject()
    {
        return new Object[][]{
                {100, 1.0},
        };
    }

    @Test(dataProvider = "constructorWithTwoParametrObject")
    public void testPen_constructorWithTwoParametr(Integer inkContainer, Double sizeLetter) throws NoSuchFieldException, IllegalAccessException {
        Pen pen = new Pen(inkContainer, sizeLetter);

        Field field = Pen.class.getDeclaredField("inkContainerValue");
        Field field1 = Pen.class.getDeclaredField("sizeLetter");
        field.setAccessible(true);
        field1.setAccessible(true);
        Integer value = (Integer) field.get(pen);
        Double value1 = (Double) field1.get(pen);
        Assert.assertEquals(value, inkContainer);
        Assert.assertEquals(value1,sizeLetter);
    }

    @DataProvider
    public Object [][] constructorWithThreeParametrObject()
    {
        return new Object[][]{
                {100,1.0,"RED"},
        };
    }

    @Test(dataProvider = "constructorWithThreeParametrObject")
    public void testPen_constructorWithThreeParametr(Integer inkContainer, Double sizeLetter, String color) throws NoSuchFieldException, IllegalAccessException {
        Pen pen = new Pen(inkContainer, sizeLetter, color);

        Field field = Pen.class.getDeclaredField("inkContainerValue");
        Field field1 = Pen.class.getDeclaredField("sizeLetter");
        Field field2 = Pen.class.getDeclaredField("color");
        field.setAccessible(true);
        field1.setAccessible(true);
        field2.setAccessible(true);
        Integer value = (Integer) field.get(pen);
        Double value1 = (Double) field1.get(pen);
        String value2 = (String) field2.get(pen);
        Assert.assertEquals(value, inkContainer);
        Assert.assertEquals(value1,sizeLetter);
        Assert.assertEquals(value2,color);
    }

}