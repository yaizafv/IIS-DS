
package es.uniovi.ds.lab.figures.triangle;

import java.awt.*;

import es.uniovi.ds.lab.editor.core.Figure;

public class Triangle implements Figure {

    private Point v1, v2, v3;

    public Triangle(Point v1, Point v2, Point v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public void draw() {
        System.out.println("  - Triangulo: v1 = " + v1 + ", v2 = " + v2 + ", v3 = " + v3);
    }

    public boolean contains(int x, int y) {

        Point position = new Point(x, y);
        return position.equals(v1) || position.equals(v2) || position.equals(v3);
    }

    public void move(int dx, int dy) {
        v1.translate(dx, dy);
        v2.translate(dx, dy);
        v3.translate(dx, dy);
    }

}
