package com.test.classes;

import org.testng.Assert;
import org.testng.annotations.*;

import java.io.*;
import java.lang.reflect.Field;

public class TestPen {

    private Pen pen;
    private Field field;
    private Field field1;
    private Field field2;
    private Integer value;
    private Double value1;
    private String value2;

    @BeforeSuite
    public void setUp()
    {
        try {
            field = Pen.class.getDeclaredField("inkContainerValue");
            field1 = Pen.class.getDeclaredField("sizeLetter");
            field2 = Pen.class.getDeclaredField("color");
            field.setAccessible(true);
            field1.setAccessible(true);
            field2.setAccessible(true);
        } catch (NoSuchFieldException e) {
           e.printStackTrace();
        }
        System.out.println("System is ready for testing");
    }

    @AfterSuite
    public void tearDown()
    {
        System.out.println("System was tested");
        field.setAccessible(false);
        field1.setAccessible(false);
        field2.setAccessible(false);
        File f1 = new File("output.txt");
        File f2 = new File("output1.txt");
        f1.delete();
        f2.delete();
    }

    @DataProvider
    public Object [][] shouldWorkingIfContainerIsNotEmpty()
    {
        return new Object[][]{
                {1000},
        };
    }

    @Test(dataProvider = "shouldWorkingIfContainerIsNotEmpty")
    public void testPenIsWork_IsPenWork(Integer inkContainer)
    {
        pen = new Pen(inkContainer);
        Assert.assertTrue(pen.isWork());
    }

    @DataProvider
    public Object [][] shouldNotWorkingIfContainerIsEmpty()
    {
        return new Object[][]{
                {0},
                {-100},
        };
    }

    @Test(dataProvider = "shouldNotWorkingIfContainerIsEmpty")
    public void testPenIsWork_IsPenWorkIfContEmpty(Integer inkContainer)
    {
        pen = new Pen(inkContainer);
        Assert.assertFalse(pen.isWork());
    }

    @DataProvider
    public Object [][] shouldDoSomeElseObject()
    {
        return new Object[][]{
                {100,2.0,"BLUE"},
        };
    }

