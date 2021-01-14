package ro.mta.se.lab;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.net.URL;
/**
 * Clasa ce controleaza elementele din UI.
 *
 * @author Comandasu Andrei
**/
public class Controller implements Initializable  {
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    /**
     * abc&abc2 sunt elementele din UI in care se afiseaza tarile&orasele
     **/
    @FXML
    private ListView<String> abc;
    @FXML
    private ListView<String> abc2;
    /**
     * listatari&listaorase sunt listele date ca itemseource pentru ListView-uri
     */
    private ObservableList<String> listatari=FXCollections.observableArrayList();
    private ObservableList<String> listaorase=FXCollections.observableArrayList();
    /**
     * orase este o lista cu toate orasele din fisierul de intrare
     * tari este o lista cu tarile unice din fisierul de intrare
     */
    private ArrayList<Orase> orase;
    private ArrayList<String> tari=new ArrayList<String>();

    /**
     *parcurge lista de orase si adauga in lista de tari fiecare tara o singura data
     *initializeaza elementele din ListView-ul de tari
     */
    public void initialize(URL location, ResourceBundle resources){

       for(int i=0;i<orase.size();i++) {
           int ok=1;
           for(int j=0;j<tari.size();j++)
               if(orase.get(i).getCountryCode().equals(tari.get(j))){
                   ok=0;
                   break;
               }
           if(ok==1)
               tari.add(orase.get(i).getCountryCode());
       }

        for(String anObject : tari)
            listatari.add(anObject);

        abc.setItems(listatari);

    }

    /**
     *
     * @param orase continutul fisierului de intrare
     */
    public Controller (ArrayList<Orase> orase) {
        this.orase = orase;

    }

    /**
     * handler pentru ListView-ul de tari
     * initializeaza ListView-ul de orase
     */
    @FXML
    public void handle(MouseEvent event) {
        label1.setText("");
        label2.setText("");
        label3.setText("");
        listaorase= FXCollections.observableArrayList();
        for(Orase anObject :orase)
            if(anObject.getCountryCode().equals(abc.getSelectionModel().getSelectedItem()))
                listaorase.add(anObject.getNm());
        abc2.setItems(listaorase);
    }

    /**
     *handler pentru ListView-ul de orase
     * afiseaza datele cerute in labeluri
     */
    @FXML
    public void handle2(MouseEvent event) {
        Weather we=new Weather();
        ArrayList<String> s=we.main(abc2.getSelectionModel().getSelectedItem());
        label1.setText(s.get(0));
        label2.setText(s.get(1));
        label3.setText(s.get(2));
    }
}
