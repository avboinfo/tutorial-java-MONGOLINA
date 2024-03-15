package L_Lista;

public class Lista {

    class Iteratore{
        private Nodo nodo;
        private Iteratore(Nodo nodo){
            this.nodo = nodo;
        }
        public boolean hasNext(){
            return nodo!=null;
        }
        public Nodo next(){
            if(nodo==null) return null;
            Nodo result = new Nodo(nodo.getValore(), nodo.getSuccessivo());
            
        }
    }

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
    
    public boolean addAfter(Nodo n, int pos){
        if(isEmpty()){
            return false;
        }
        Nodo newNodo = new Nodo(valore:123; null;);
        Nodo current = n;
        for(int i=0; i < pos; i++){
            if(current.getSuccessivo() == null){
                return false;
            }
            current = current.successivo();
        }
    }
public boolean remotePos(int pos){

}

public boolean remoteValue(){

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