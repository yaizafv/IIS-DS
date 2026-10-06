
package es.uniovi.ds.lab.figures.rectangle;

import java.awt.Point;

import es.uniovi.ds.lab.editor.core.Figure;

public class Rectangule implements Figure {

    private Point corner;
    private int width;
    private int height;

    public Rectangule(Point corner, int width, int height) {
        this.corner = new Point(corner);
        this.width = width;
        this.height = height;
    }

    public Rectangule(Point startPoint, Point endPoint) {
        this(startPoint, endPoint.x - startPoint.x, endPoint.y - startPoint.y);
    }

    public void draw() {
        System.out.println(
                "  - Rectangle: x = " + corner.x + ", y = " + corner.y + ", width = " + width + ", height = " + height);
    }

    public boolean contains(int x, int y) {
        return (corner.x <= x && x <= corner.x + width) && (corner.y <= y && y <= corner.y + height);
    }

    public void move(int dx, int dy) {
        corner.translate(dx, dy);
    }

}
