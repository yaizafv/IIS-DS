package es.uniovi.ds.lab.form;

import java.io.*;

/* Basic form to use when you only want to request two values about something */
public class MiniForm {

    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

    public void requestInput(Editable editable) {

        System.out.println("\nEditing " + editable.getElementType() + "------------------------");

        System.out.println("Current values:");
        printEditable(editable);

        System.out.println("Enter new values (leave blank to keep current value):");

        System.out.print("- " + editable.getFirstLabel() + ": ");
        String text = getLine();
        if (!text.isEmpty())
            editable.setFirstValue(text);

        System.out.print("- " + editable.getSecondLabel() + ": ");
        text = getLine();
        if (!text.isEmpty())
            editable.setSecondValue(text);

        System.out.println("Final values:");
        printEditable(editable);
    }

    private void printEditable(Editable editable) {
        System.out.println("- " + editable.getFirstLabel() + " = " + editable.getFirstValue());
        System.out.println("- " + editable.getSecondLabel() + " = " + editable.getSecondValue());
    }

    private String getLine() {
        do {
            try {
                return console.readLine();
            } catch (IOException ex) {
                System.out.println("Read error. Please try again.");
            }
        } while (true);
    }

}
