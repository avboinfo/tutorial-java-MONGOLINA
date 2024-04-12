package Verifica_spesa;

class Nodo {
    String codice;
    Nodo next;

    Nodo(String codice) {
        this.codice = codice;
        this.next = null;
    }
}