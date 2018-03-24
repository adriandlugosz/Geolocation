package pl.adriandlugosz.geolocalizer.repository;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;

@Component
public class GeoCoordinate {

    private String adress;

    public GeoCoordinate() {
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCoordinate() {
        Geocoder geocoder = new Geocoder();
        GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(adress).setLanguage("en").getGeocoderRequest();

        try {
            GeocodeResponse geocodeResponse = geocoder.geocode(geocoderRequest);

            return "Latitude: "+String.valueOf(geocodeResponse.getResults().get(0).getGeometry().getLocation().getLat())+"  Longitude: "+String.valueOf(geocodeResponse.getResults().get(0).getGeometry().getLocation().getLng());

        } catch (IOException e) {
            e.getMessage();
        }
        return "Not found";
    }
}

