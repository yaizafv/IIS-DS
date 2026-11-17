package es.uniovi.ds.lab.operations;

import es.uniovi.ds.lab.structures.MyIterator;

public class HtmlGenerator {
    public static void writeHTML(MyIterator iterator) {

        System.out.println("------------------------------------------------");
        System.out.println("<html>");
        System.out.println("  <body>");
        System.out.println("    <ul>");

        String line;
        while ((line = iterator.next()) != null)
            System.out.println("      <li>" + line + "</li>");

        System.out.println("    </ul>");
        System.out.println("  </body>");
        System.out.println("</html>");
    }
}
