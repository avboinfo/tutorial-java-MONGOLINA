package L_Lista;

public class Lista {

    Nodo radice;
    
    public Lista() {
        radice = null;
    }

    public boolean isEmpty() {
        return radice==null;
    }

    public void addTail( Nodo n ) {
        if (isEmpty()) {
            radice = n;
        } else {
            Nodo p = radice;
            while (p.getSuccessivo()!=null) p = p.getSuccessivo();
            p.setSuccessivo( n );
        }
    }

    public void addHead(Nodo n){
        if (isEmpty()){
            radice = n;
        } else{
            n.setSuccessivo(radice);
            radice = n;
        }
    }

    public void addSorted(Nodo n){
        if (isEmpty()) {
            radice = n;
            return;
        } 

        Nodo p1 = radice;
        Nodo p2 = radice.getSuccessivo();
        int vN = n.getValore();

        if (p1.getValore()>vN) {
            n.setSuccessivo(radice);
            radice = n;
            return;
        }
        
        while (vN>p1.getValore() && p2!=null && vN>p2.getValore()) {
            p1=p2;
            p2=p1.getSuccessivo();
        }
        n.setSuccessivo(p2);
        p1.setSuccessivo(n);
    }
    

    public String toString() {
        String s = "Elementi della lista: ";
        Nodo p = radice;
        while (p!=null) {
            s += p + " ";
            p = p.getSuccessivo();
        }
        s += "End!\n";
        return s;
    }
}