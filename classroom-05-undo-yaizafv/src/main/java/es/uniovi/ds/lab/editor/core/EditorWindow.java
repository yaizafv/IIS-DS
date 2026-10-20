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
    private History history;

    public EditorWindow() {
        drawing = new Drawing();

        tools = new HashMap<>();
        doCreateTools(tools);
        currentTool = selectionTool = tools.get("selection");
        history = new History();
    }

    protected void doCreateTools(Map<String, Tool> tools) {
        tools.put("rectangle", new RectangleTool(this));
        tools.put("circle", new CircleTool(this));
        tools.put("triangle", new TriangleTool(this));
        tools.put("selection", new SelectionTool(this));
    }

    //# User Interface methods -----------------------------

    public void toolButtonClicked(String name) {
        setCurrentTool(tools.get(name));
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

    private void setCurrentTool(Tool tool) {
        this.currentTool = tool;
    }

    public void endTool() {
        currentTool = selectionTool;
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

    //# undo/redo methods -----------------------------

    public History getHistory() {
        return history;
    }

    public void undo() {
        history.undo();
    }

    public void redo() {
        history.redo();
    }
}
