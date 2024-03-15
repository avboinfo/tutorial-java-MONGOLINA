package C_Crypto;

import java.util.Scanner;

class Main {

    public static void main( String[] args ) {

        Scanner leggi = new Scanner(System.in);
        System.out.print("\nInserisci una frase da criptare: ");
        String frase = leggi.nextLine();
        System.out.print("Inserisci la chiave da usare: ");
        String chiave = leggi.nextLine();
        leggi.close();

        String fraseCrittata = Crypto.xorAlgo(frase, chiave);
        System.out.println("La frase crittata è: '" + fraseCrittata + "'");
        String fraseRiCrittata = Crypto.xorAlgo(fraseCrittata, chiave);
        System.out.println("La frase crittata nuovamente è: " + fraseRiCrittata);

    }



}