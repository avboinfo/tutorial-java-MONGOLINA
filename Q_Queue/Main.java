package Q_Queue;

public class Main {


    public static void main( String[] args) {
        Queue<String> q = new Queue<>();
        q.insert("Forza magica Juve!");
        q.insert("Forza magico Catanzaro!");
        q.insert("Forza semplice Bologna!");
        System.out.println( q.remove() );
        System.out.println( q.remove() );
        System.out.println( q.remove() );
    }


}
