//Alessandro Negrini 4CIN

package APP;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Mailbox mailbox = new Mailbox();
        Scanner scanner = new Scanner(System.in);
        
        // Menu
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Aggiungi email");
            System.out.println("2. Elimina email");
            System.out.println("3. Cerca email per oggetto");
            System.out.println("4. Esci");
            System.out.print("Scelta: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consuma il carattere newline
            
            switch (choice) {
                case 1:
                    System.out.print("Mittente: ");
                    String sender = scanner.nextLine();
                    System.out.print("Oggetto: ");
                    String subject = scanner.nextLine();
                    System.out.print("Data e ora: ");
                    String dateTime = scanner.nextLine();
                    System.out.print("Testo: ");
                    String text = scanner.nextLine();
                    Mailbox.Email email = new Mailbox.Email(sender, subject, dateTime, text);
                    mailbox.addEmail(email);
                    System.out.println("Email aggiunta con successo.");
                    break;
                case 2:
                    System.out.print("Inserisci l'indice dell'email da eliminare: ");
                    int index = scanner.nextInt();
                    mailbox.deleteEmail(index);
                    System.out.println("Email eliminata con successo.");
                    break;
                case 3:
                    System.out.print("Inserisci il testo da cercare nell'oggetto: ");
                    String searchText = scanner.nextLine();
                    System.out.println("Email trovate:");
                    for (Mailbox.Email e : mailbox.searchBySubject(searchText)) {
                        System.out.println("Mittente: " + e.getSender());
                        System.out.println("Oggetto: " + e.getSubject());
                        System.out.println("Data e ora: " + e.getDateTime());
                        System.out.println("Testo: " + e.getText());
                        System.out.println();
                    }
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
        
        scanner.close();
    }
}