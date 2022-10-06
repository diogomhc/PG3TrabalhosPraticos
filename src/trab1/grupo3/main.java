package trab1.grupo3;

public class main {
    public static void main(String[] args) {
        State p = new Country("Portugal", 92391, true);
        State f = new Country("França", 154077, true);
        String onuName = "Organização Nações Unidas";
        String onuType = "Organização Internacional";
        Union onu = new Union( onuName, onuType );
        try {
            onu.append( p ).append( f ).append( p );
        }
        catch (StateException se) { }
        System.out.println( onu );


        State g = new Country("Geórgia", 154077, false);
        Federation usa = new Federation("Estados Unidos");
        try {
            usa.append( g ).append("Flórida",170451);
            System.out.println( usa );
            usa.append( p );
        }
        catch ( StateException e ) {
            System.out.println(e.getMessage() );
        }
        try {
            onu.append( usa );
        }
        catch (StateException se) { }
        System.out.println( onu );
        State res;
        if ( onu.find( (s) -> s.name.equals(onuName)) == onu &&
                (res= onu.find( (s) -> (s instanceof Country) && s.getArea()==170451)) !=null )
            System.out.println(res);
    }
}
