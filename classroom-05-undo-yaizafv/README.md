# Software Design Laboratory Class

**⚠️ IMPORTANT NOTE:** This repository will be **deleted** at the end of the course. Make sure to save any code you want to keep elsewhere.

## 🔬 Self-Review Checklist

**Compare** this solution with your own, and verify that your implementation handles each of the following points correctly:
- Which parameters did you include in the constructors of `CreationChange` and `MovementChange`?
- Did you need to modify the `Drawing` class to implement your solution?
- Where do you create instances of `CreationChange` and `MovementChange`?

## 🎨 Design Patterns Used

This solution primarily uses the **Command** design pattern.

## 🧠 Points for Reflection

### Where changes are first applied

In the provided solution, tools apply changes and then record them in `History` using `addChange()`.

Current implementation:

```java
public void mouseReleased(int x, int y) {

    editor.getDrawing().addFigure(figure); // <-- The change is applied here
    ...
    editor.getHistory().addChange(new CreationChange(...));
}

public void addChange(Change change) {
    undoStack.addFirst(change);   // <-- The change is only recorded, not applied
    redoStack.clear();
}
```

Alternatively, tools could create the change and pass it to `History.addChange()`, leaving `History` responsible for applying it before recording it:

```java
public void mouseReleased(int x, int y) {

    // editor.getDrawing().addFigure(figure); // Remove this line
    ...
    editor.getHistory().addChange(new CreationChange(...));

}

public void addChange(Change change) {

    change.execute(); // <-- Add this line

    undoStack.addFirst(change);
    redoStack.clear();
}
```

What do you think about this alternative approach? What are the advantages and disadvantages of each approach?

### History Location

The `History` instance is stored in the `EditorWindow` class:

```java
public class EditorWindow {

    ...

    private History history;

    public EditorWindow() {
        ...

        history = new History();
    }
    ...
}
```

What do you think about storing the `History` instance in the `Drawing` class instead?

```java
public class Drawing {

    ...

    private History history;

    public Drawing() {
        ...

        history = new History();
    }
    ...
}
```

What are the advantages and disadvantages of each approach?
