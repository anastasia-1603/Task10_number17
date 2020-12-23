import java.util.ArrayList;
import java.util.List;

public class Logic
{
    public static Triangle[] findTrianglesIn4Quarters(Triangle[] triangles)
    {
        List<Triangle> trianglesIn4Quarters = new ArrayList<>();
        for (Triangle triangle : triangles)
        {
            if (isOriginInsideTriangle(triangle))
            {
                trianglesIn4Quarters.add(triangle);
            }
        }
        return trianglesIn4Quarters.toArray(new Triangle[0]);
    }

    private static boolean isOriginInsideTriangle(Triangle triangle)
    {
        Point pointA = triangle.pointA;
        Point pointB = triangle.pointB;
        Point pointC = triangle.pointC;
        return (calcSecondaryTerm(pointA, pointB) > 0 && calcSecondaryTerm(pointB, pointC) > 0 && calcSecondaryTerm(pointC, pointA) > 0)
               || (calcSecondaryTerm(pointA, pointB) < 0 && calcSecondaryTerm(pointB, pointC) < 0 && calcSecondaryTerm(pointC, pointA) < 0);
    }

    private static double calcSecondaryTerm(Point p1, Point p2)
    {
        return p1.x * p2.y - p2.x * p1.y;
    }
}
