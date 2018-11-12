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
    public Object [][] constructorWithTwoParametrObject1()
    {
        return new Object[][]{
                {100, 1.0},
        };
    }

    @Test(dataProvider = "constructorWithTwoParametrObject1")
    public void testPen_constructorWithTwoParametr1(Integer inkContainer, Double sizeLetter) throws NoSuchFieldException, IllegalAccessException {
        Pen pen = new Pen(inkContainer, sizeLetter);

        Field field = Pen.class.getDeclaredField("inkContainerValue");
        field.setAccessible(true);
        Integer value = (Integer) field.get(pen);
        Assert.assertEquals(value, inkContainer);
    }

    @DataProvider
    public Object [][] constructorWithTwoParametrObject2()
    {
        return new Object[][]{
                {100, 1.0},
        };
    }

    @Test(dataProvider = "constructorWithTwoParametrObject2")
    public void testPen_constructorWithTwoParametr2(Integer inkContainer, Double sizeLetter) throws NoSuchFieldException, IllegalAccessException {
        Pen pen = new Pen(inkContainer, sizeLetter);

        Field field1 = Pen.class.getDeclaredField("sizeLetter");
        field1.setAccessible(true);
        Double value1 = (Double) field1.get(pen);
        Assert.assertEquals(value1,sizeLetter);
    }

    @DataProvider
    public Object [][] constructorWithThreeParametrObject1()
    {
        return new Object[][]{
                {100,1.0,"RED"},
        };
    }

    @Test(dataProvider = "constructorWithThreeParametrObject1")
    public void testPen_constructorWithThreeParametr1(Integer inkContainer, Double sizeLetter, String color) throws NoSuchFieldException, IllegalAccessException {
        Pen pen = new Pen(inkContainer, sizeLetter, color);

        Field field = Pen.class.getDeclaredField("inkContainerValue");
        field.setAccessible(true);
        Integer value = (Integer) field.get(pen);
        Assert.assertNotNull(value);
    }

    @DataProvider
    public Object [][] constructorWithThreeParametrObject2()
    {
        return new Object[][]{
                {100,1.0,"RED"},
        };
    }

    @Test(dataProvider = "constructorWithThreeParametrObject2")
    public void testPen_constructorWithThreeParametr2(Integer inkContainer, Double sizeLetter, String color) throws NoSuchFieldException, IllegalAccessException {
        Pen pen = new Pen(inkContainer, sizeLetter, color);

        Field field1 = Pen.class.getDeclaredField("sizeLetter");
        field1.setAccessible(true);
        Double value1 = (Double) field1.get(pen);
        Assert.assertEquals(value1,sizeLetter);
    }

    @DataProvider
    public Object [][] constructorWithThreeParametrObject3()
    {
        return new Object[][]{
                {100,1.0,"RED"},
        };
    }

    @Test(dataProvider = "constructorWithThreeParametrObject3")
    public void testPen_constructorWithThreeParametr3(Integer inkContainer, Double sizeLetter, String color) throws NoSuchFieldException, IllegalAccessException {
        Pen pen = new Pen(inkContainer, sizeLetter, color);
        Field field2 = Pen.class.getDeclaredField("color");
        field2.setAccessible(true);
        String value2 = (String) field2.get(pen);
        Assert.assertEquals(value2,color);
    }

}