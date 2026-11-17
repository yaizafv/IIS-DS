package es.uniovi.ds.lab.main.extended;

import static es.uniovi.ds.lab.main.TestsHelper.*;
import static es.uniovi.ds.lab.operations.Disk.*;
import static es.uniovi.ds.lab.search.Find.*;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        var vector = vectorOf("Victor", "Valentin", "Vidal", "Viviana");
        var linkedList = linkedListOf("Lucas", "Leandro", "Lorenzo", "Luis");

        // ------------------------------------------------
        // Approach 1

        // 1. Find in the vector the first name with five letters (name.length() == 5)
        String itemName;
        var iterator = vector.iterator();
        while ((itemName = iterator.next()) != null) {
            if (itemName.length() == 5) {
                System.out.println(itemName);
                break;
            }
        }

        // 2. Find in the linked list the first name whose second letter is 'e' (name.charAt(1) == 'e')
        iterator = linkedList.iterator();
        while ((itemName = iterator.next()) != null) {
            if (itemName.length() >= 2 && itemName.charAt(1) == 'e') {
                System.out.println(itemName);
                break;
            }
        }

        // 3. Find in "file.txt" the first name that starts with "Fu" (name.startsWith("Fu"))
        iterator = fileIterator("file.txt");
        while ((itemName = iterator.next()) != null) {
            if (itemName.startsWith("Fu")) {
                System.out.println(itemName);
                break;
            }
        }

        // After completing the three previous tasks: Did you find yourself repeating code? What part of the code is repeated? How could you avoid this repetition?

        // ------------------------------------------------
        // Approach 2

        // 1. Find in the vector the first name with five letters (name.length() == 5)
        System.out.println(findFirst(vector.iterator(), name -> name.length() == 5));

        // 2. Find in the linked list the first name whose second letter is 'e' (name.charAt(1) == 'e')
        System.out.println(findFirst(linkedList.iterator(), name -> name.length() >= 2 && name.charAt(1) == 'e'));

        // 3. Find in "file.txt" the first name that starts with "Fu" (name.startsWith("Fu"))
        System.out.println(findFirst(fileIterator("file.txt"), name -> name.startsWith("Fu")));
    }
}
