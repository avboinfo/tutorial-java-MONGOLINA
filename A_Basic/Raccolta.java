import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Raccolta {
    ArrayList<Videogame> lista;

    public Raccolta(String file){
        File f = new File(file);
        lista = new ArrayList<>();
        try{
            Scanner fileInput = new Scanner(f);

            while(fileInput.hasNextLine()){
                String line = fileInput.nextLine();
                String[] field = line.split(";");
                lista.add(new Videogame(field[0],field[1],Float.parseFloat(field[2]),Integer.parseInt(field[3])));

            }
            fileInput.close();
        }catch(Exception e){
            System.out.println("Errore nel ");
        }

    }
    public String toString(){
        String s = "Elementi della lista: \n";
        for(int i = 0; i < lista.size(); i++){
            s += lista.get(i) + "\n";
        }
        return s;
    }
}