package ro.mta.se.lab;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * clasa principala a programului
 * citeste fisierul de intrare si initializeaza stageul
 *
 * @author Comandasu Andrei
 */
public class Main extends Application {

    /**
     * lista de orase din fisierul de intrare
     */
    private ArrayList<Orase> oraseData = new ArrayList<Orase>();


    public ArrayList<Orase> getOraseData(){
        return oraseData;
    }
    /**
     * construieste lista de orase
     * @param s continutul fisierului de intrare sub forma de string
     */
    public void initializeOrase(String s){

        String[] result = s.split(" ");

        for (int x=1; x<result.length; x++) {
            oraseData.add(new Orase(new OraseInterface(result[x],result[x+1],result[x+2],result[x+3])));
            x=x+3;
        }
    }

    /**
     * citirea fisierului si initializarea stage-ului
     */
    public void start(Stage primaryStage) {
        ReadFromFile fp=new ReadFromFile();
        fp.main();
        initializeOrase(fp.continutfisier);
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(this.getClass().getResource("sample.fxml"));
            loader.setController(new Controller(oraseData));
            primaryStage.setScene(new Scene(loader.load()));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
