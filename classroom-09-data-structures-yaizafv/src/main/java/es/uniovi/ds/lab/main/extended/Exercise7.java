package es.uniovi.ds.lab.main.extended;

import static es.uniovi.ds.lab.main.TestsHelper.*;
import static es.uniovi.ds.lab.operations.Disk.*;
import static es.uniovi.ds.lab.operations.Printer.*;
import static es.uniovi.ds.lab.search.Find.*;

import es.uniovi.ds.lab.sets.Concat;
import es.uniovi.ds.lab.structures.MyVector;
import es.uniovi.ds.lab.transformers.Map;

public class Exercise7 {

    public static void main(String[] args) throws Exception {

        // Starting players for both teams (titulares)
        MyVector homeStarters = vectorOf("Bartolomew", "Milhouse", "Harry");
        MyVector awayStarters = vectorOf("Johansson", "Peter", "Bill");

        // 1. Save the starting players from both teams together in a single file named "Both teams starters.txt".
        save("Both teams starters.txt",
                new Concat(homeStarters.iterator(), awayStarters.iterator()));

        // 2. Create a file "All home team players.txt" containing the home team starters and substitutes.
        save("All home team players.txt",
                new Concat(homeStarters.iterator(), fileIterator("Home team substitutes.txt")));

        // 3. Find the first away team player whose name starts with 'A'. Search starters first, then substitutes if not found.
        String startsWithA = findFirst(
                new Concat(awayStarters.iterator(), fileIterator("Away team substitutes.txt")),
                name -> name.startsWith("A"));
        System.out.println("\n\nFirst away team player whose name starts with 'A': " + startsWithA + "\n");

        // 4. Send to the printer the names of starting players from both teams in UPPERCASE.
        var allPlayers = new Concat(awayStarters.iterator(), homeStarters.iterator());
        var playersInUpperCase = new Map(allPlayers, String::toUpperCase);
        sendToPrinter(playersInUpperCase);

        // ... or alternatively...
        sendToPrinter(
                new Map(
                        new Concat(awayStarters.iterator(), homeStarters.iterator()),
                        String::toUpperCase));
    }

}

/*
Expected output:
------------------------------------------------
Creating file 'Both teams starters.txt'
Bartolomew
Milhouse
Harry
Johansson
Peter
Bill
[Closing file]
------------------------------------------------
Creating file 'All home team players.txt'
Bartolomew
Milhouse
Harry
Homer
Hank
Henry
[Closing file]


First away team player whose name starts with 'A': Arnold

------------------------------------------------
Loading sheet...
Printing line: JOHANSSON
Printing line: PETER
Printing line: BILL
Printing line: BARTOLOMEW
Printing line: MILHOUSE
Printing line: HARRY
Ejecting page
*/
