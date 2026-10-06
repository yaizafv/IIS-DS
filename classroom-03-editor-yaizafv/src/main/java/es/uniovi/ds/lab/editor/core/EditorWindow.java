package es.uniovi.ds.lab.editor.core;

import java.util.*;

import es.uniovi.ds.lab.editor.tools.SelectionTool;
import es.uniovi.ds.lab.figures.circle.CircleTool;
import es.uniovi.ds.lab.figures.rectangle.RectangleTool;
import es.uniovi.ds.lab.figures.triangle.TriangleTool;

public class EditorWindow {

    private Drawing drawing;

    private Map<String, Tool> tools;
    private Tool currentTool;
    private Tool selectionTool;

    public EditorWindow() {
        this.drawing = new Drawing();

        this.tools = doCreateTools();

        selectionTool = tools.get("selection");
        currentTool = selectionTool; // The selection tool is the default tool when the editor starts
    }

    protected Map<String, Tool> doCreateTools() {
        var editorTools = new HashMap<String, Tool>();

        editorTools.put("rectangle", new RectangleTool(this));
        editorTools.put("circle", new CircleTool(this));
        editorTools.put("triangle", new TriangleTool(this));
        editorTools.put("selection", new SelectionTool(this));

        return editorTools;
    }

    //# User interface methods -----------------------------

    // Click the button of a tool to activate it
    public void toolButtonClicked(String toolName) {
        this.currentTool = tools.get(toolName);
    }

    public void mousePressed(int x, int y) {
        currentTool.mousePressed(x, y);
    }

    public void mouseMoved(int x, int y) {
        currentTool.mouseMoved(x, y);
    }

    public void mouseReleased(int x, int y) {
        currentTool.mouseReleased(x, y);
    }

    //# Tool methods ---------------------

    public void toolFinished() {
        this.currentTool = selectionTool;
    }

    //# Drawing methods -----------------------------

    public Drawing getDrawing() {
        return drawing;
    }

    public void draw() {

        // Here the top menu would be drawn
        // Here the side toolbar would be drawn
        // Here the status bar would be drawn

        drawing.draw();

        System.out.println("  [" + currentTool.getClass().getSimpleName() + " activated]");
        System.out.println();
    }
}
