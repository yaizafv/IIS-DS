package es.uniovi.ds.lab.editor.core;

import java.util.*;

public class History {

    private Deque<Change> undoStack = new ArrayDeque<>();
    private Deque<Change> redoStack = new ArrayDeque<>();

    public void addChange(Change change) {
        undoStack.addFirst(change);
        redoStack.clear();
    }

    public void undo() {

        if (undoStack.isEmpty()) {
            System.out.println("Trace: undo is not possible");
            return;
        }

        Change change = undoStack.removeFirst();

        change.undo();
        redoStack.addFirst(change);
    }

    public void redo() {

        if (redoStack.isEmpty()) {
            System.out.println("Trace: redo is not possible");
            return;
        }

        Change change = redoStack.removeFirst();

        change.redo();
        undoStack.addFirst(change);
    }

}
