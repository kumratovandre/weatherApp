package org.weather.weatherfetcherstats.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherStatUtil {

    private static final String FETCHER_API_URI = "http://localhost:8181/cxf/weather/%s/%s";

    public static String getNewStat(String country, String city) {
        String preparedUri = String.format(FETCHER_API_URI, country, city);

        HttpRequest req = HttpRequest.newBuilder(URI.create(preparedUri)).build();

        String response = null;
        try {
            response = HttpClient.newHttpClient().send(req, HttpResponse.BodyHandlers.ofString())
                    .body();
        } catch (IOException | InterruptedException ex) {
            System.out.println("error fetching data");
        }
        return response;
    }

}
