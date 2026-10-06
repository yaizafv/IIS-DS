# Software Design Laboratory Class

**⚠️ IMPORTANT NOTE:** This repository will be **deleted** at the end of the course. Make sure to save any code you want to keep elsewhere.


## 🔬 Self-Review Checklist

**Compare** how this solution and your own handle the following points. Make sure you handled each one correctly:
- Does your `Figure` have any methods other than the three explained?
- Does your `Tool` have any methods other than the three explained?
- What parameters have you put in `Figure.move(...)`?
- Have you used `toString()`? It should only be used for printing a trace.


## 🎨 Design Patterns Used

This solution primarily utilises the **State** design pattern (`Tool`).

Additionally, the **Template Method** (`CreationTool.mouseReleased`) and **Factory Method** (`CreationTool.doCreateFigure`) design patterns are used.

## 🧠 Points for Reflection

### When a tool is finished

When a tool finishes its work, the usual behavior (although in some editors this can be configured) is to return to the selection tool.

Notice how this is done in `TriangleTool` and `CreationTool` through the call to `EditorWindow.toolFinised()`.

```java
public abstract class CreationTool implements Tool {
    ...
    public void mouseReleased(int x, int y) {
        ...

        editor.toolFinised();   // <-------------
    }
```

Questions:
- Have you reactivated the selection tool in any other way?
- Could we, for example, remove the `toolFinised` method and simply activate the selection tool using the already existing `toolButtonClicked` method?

    ```java
    public abstract class CreationTool implements Tool {
        ...
        public void mouseReleased(int x, int y) {
            ...

            editor.toolButtonClicked("selection");   // <-------------
        }
    ```

### About the distribution of classes in packages

How have you organized the classes in packages? Have you put each tool with its figure or have you created separate packages for figures and tools? Why did you do it that way?

### Circle

The `Circle` class has been implemented as follows:

```java
public class CircleTool extends CreationTool {
    ...
    protected Figure doCreateFigure(Point start, Point end) {
        Point center = new Point((start.x + end.x) / 2, (start.y + end.y) / 2);
        int radius = Math.max(end.x - start.x, end.y - start.y) / 2;
        return new Circle(center, radius);
    }
}

public class Circle implements Figure {
    ...
    public Circle(Point center, int radius) {   <--------------- center and radius as parameters
        this.center = center;
        this.radius = radius;
    }
}
```

What do you think of this alternative? Notice that the parameters of the `Circle` constructor have been changed.

```java
public class CircleTool extends CreationTool {
    ...
    protected Figure doCreateFigure(Point start, Point end) {
        return new Circle(start, end);
    }
}

public class Circle implements Figure {
    ...
    public Circle(Point start, Point end) {    <------------------ two points as parameters
        this.center = new Point((start.x + end.x) / 2, (start.y + end.y) / 2);
        this.radius = Math.max(end.x - start.x, end.y - start.y) / 2;
    }
}
```
