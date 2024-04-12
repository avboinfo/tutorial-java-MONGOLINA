//Verifica spesa Negrini Alessandro 4CIN
package Verifica_spesa;
import java.io.*;
import java.util.*;
public class Spesa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input per i prodotti
        List<Prodotto> prodotti = new ArrayList<>();
        System.out.println("Inserisci i dati dei prodotti (codice, descrizione, costo), separati da virgola. Per terminare, digita 'fine'.");
        String inputProdotto;
        while (true) {
            inputProdotto = scanner.nextLine();
            if (inputProdotto.equals("fine")) {
                break;
            }
            String[] parts = inputProdotto.split(",");
            if (parts.length >= 3) {
                prodotti.add(new Prodotto(parts[0], parts[1], Double.parseDouble(parts[2])));
            }
        }

        // Input per la lista della spesa
        Lista listaSpesa = new Lista();
        System.out.println("Inserisci i codici dei prodotti nella lista della spesa. Per terminare, digita 'fine'.");
        String codiceProdotto;
        while (true) {
            codiceProdotto = scanner.nextLine();
            if (codiceProdotto.equals("fine")) {
                break;
            }
            listaSpesa.aggiungiProdotto(codiceProdotto);
        }

        // Menu
        boolean continua = true;
        while (continua) {
            System.out.println("\nMenu:");
            System.out.println("1. Elimina ultimo prodotto inserito");
            System.out.println("2. Elimina prodotto dalla lista");
            System.out.println("3. Calcola costo totale della spesa");
            System.out.println("4. Stampa e salva lista della spesa");
            System.out.println("5. Esci");

            System.out.print("\nScelta: ");
            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline residuo

            switch (scelta) {
                case 1:
                    listaSpesa.eliminaUltimoProdotto();
                    break;
                case 2:
                    System.out.print("Inserisci il codice del prodotto da eliminare dalla lista della spesa: ");
                    String codiceDaEliminare = scanner.nextLine();
                    listaSpesa.eliminaProdotto(codiceDaEliminare);
                    break;
                case 3:
                    double costoTotale = listaSpesa.calcolaCostoTotale(prodotti);
                    System.out.println("Costo totale della spesa: " + costoTotale);
                    break;
                case 4:
                    System.out.print("Inserisci il nome del file in cui salvare la lista della spesa: ");
                    String nomeFile = scanner.nextLine();
                    listaSpesa.stampaESalvaLista(prodotti, nomeFile);
                    break;
                case 5:
                    continua = false;
                    break;
                default:
                    System.out.println("Scelta non valida");
            }
        }

        scanner.close();
    }
}