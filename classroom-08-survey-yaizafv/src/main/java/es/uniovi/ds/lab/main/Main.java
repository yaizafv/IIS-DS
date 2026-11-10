/**
 * # IMPORTANT: The code provided for this exercise is the minimum necessary to understand
 * the assignment and should NEVER be taken as an example of proper use of exceptions,
 * assertions, and tests. All of the above, which should be done in a real program, has been
 * intentionally omitted to simplify the exercise.
 */

package es.uniovi.ds.lab.main;

import java.io.IOException;

import es.uniovi.ds.lab.observers.*;
import es.uniovi.ds.lab.observers.wrappers.*;
import es.uniovi.ds.lab.survey.Survey;

public class Main {

    public static void main(String[] args) throws IOException {

        Survey survey = new Survey("Are you in favor of nuclear energy?");

        /*
        * New Design
        */
        survey.addObserver(new BarChart());
        survey.addObserver(new PieChart());
        survey.addObserver(new Backup());

        /*
         * Program 1. When a vote is received, a status line must also be drawn.
         * "number of YES votes = <x>. number of NO votes = <y>"
         */
        survey.addObserver(new StatusLine());

        /*
         * Program 2. Do not draw the bar chart.
         */
        // You would only need to comment out this line in the previous code
        // survey.addObserver(new BarChart());

        /*
         * Program 3. Instead of drawing it with each vote, the pie chart is only
         * drawn starting from the third vote (and from then on with each vote).
         */
        survey.addObserver(new Delayer(3, new PieChart()));

        /*
         * Program 4. The bar chart returns, but now it will only be
         * drawn every 3 votes (with the first, fourth, seventh, etc...).
         */
        survey.addObserver(new Sampler(3, new BarChart()));

        /*
         * Program 5. The status line should start printing from
         * the fourth vote and from then on it will be printed every two
         * (it will be printed on the fourth, sixth, eighth, etc...).
         */
        survey.addObserver(new Delayer(4, new Sampler(2, new StatusLine())));

        TextUserInterface userInterface = new TextUserInterface();
        userInterface.collectSurveyResponses(survey);
    }

}
