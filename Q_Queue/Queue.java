package Q_Queue;

import java.util.ArrayList;

public class Queue<P> {

    ArrayList<P> data;

    public Queue( ) {
        data = new ArrayList<>();
    }
 
    public void insert( P newElement ) {
        data.add(newElement);
    }    

    public P remove( ) {
        if (data.isEmpty()) return null;
        return data.remove(0);
    }

    
}
