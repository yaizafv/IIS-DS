
package es.uniovi.ds.lab.figures.rectangle;

import java.awt.Point;

import es.uniovi.ds.lab.editor.core.*;
import es.uniovi.ds.lab.editor.tools.CreationTool;

public class RectangleTool extends CreationTool {

    public RectangleTool(EditorWindow editor) {
        super(editor);
    }

    protected Figure doCreateFigure(Point start, Point end) {
        return new Rectangule(start, end);
    }
}
