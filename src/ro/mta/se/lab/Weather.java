package ro.mta.se.lab;
import org.json.JSONObject;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

/**
 * clasa ce preia obiectul JSON de la server si il parseaza
 *
 * @author  Comandasu Andrei
 */
public class Weather {

    private static HttpURLConnection connection;

    /**
     * clasa ce preia obiectul JSON, il parseaza cu ajutorul metodei parse si il returneaza sub forma de lista de stringuri
     * @param oras orasul ce trebuie cautat
     * @return returneaza datele cerute sub forma de lista de stringuri
     */
    public  ArrayList<String> main (String oras){

        HttpClient client=HttpClient.newHttpClient();
        HttpRequest request=HttpRequest.newBuilder().uri(URI.create("http://api.openweathermap.org/data/2.5/weather?q="+oras+"&appid=32763dd07a7853006c546a21554a456c&units=metric")).build();
      return  client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).thenApply(Weather::parse).join();

    }

    /**
     *
     * parseaza obiectul JSON preluat de la metoda main
     * @return returneaza lista de stringuri obtinuta din obiectul JSON parsat
     */
    public static ArrayList<String> parse(String responsebody){

        JSONObject obj=new JSONObject(responsebody);

        float temp=obj.getJSONObject("main").getFloat("temp");
        float wind=obj.getJSONObject("wind").getFloat("speed");
        float humi=obj.getJSONObject("main").getFloat("humidity");

        ArrayList<String>s=new ArrayList<String>();
        s.add(Float.toString(temp));
        s.add(Float.toString(wind));
        s.add(Float.toString(humi));

        return s;
    }








}