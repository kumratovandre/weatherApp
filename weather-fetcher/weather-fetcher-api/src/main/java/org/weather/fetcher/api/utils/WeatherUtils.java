package org.weather.fetcher.api.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.weather.fetcher.repo.model.WeatherStat;

import java.util.Date;

public class WeatherUtils {

    private static final String SCALE_CELSIUS = "CELSIUS";

    public static WeatherStat parseResponse(String stringResponse, String country, String city) {
        JsonObject json = JsonParser.parseString(stringResponse).getAsJsonObject();
        JsonObject currentWeather = json.getAsJsonObject("locations")
                .getAsJsonObject(String.format("%s,%s", country, city))
                .getAsJsonArray("values").get(0).getAsJsonObject();

        return new WeatherStat(
                null, country, city, new Date(System.currentTimeMillis()),
                currentWeather.get("conditions").toString(),
                currentWeather.get("temp").getAsFloat(),
                SCALE_CELSIUS
        );

    }

}
