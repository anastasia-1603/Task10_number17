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
            int[] coordinates = toIntArray(line);
            Point[] points = createPoints(coordinates);
            triangleList.add(createTriangle(points));
        }
        return triangleList.toArray(new Triangle[0]);
    }

    public static void writeTrianglesToFile(Triangle[] triangles, String filename) throws FileNotFoundException
    {
        String[] coordinates = toStringArrayCoordinates(triangles);
        for (String line : coordinates)
        {
            writeLineToFile(line, filename);
        }
    }

    public static String[] toStringArrayCoordinates(Triangle[] triangles)
    {
        List<String> lines = new ArrayList<>();
        for (Triangle triangle : triangles)
        {
            String line = toString(createArrayCoordinates(triangle));
            lines.add(line);
        }
        return lines.toArray(new String[0]);
    }

    public static int[] createArrayCoordinates(Triangle triangle)
    {
        return new int[] {triangle.pointA.x, triangle.pointA.y, triangle.pointB.x, triangle.pointB.y,
                triangle.pointC.x, triangle.pointC.y};
    }

    private static String toString(int[] arr)
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
            writer.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static Point[] createPoints(int[] coordinates)
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

    private static int[] toIntArray(String str)
    {
        Scanner scanner = new Scanner(str);
        scanner.useLocale(Locale.ROOT);
        scanner.useDelimiter("(\\s|[,;])+");
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext())
        {
            list.add(scanner.nextInt());
        }
        Integer[] arr = list.toArray(new Integer[0]);
        return toPrimitive(arr);
    }

    private static int[] toPrimitive(Integer[] arr)
    {
        if (arr == null)
        {
            return null;
        }
        int[] result = new int[arr.length];
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
