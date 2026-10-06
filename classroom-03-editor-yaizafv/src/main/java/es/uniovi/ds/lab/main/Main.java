/**
 * IMPORTANT: The code provided for this exercise is the minimum necessary to understand
 * the exercise and should NEVER be taken as an example of proper use of exceptions, assertions,
 * and tests. All of the above elements, which should be done in a real program, have been intentionally
 * omitted to simplify the approach of the exercise.
 */

package es.uniovi.ds.lab.main;

import java.io.*;

import es.uniovi.ds.lab.editor.core.EditorWindow;

public class Main {

    public static void main(String[] args) throws IOException {

        EditorWindow editor = new EditorWindow();

        simulateMouse(editor);
    }

    public static void simulateMouse(EditorWindow editor) throws IOException {

        System.out.println("\nTool Activation: rectangle | circle | triangle | selection");
        System.out.println("Mouse Actions: press x,y | move x,y | release x,y");
        System.out.println("Other Commands: draw | exit \n");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print("> ");
            String[] line = in.readLine().split("[,\\s]+");

            if (line[0].equals("exit"))
                return;

            //$ Tool button presses -----------------------------

            if (line[0].startsWith("rec"))
                editor.toolButtonClicked("rectangle");

            else if (line[0].startsWith("cir"))
                editor.toolButtonClicked("circle");

            else if (line[0].startsWith("tri"))
                editor.toolButtonClicked("triangle");

            else if (line[0].startsWith("sel"))
                editor.toolButtonClicked("selection");

            //$ Mouse actions -----------------------------

            else if (line[0].startsWith("pre"))
                editor.mousePressed(Integer.parseInt(line[1]), Integer.parseInt(line[2]));

            else if (line[0].startsWith("mov"))
                editor.mouseMoved(Integer.parseInt(line[1]), Integer.parseInt(line[2]));

            else if (line[0].startsWith("rel"))
                editor.mouseReleased(Integer.parseInt(line[1]), Integer.parseInt(line[2]));

            //$ Other commands -----------------------------

            else if (line[0].startsWith("dra"))
                editor.draw();

            else
                System.out.println("Invalid command");

        } while (true);
    }

}
