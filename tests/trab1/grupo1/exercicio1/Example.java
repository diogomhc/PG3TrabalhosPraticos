package trab1.grupo1.exercicio1;

public class Example {
    public static void main(String[] args) {
        String txt="A dimensão do int é 32 bits";
        Query q1 = new Query(txt);
        System.out.println(q1);
        /*Alínea 1:
         *O resultado apresentado é o seguinte:
         *
         *  TrabalhoPratico1.Grupo1.Exercicio1.Query@7b23ec81
         *  false
         *  false
         *  false
         */

        //Alínea 2 presente no ficheiro Query.java
        Query q2= new Query(txt);
        System.out.println( q1 == q2 );
        System.out.println( q1.equals( q2 ) );
        Object o = q2;
        System.out.println( q1.equals(o) );

        // Alínea 3
        Query q3 = q1;
        System.out.println( q1.equals(q3) );// ③
        if ( q3 != null )
        System.out.println(q1==q3);

    }
}