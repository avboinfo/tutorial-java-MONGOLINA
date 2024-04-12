package Verifica_spesa;
import java.io.*;
import java.util.*;

class Prodotto {
    String codice;
    String descrizione;
    double costo;

    Prodotto(String codice, String descrizione, double costo) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.costo = costo;
    }
}

class Lista {
    Nodo head;

    Lista() {
        this.head = null;
    }

    void aggiungiProdotto(String codice) {
        Nodo nuovoNodo = new Nodo(codice);
        nuovoNodo.next = head;
        head = nuovoNodo;
    }

    void eliminaUltimoProdotto() {
        if (head == null) {
            System.out.println("Lista vuota");
            return;
        }
        head = head.next;
    }

    void eliminaProdotto(String codice) {
        Nodo current = head;
        Nodo prev = null;

        while (current != null && !current.codice.equals(codice)) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Prodotto non trovato");
            return;
        }

        if (prev == null) {
            head = head.next;
        } else {
            prev.next = current.next;
        }
    }

    double calcolaCostoTotale(List<Prodotto> prodotti) {
        double costoTotale = 0;
        Nodo current = head;

        while (current != null) {
            for (Prodotto prodotto : prodotti) {
                if (prodotto.codice.equals(current.codice)) {
                    costoTotale += prodotto.costo;
                    break;
                }
            }
            current = current.next;
        }

        return costoTotale;
    }

    void stampaESalvaLista(List<Prodotto> prodotti, String fileName) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));

            Nodo current = head;

            while (current != null) {
                String descrizione = "Descrizione non disponibile";
                for (Prodotto prodotto : prodotti) {
                    if (prodotto.codice.equals(current.codice)) {
                        descrizione = prodotto.descrizione;
                        break;
                    }
                }
                writer.println("Codice: " + current.codice + ", Descrizione: " + descrizione);
                System.out.println("Codice: " + current.codice + ", Descrizione: " + descrizione);
                current = current.next;
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}