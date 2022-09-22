package trab1.grupo1.exercicio2;

import java.util.ArrayList;
import java.util.Scanner;

public class Query {
    private final String text;
    private final String correctAnswer;
    private final int points;

    public Query( String txt ){
        this.text = txt;
        this.points = 5;
        this.correctAnswer= "yes";
    }

// Princípio do Exercício 2

    // Alínea 2
    public Query(String txt, boolean ans) {
        text = txt;
        points = 5;
        correctAnswer = ans ? "yes" : "no";
    }

    // Alínea 1
    public Query(String txt, String ans, int pts) {
        text = txt;
        correctAnswer = ans;
        points = pts;
    }

    // Início da alínea 3
    public String getText() {
        return text;
    }

    public int getPoints() {
        return points;
    }
    // Fim da alínea 3

    // Alínea 4
    public int checkAnswer(String answer) {
        return correctAnswer.equals(answer) ? points : 0;
    }

    // Alínea 5
    public int compareTo(Query q) {
        return points - q.points;
    }

    // Alínea 6
    public static Query parse(String queryToParse) {
        boolean hasPoints = queryToParse.contains("[");
        String text = hasPoints ? queryToParse.substring(0, queryToParse.indexOf('[')).trim() : queryToParse.substring(0, queryToParse.indexOf('?')),
                correctAnswer = queryToParse.substring(hasPoints ? queryToParse.indexOf("]?") + 2 : queryToParse.indexOf('?') + 1).trim();
        int points = hasPoints ? Integer.parseInt(queryToParse.substring(queryToParse.indexOf('[') + 1, queryToParse.indexOf(']'))) : 5;

        return new Query(text, correctAnswer, points);
    }

    // Alínea 7
    public static int quiz(Query... queries) {
        int sum = 0, queryPoints = 0;
        Scanner in = new Scanner(System.in);
        for (Query q: queries) {
            System.out.println(q.getText() + '?');
            if ((queryPoints = q.checkAnswer(in.nextLine())) > 0) {
                System.out.println("Correct answer! " + q.getPoints() + " points awarded!\n");
                sum += queryPoints;
            }
            else System.out.println("Wrong answer. No points awarded.\n");
        }
        return sum;
    }

    public static Query[] growingQueries(Query[] queries) {
        ArrayList<Query> temp = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            if (i == 0) {
                temp.add(queries[0]);
                continue;
            }
            if (queries[i].compareTo(temp.get(temp.size() - 1)) >= 0) temp.add(queries[i]);
        }

        return temp.toArray(new Query[temp.size()]);
    }

// Fim do Exercício 2

    public String toString() {
        return text + " [" + points + "]? " + correctAnswer;
    }

    public boolean equals(Object o) {
        return o instanceof Query &&
               (this == o ||
               (text.equals(((Query)o).text) &&
               correctAnswer.equals(((Query)o).correctAnswer) &&
               points == ((Query)o).points));
    }
}