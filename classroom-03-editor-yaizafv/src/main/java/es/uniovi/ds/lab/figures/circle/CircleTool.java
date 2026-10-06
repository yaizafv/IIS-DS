
package es.uniovi.ds.lab.figures.circle;

import java.awt.Point;

import es.uniovi.ds.lab.editor.core.*;
import es.uniovi.ds.lab.editor.tools.CreationTool;

public class CircleTool extends CreationTool {

    public CircleTool(EditorWindow editor) {
        super(editor);
    }

    protected Figure doCreateFigure(Point start, Point end) {
        Point center = new Point((start.x + end.x) / 2, (start.y + end.y) / 2);
        int radius = Math.max(end.x - start.x, end.y - start.y) / 2;
        return new Circle(center, radius);
    }
}
