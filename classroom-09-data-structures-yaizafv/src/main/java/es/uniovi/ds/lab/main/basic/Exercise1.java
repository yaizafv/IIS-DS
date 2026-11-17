package es.uniovi.ds.lab.main.basic;

import static es.uniovi.ds.lab.main.TestsHelper.*;
import static es.uniovi.ds.lab.operations.Disk.*;
import static es.uniovi.ds.lab.operations.HtmlGenerator.*;
import static es.uniovi.ds.lab.operations.Printer.*;

import es.uniovi.ds.lab.structures.MyVector;

public class Exercise1 {

    public static void main(String[] args) throws Exception {

        var vector = vectorOf("Victor", "Valentin", "Vidal", "Viviana");
        save("vector.txt", vector.iterator());

        var linkedList = linkedListOf("Lucas", "Leandro", "Lorenzo", "Luis");
        writeHTML(linkedList.iterator());

        var doubleList = doubleLinkedListOf("Daniel", "Diego", "Damián", "Domingo");
        sendToPrinter(doubleList.iterator());

        /*
          Now I want to write the vector in HTML
        */
        writeHTML(vector.iterator());

        /*
          Now I want to print the linked list on the printer
        */
        sendToPrinter(linkedList.iterator());

        /*
          Now I want to save the double-linked list to the file "doble.txt"
        */
        save("doble.txt", doubleList.iterator());

        /*
          Now I want to print the contents of the file "file.txt" on the printer
        */
        MyVector fileVector = loadFile("file.txt");
        sendToPrinter(fileVector.iterator());
    }
}

/*
Expected output (the order doesn't matter):

------------------------------------------------
Creating file 'vector.txt'
Victor
Valentin
Vidal
Viviana
[Closing file]
------------------------------------------------
<html>
  <body>
    <ul>
      <li>Lucas</li>
      <li>Leandro</li>
      <li>Lorenzo</li>
      <li>Luis</li>
    </ul>
  </body>
</html>
------------------------------------------------
Loading sheet...
Printing line: Daniel
Printing line: Diego
Printing line: Damián
Printing line: Domingo
Ejecting page
------------------------------------------------
<html>
  <body>
    <ul>
      <li>Victor</li>
      <li>Valentin</li>
      <li>Vidal</li>
      <li>Viviana</li>
    </ul>
  </body>
</html>
------------------------------------------------
Loading sheet...
Printing line: Lucas
Printing line: Leandro
Printing line: Lorenzo
Printing line: Luis
Ejecting page
------------------------------------------------
Creating file 'doble.txt'
Daniel
Diego
Damián
Domingo
[Closing file]
------------------------------------------------
Loading sheet...
Printing line: Federico
Printing line: Fulgencio
Printing line: Fernando
Printing line: Fulvia
Ejecting page
*/
