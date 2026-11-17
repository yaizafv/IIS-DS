package es.uniovi.ds.lab.main.extended;

import static es.uniovi.ds.lab.main.TestsHelper.*;
import static es.uniovi.ds.lab.operations.HtmlGenerator.*;
import static es.uniovi.ds.lab.operations.Printer.*;

import es.uniovi.ds.lab.structures.MyVector;
import es.uniovi.ds.lab.transformers.*;

public class Exercise6 {

    public static void main(String[] args) {

        var vector = vectorOf("Victor", "Valentin", "Vidal", "Viviana");
        var linkedList = linkedListOf("Lucas", "Leandro", "Lorenzo", "Luis");

        //$ Section A -----------------------------------------------------------
        System.out.println("\n\n## Section A");

        /*
          1. Print the names in the vector in uppercase
        */

        // [Approach 1] Create an auxiliary vector to store the uppercase names before printing
        var upperCaseVector = new MyVector();
        for (int i = 0; i < vector.size(); i++)
            upperCaseVector.add(vector.get(i).toUpperCase());
        sendToPrinter(upperCaseVector.iterator());

        // Can you think of a better approach that avoids creating another vector?

        // [Approach 2] Avoids creating auxiliary data structures: data is transformed as it is read
        sendToPrinter(new UpperCase(vector.iterator()));

        /*
          2. Generate HTML with only the first four characters of each name in the list [name.substring(0, 4)]. For example, "Victor" should be printed as "Vict".
        */
        writeHTML(new FirstLetters(linkedList.iterator()));

        /*
          3. Print the names in the vector preceded by "Mr. " (for example, "Mr. Victor").
        */
        sendToPrinter(new MrPrefix(vector.iterator()));

        // [Approach 3] Avoids creating a class for each transformation; a parameterizable transformation works for any transformation
        // `Map` replaces the three previous classes: `UpperCase.java`, `FirstLetters.java` and `MrPrefix.java`
        sendToPrinter(new Map(vector.iterator(), name -> name.toUpperCase()));
        sendToPrinter(new Map(linkedList.iterator(), name -> name.substring(0, 4)));
        sendToPrinter(new Map(vector.iterator(), name -> "Mr. " + name));

        //$ Section B -----------------------------------------------------------
        System.out.println("\n\n## Section B");

        /*
          4. Print only the names in the vector that have exactly 5 characters [name.length() == 5]
        */
        sendToPrinter(new Filter(vector.iterator(), name -> name.length() == 5));

        /*
          5. Print only the names in the list that contain a 'u' in either of the first two letters [name.substring(0, 2).contains("u")]
        */
        sendToPrinter(new Filter(linkedList.iterator(), name -> name.substring(0, 2).contains("u")));

        //$ Section C -----------------------------------------------------------
        System.out.println("\n\n## Section C");

        /*
          6. Print only the names in the list that have seven letters [name.length() == 7]. These should be printed preceded by "Mr. "
        */
        sendToPrinter(
                new Map(
                        new Filter(linkedList.iterator(), name -> name.length() == 7),
                        name -> "Mr. " + name));
    }
}

/*
Expected Output:

## Section A
------------------------------------------------
Loading sheet...
Printing line: VICTOR
Printing line: VALENTIN
Printing line: VIDAL
Printing line: VIVIANA
Ejecting page
------------------------------------------------
Loading sheet...
Printing line: VICTOR
Printing line: VALENTIN
Printing line: VIDAL
Printing line: VIVIANA
Ejecting page
------------------------------------------------
<html>
  <body>
    <ul>
      <li>Luca</li>
      <li>Lean</li>
      <li>Lore</li>
      <li>Luis</li>
    </ul>
  </body>
</html>
------------------------------------------------
Loading sheet...
Printing line: Mr. Victor
Printing line: Mr. Valentin
Printing line: Mr. Vidal
Printing line: Mr. Viviana
Ejecting page
------------------------------------------------
Loading sheet...
Printing line: VICTOR
Printing line: VALENTIN
Printing line: VIDAL
Printing line: VIVIANA
Ejecting page
------------------------------------------------
Loading sheet...
Printing line: Luca
Printing line: Lean
Printing line: Lore
Printing line: Luis
Ejecting page
------------------------------------------------
Loading sheet...
Printing line: Mr. Victor
Printing line: Mr. Valentin
Printing line: Mr. Vidal
Printing line: Mr. Viviana
Ejecting page


## Section B
------------------------------------------------
Loading sheet...
Printing line: Vidal
Ejecting page
------------------------------------------------
Loading sheet...
Printing line: Lucas
Printing line: Luis
Ejecting page


## Section C
------------------------------------------------
Loading sheet...
Printing line: Mr. Leandro
Printing line: Mr. Lorenzo
Ejecting page
*/