    @Test(dataProvider = "shouldDoSomeElseObject")
    public void testPenDoSomethingElse_ShouldDoSomethingElse(Integer inkCont,Double sizeLet, String color)
    {
        Pen pen = new Pen(inkCont,sizeLet,color);
        FileOutputStream out = null;
        String line="";
        try {
            out = new FileOutputStream("output.txt");
            PrintStream ps = new PrintStream(out);
            System.setOut(ps);
            pen.doSomethingElse();
            ps.close();
            FileInputStream fstream = new FileInputStream("output.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            line = br.readLine();
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(line, color);
    }

    @DataProvider
    public Object [][] shouldDoSomeElseObject1()
    {
        return new Object[][]{
                {100, ""},
        };
    }

    @Test(dataProvider = "shouldDoSomeElseObject1")
    public void testPenDoSomethingElse_ShouldDoSomethingElse1(Integer inkCont,String expected)
    {
        Pen pen = new Pen(inkCont);
        FileOutputStream out = null;
        String line="";
        try {
            out = new FileOutputStream("output1.txt");
            PrintStream ps = new PrintStream(out);
            System.setOut(ps);
            pen.doSomethingElse();
            ps.close();
            FileInputStream fstream = new FileInputStream("output1.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            line = br.readLine();
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(line, expected);
    }

    @DataProvider
    public Object [][] shouldWritePrintColorObject()
    {
        return new Object[][]{
                {0,4.0,"ORANGE"},
                {100,2.4,""},
        };
    }

    @Test(dataProvider = "shouldWritePrintColorObject")
    public void testPenGetColor_ShouldPrintRightColor(Integer inkCont, Double sizeLetter, String color)
    {
        pen = new Pen(inkCont,sizeLetter,color);
        Assert.assertEquals(pen.getColor(), color);
    }

    @DataProvider
    public Object [][] shouldWriteAnythingObject()
    {
        return new Object[][]{
                {0,4,"qw",""},
                {1.5,4,"qw","qw"},
                {1.5,4,"qwqwqw","qwqw"},
                {0,4,"qwqwqw",""},
                {0,2,"qw",""},
                {1,4,"qwqw","qwqw"},
                {-1,-1,"qw",""},
                {-1,10,"qw",""},
        };
    }

    @Test(dataProvider = "shouldWriteAnythingObject")
    public void testPenWrite_ShouldWriteAnything(double sizeLetter, int inkContainer, String actual, String expected)
    {
        pen = new Pen(inkContainer, sizeLetter);
        Assert.assertEquals(pen.write(actual), expected);
    }

    @DataProvider
    public Object [][] constructorWithOneParameterObject()
    {
        return new Object[][]{
                {100},
        };
    }

    @Test(dataProvider = "constructorWithOneParameterObject")
    public void testPen_constructorWithOneParameter(Integer inkContainer) {
        Pen pen = new Pen(inkContainer);
        try {
            value = (Integer) field.get(pen);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            Assert.fail();
        }
        Assert.assertEquals(value, inkContainer);
    }

    @DataProvider
    public Object [][] constructorWithTwoParameterObject1()
    {
        return new Object[][]{
                {100, 1.0},
        };
    }

    @Test(dataProvider = "constructorWithTwoParameterObject1")
    public void testPen_constructorWithTwoParameter1(Integer inkContainer, Double sizeLetter) {
        Pen pen = new Pen(inkContainer, sizeLetter);
        try {
            value = (Integer) field.get(pen);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            Assert.fail();
        }
        Assert.assertEquals(value, inkContainer);
    }

    @DataProvider
    public Object [][] constructorWithTwoParameterObject2()
    {
        return new Object[][]{
                {100, 1.0},
        };
    }

    @Test(dataProvider = "constructorWithTwoParameterObject2")
    public void testPen_constructorWithTwoParameter2(Integer inkContainer, Double sizeLetter) {

        Pen pen = new Pen(inkContainer, sizeLetter);
        try {
            value1 = (Double) field1.get(pen);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            Assert.fail();
        }
        Assert.assertEquals(value1,sizeLetter);
    }

    @DataProvider
    public Object [][] constructorWithThreeParameterObject1()
    {
        return new Object[][]{
                {100,1.0,"RED"},
        };
    }

    @Test(dataProvider = "constructorWithThreeParameterObject1")
    public void testPen_constructorWithThreeParameter1(Integer inkContainer, Double sizeLetter, String color) {

        Pen pen = new Pen(inkContainer, sizeLetter, color);
        try {
            value = (Integer) field.get(pen);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            Assert.fail();
        }
        Assert.assertNotNull(value);
    }

    @DataProvider
    public Object [][] constructorWithThreeParameterObject2()
    {
        return new Object[][]{
                {100,1.0,"RED"},
        };
    }

    @Test(dataProvider = "constructorWithThreeParameterObject2")
    public void testPen_constructorWithThreeParameter2(Integer inkContainer, Double sizeLetter, String color) {

        Pen pen = new Pen(inkContainer, sizeLetter, color);
        try {
            value1 = (Double) field1.get(pen);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            Assert.fail();
        }
        Assert.assertEquals(value1,sizeLetter);
    }

    @DataProvider
    public Object [][] constructorWithThreeParameterObject3()
    {
        return new Object[][]{
                {100,1.0,"RED"},
        };
    }

    @Test(dataProvider = "constructorWithThreeParameterObject3")
    public void testPen_constructorWithThreeParameter3(Integer inkContainer, Double sizeLetter, String color) {

        Pen pen = new Pen(inkContainer, sizeLetter, color);
        try {
            value2 = (String) field2.get(pen);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            Assert.fail();
        }
        Assert.assertEquals(value2,color);
    }
}