package ro.mta.se.lab;

/**
 * clasa ce realizeaza legatura cu clasa Orase
 *
 * @author Comandasu Andrei
 */
public class OraseInterface {
    private String nm,countryCode;
    private float lat,lon;

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
    public OraseInterface(String nm, String lat, String lon, String countryCode)
    {
        this.nm=nm;
        this.countryCode=countryCode;
        this.lat=Float.parseFloat(lat);
        this.lon=Float.parseFloat(lon);
    }

}
