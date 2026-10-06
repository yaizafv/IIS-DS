package es.uniovi.ds.lab.editor.core;

import java.util.*;

public class Drawing {

    private List<Figure> figures = new ArrayList<>();

    public void addFigure(Figure figura) {
        figures.add(figura);
    }

    public void removeFigure(Figure figura) {
        figures.remove(figura);
    }

    public void draw() {
        for (Figure figure : figures)
            figure.draw();
    }

    public Figure getFigure(int x, int y) {
        for (Figure figure : figures)
            if (figure.contains(x, y))
                return figure;
        return null;
    }

}
