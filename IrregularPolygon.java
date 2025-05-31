import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import java.util.concurrent.TimeUnit;

import gpdraw.*; // for DrawingTool


public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // constructor
    public IrregularPolygon() {}
    
    //public methods
    public void add(Point2D.Double aPoint)
    {
        myPolygon.add(aPoint);
    }

    public double perimeter() {
        double perim = 0;
        for(int i = 0; i < myPolygon.size()-1; i++) {
            perim += myPolygon.get(i).distance(myPolygon.get(i+1));
        }
        permin += myPolygon.get(myPolygon.size()-1).distance(myPolygon.get(0));//last line
        return perim;
    }

    public double area() {
        double area = 0;
        //adding portion
        for(int i = 0; i < myPolygon.size()-1; i++) {
            area += myPolygon.get(i).getX() * myPolygon.get(i+1).getY();
        }
        area += myPolygon.get(myPolygon.size()-1).getX() * myPoygon.get(0).getY();
        //subtracting portion
        for(int i = 0; i < myPolygon.size()-1; i++) {
            area -= myPolygon.get(i).getY() * myPolygon.get(i+1).getX();
        }
        area -= myPolygon.get(myPolygon.size()-1).getY() * myPoygon.get(0).getX();
        return area;
    }

    public void draw()
    {
        // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
        try {
            // Documents: https://pavao.org/compsci/gpdraw/html/gpdraw/DrawingTool.html
            DrawingTool pen = new DrawingTool(new SketchPad(500, 500));
            for(Point2D.Double p : myPolygon) {
                pen.move(p.getX(), p.getY());
            }
        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }
}
