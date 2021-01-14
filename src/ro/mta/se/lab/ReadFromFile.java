package ro.mta.se.lab;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * clasa pentru citirea fisierului de intrare
 *
 * @author  Comandasu Andrei
 */
public class ReadFromFile {
    /**
     * string in care se va salva fisierul de intrare
     */
    public String continutfisier="";

    /**
     * citirea fisierului
     */
    public  void main() {
        try {
            File myObj = new File(System.getProperty("user.dir")+"\\src\\ro\\mta\\se\\lab\\orase");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                continutfisier=continutfisier+" "+data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
