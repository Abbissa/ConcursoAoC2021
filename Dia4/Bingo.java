import java.util.HashSet;

public class Bingo {
    
    HashSet<Integer>[] cols;
    HashSet<Integer>[] rows;
    HashSet<Integer> nums;

    public Bingo(){
        cols=new Mapa [5];
        rows = new Mapa [5];
        nums = new HashSet<Integer>();
        for(int i=0;i<5;i++){
            cols[i]=new Mapa();
            rows[i]=new Mapa();
        }
        
    }

   

    public static class Mapa extends HashSet<Integer>{

        public Mapa(){
            super();
        }
    }
}
