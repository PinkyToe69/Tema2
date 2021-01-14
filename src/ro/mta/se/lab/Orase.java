package ro.mta.se.lab;

/**
 * clasa ce defineste obiectul de tip oras cu parametrii ceruti
 *
 * @author  Comandasu Andrei
 */
public class Orase {
    private String nm,countryCode;
    private float lat,lon;
    private boolean normal;
    private OraseInterface oraseInterface=null;

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getNm() {
        return nm;
    }

    public boolean isNormal(){return normal;}

    public Orase(OraseInterface oraseInterface)
    {   this.oraseInterface=oraseInterface;
        this.nm=oraseInterface.getNm();
        this.countryCode=oraseInterface.getCountryCode();
        this.lat=oraseInterface.getLat();
        this.lon= oraseInterface.getLon();
    }

    /**
     * metoda folosita la mocking
     */
    public void verifyValues(){
        if(lat>91||lat<-91||lon>181||lon<-181)
            normal=false;
        else
            normal= true;
    }
}
