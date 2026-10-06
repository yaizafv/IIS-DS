
package es.uniovi.ds.lab.figures.circle;

import java.awt.Point;

import es.uniovi.ds.lab.editor.core.Figure;

public class Circle implements Figure {

    private Point center;
    private int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public void draw() {
        System.out.println("  - Circle: center = " + center + ", radius = " + radius);
    }

    public boolean contains(int x, int y) {
        double distance = Math.sqrt(Math.pow(x - center.x, 2) + Math.pow(y - center.y, 2));
        return distance < radius;
    }

    public void move(int dx, int dy) {
        center.translate(dx, dy);
    }
}
