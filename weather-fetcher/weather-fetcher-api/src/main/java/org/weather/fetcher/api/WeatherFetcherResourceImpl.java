package org.weather.fetcher.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.weather.fetcher.api.utils.WeatherUtils;
import org.weather.fetcher.repo.WeatherStatRepoImpl;
import org.weather.fetcher.repo.model.WeatherStat;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherFetcherResourceImpl implements WeatherFetcherResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherFetcherResourceImpl.class);
    private static final String API_URL = "https://visual-crossing-weather.p.rapidapi.com/forecast" +
            "?aggregateHours=24&location=%s,%s&contentType=json&unitGroup=uk&forecastDays=1";

    public String getWeatherByCountryCity(String country, String city) {
        String weatherApiUrl = String.format(API_URL, country, city);
        HttpRequest request = WeatherUtils.prepareRequest(weatherApiUrl);

        String status = "success";
        WeatherStat parsedResponse = null;
        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            parsedResponse = WeatherUtils.parseResponse(response.body(), country, city);
            new WeatherStatRepoImpl().save(parsedResponse);
        } catch (Exception ex) {
            status = "Something else went wrong";
            LOGGER.error("Something else went wrong: ", ex);
        }
        return status;

    }
}
