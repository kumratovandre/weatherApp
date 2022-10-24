package org.weather.fetcher.api.utils;

import org.json.JSONObject;
import org.weather.fetcher.repo.model.WeatherStat;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Date;

public class WeatherUtils {

    private static final String SCALE_CELSIUS = "CELSIUS";

    public static HttpRequest prepareRequest(String url) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("X-RapidAPI-Key", "50cca8db1cmsh2de567f78bb86e7p1f124ejsn08b9f827c630")
                .header("X-RapidAPI-Host", "visual-crossing-weather.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
    }
    public static WeatherStat parseResponse(String stringResult, String country, String city) {
        JSONObject responseObject = new JSONObject(stringResult);
        JSONObject currentWeather = (JSONObject) responseObject.getJSONObject("locations")
                .getJSONObject(String.format("%s,%s", country, city)).getJSONArray("values").get(0);

        return new WeatherStat(
                null, country, city, new Date(currentWeather.getLong("datetime")),
                currentWeather.getString("conditions"),
                currentWeather.getFloat("temp"),
                SCALE_CELSIUS
        );

    }

}
