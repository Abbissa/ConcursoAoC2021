import java.util.ArrayList;

public class Nodo {

    ArrayList<Nodo> conexiones;
    String label;
    boolean grande;
    int cont;
    public Nodo(String label,boolean grande){
        conexiones = new ArrayList<Nodo>();
        this.grande=grande;
        this.label=label;    
        cont=0;
    }
    
}
