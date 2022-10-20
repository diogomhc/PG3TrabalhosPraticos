package trab1.grupo1.exercicio1;

public class Query {
    private final String text;
    private final String correctAnswer;
    private final int points;
    public Query( String txt ){
        this.text= txt;
        this.points= 5;
        this.correctAnswer= "yes";
    }

    // Alínea 2
    public String toString() {
        /* Este método foi escrito de modo a que possa aparecer
         * o texto pedido ao enviar uma instância desta classe
         * para o ecrã*/
        return text + " [" + points + "]? " + correctAnswer;
    }

    public boolean equals(Object o) {
        /* Este método foi escrito para compara duas instâncias da mesma classe; essa comparação falha
         * quando o objeto a comparar não esteja definido, ou não possua a mesma referência nem valores
         * idênticos nos seus membros */
        return o instanceof Query &&
                (this == o ||
                        (text.equals(((Query)o).text) &&
                                correctAnswer.equals(((Query)o).correctAnswer) &&
                                points == ((Query)o).points));
    }
    // Fim da alínea 2
}