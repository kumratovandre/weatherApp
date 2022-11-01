package org.weather.fetcher.api;

import lombok.RequiredArgsConstructor;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.weather.fetcher.repo.WeatherStatRepo;
import org.weather.fetcher.repo.model.WeatherStat;

@RequiredArgsConstructor
public class WeatherFetcherResourceImpl implements WeatherFetcherResource {

    private final WeatherStatRepo repository;
    private final ExternalWeatherApiResource externalWeatherApiResource;

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherFetcherResourceImpl.class);
    private static final String HEADER_KEY = "50cca8db1cmsh2de567f78bb86e7p1f124ejsn08b9f827c630";
    private static final String HEADER_HOST = "visual-crossing-weather.p.rapidapi.com";

    @Override
    public String saveExternalWeatherStats(String country, String city) {
        String location = String.format("%s,%s", country, city);

        WeatherStat externalParsedStat = externalWeatherApiResource.getWeather(
                HEADER_KEY,
                HEADER_HOST,
                24,
                location,
                "json",
                "uk",
                1
        );
        try {
            repository.save(externalParsedStat);
        } catch (Exception ex) {
            LOGGER.error("Error saving weather result", ex);
        }
        return externalParsedStat.toString();
    }

    @Override
    public String getAllStats() {
        return repository.getAllStats().toString();
    }
}
