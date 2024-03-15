import java.util.ArrayList;

public class Pila<T>{
    ArrayList<T> lista;

    public Pila(){
        lista = new ArrayList<T>();
    }

    public void push(T newElement){
        list.add(newElement);
    }

    public T pop(){
        int size = list.size();
        if(size==0){
            null;
        }
    }
}