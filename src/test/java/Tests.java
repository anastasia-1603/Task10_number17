import org.junit.Assert;
import org.junit.Test;
import java.io.FileNotFoundException;

public class Tests
{
    @Test
    public void test1() throws FileNotFoundException
    {
        Triangle[] triangles = Utils.readArrayTrianglesFromFile("tests\\input1.txt");
        Triangle[] trianglesIn4Quarters = Logic.findTrianglesIn4Quarters(triangles);
        String[] coordinates = Utils.toStringArrayCoordinates(trianglesIn4Quarters);
        String[] expectedCoordinates = {"-5, -3, 0, 5, 6, -3"};
        Assert.assertArrayEquals(expectedCoordinates, coordinates);
    }

    @Test
    public void test2() throws FileNotFoundException
    {
        Triangle[] triangles = Utils.readArrayTrianglesFromFile("tests\\input2.txt");
        Triangle[] trianglesIn4Quarters = Logic.findTrianglesIn4Quarters(triangles);
        String[] coordinates = Utils.toStringArrayCoordinates(trianglesIn4Quarters);
        String[] expectedCoordinates = {};
        Assert.assertArrayEquals(expectedCoordinates, coordinates);
    }

    @Test
    public void test3() throws FileNotFoundException
    {
        Triangle[] triangles = Utils.readArrayTrianglesFromFile("tests\\input3.txt");
        Triangle[] trianglesIn4Quarters = Logic.findTrianglesIn4Quarters(triangles);
        String[] coordinates = Utils.toStringArrayCoordinates(trianglesIn4Quarters);
        String[] expectedCoordinates = {"-5, -3, 0, 5, 6, -3", "-3, -9, -3, 7, 7, -9"};
        Assert.assertArrayEquals(expectedCoordinates, coordinates);
    }

    @Test
    public void test4() throws FileNotFoundException
    {
        Triangle[] triangles = Utils.readArrayTrianglesFromFile("tests\\input4.txt");
        Triangle[] trianglesIn4Quarters = Logic.findTrianglesIn4Quarters(triangles);
        String[] coordinates = Utils.toStringArrayCoordinates(trianglesIn4Quarters);
        String[] expectedCoordinates = {"-3, -9, -3, 7, 7, -9", "-2, -8, -7, -1, 2, 1"};
        Assert.assertArrayEquals(expectedCoordinates, coordinates);
    }

    @Test
    public void test5() throws FileNotFoundException
    {
        Triangle[] triangles = Utils.readArrayTrianglesFromFile("tests\\input5.txt");
        Triangle[] trianglesIn4Quarters = Logic.findTrianglesIn4Quarters(triangles);
        String[] coordinates = Utils.toStringArrayCoordinates(trianglesIn4Quarters);
        String[] expectedCoordinates = {"-5, -3, 0, 5, 6, -3", "-2, -5, -6, -6, 3, 6",
                "-2, -8, -7, -1, 2, 1", "-3, -9, -3, 7, 7, -9"};
        Assert.assertArrayEquals(expectedCoordinates, coordinates);
    }
}
