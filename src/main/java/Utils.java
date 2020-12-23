import java.io.*;
import java.util.*;

public class Utils
{
    public static Triangle[] readArrayTrianglesFromFile(String filename) throws FileNotFoundException
    {
        String[] lines = readLinesFromFile(filename);
        List<Triangle> triangleList = new ArrayList<>();
        for (String line : lines)
        {
            double[] coordinates = toDoubleArray(line);
            Point[] points = createPoints(coordinates);
            triangleList.add(createTriangle(points));
        }
        return triangleList.toArray(new Triangle[0]);
    }

    public static void writeTrianglesToFile(Triangle[] triangles, String filename) throws FileNotFoundException
    {
        List<String> lines = new ArrayList<>();
        for (Triangle triangle : triangles)
        {
            double[] coordinates = {triangle.pointA.x, triangle.pointA.y, triangle.pointB.x, triangle.pointB.y,
            triangle.pointC.x, triangle.pointC.y};
            String line = toString(coordinates);
            lines.add(line);
            writeLineToFile(line, filename);
        }
    }

    private static String toString(double[] arr)
    {
        if (arr == null)
        {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++)
        {
            if (i != 0)
            {
                stringBuilder.append(", ");
            }
            stringBuilder.append(arr[i]);
        }
        return stringBuilder.toString();
    }

    private static void writeLineToFile(String line, String filename) throws FileNotFoundException
    {
        try (FileWriter writer = new FileWriter(filename, true))
        {
            writer.write(line);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static Point[] createPoints(double[] coordinates)
    {
        List<Point> pointList = new ArrayList<>();
        for (int i = 0; i < coordinates.length; i++)
        {
            if (i % 2 == 0)
            {
                pointList.add(new Point(coordinates[i], coordinates[i + 1]));
            }
        }
        return pointList.toArray(new Point[0]);
    }

    private static Triangle createTriangle(Point[] points)
    {
        return new Triangle(points[0], points[1], points[2]);
    }

    private static double[] toDoubleArray(String str)
    {
        Scanner scanner = new Scanner(str);
        scanner.useLocale(Locale.ROOT);
        scanner.useDelimiter("(\\s|[,;])+");
        List<Double> list = new ArrayList<>();
        while (scanner.hasNext())
        {
            list.add(scanner.nextDouble());
        }
        Double[] arr = list.toArray(new Double[0]);
        return toPrimitive(arr);
    }

    private static double[] toPrimitive(Double[] arr)
    {
        if (arr == null)
        {
            return null;
        }
        double[] result = new double[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            result[i] = arr[i];
        }
        return result;
    }

    private static String[] readLinesFromFile(String fileName) throws FileNotFoundException
    {
        List<String> lines;
        try (Scanner scanner = new Scanner(new File(fileName), "UTF-8"))
        {
            lines = new ArrayList<>();
            while (scanner.hasNext())
            {
                lines.add(scanner.nextLine());
            }
        }
        return lines.toArray(new String[0]);
    }
}
