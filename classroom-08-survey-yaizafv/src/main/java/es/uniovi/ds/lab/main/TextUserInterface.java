package es.uniovi.ds.lab.main;

import java.io.*;

import es.uniovi.ds.lab.survey.Survey;

public class TextUserInterface {

    public void collectSurveyResponses(Survey survey) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        do {

            System.out.printf("%n%s (yes/no/exit)> ", survey.getQuestion());

            var answer = input.readLine();

            if (answer.startsWith("e")) // exit
                return;

            if (answer.startsWith("y")) // yes
                survey.addYesVote();

            if (answer.startsWith("n")) // no
                survey.addNoVote();

        } while (true);

    }

}
