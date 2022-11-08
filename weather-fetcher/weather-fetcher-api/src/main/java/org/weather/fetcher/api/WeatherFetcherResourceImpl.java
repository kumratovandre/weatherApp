package org.weather.fetcher.api;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.weather.fetcher.api.model.ExternalResponseDto;
import org.weather.fetcher.repo.WeatherStatRepo;
import org.weather.fetcher.repo.model.WeatherStat;

import java.time.LocalDate;

@RequiredArgsConstructor
public class WeatherFetcherResourceImpl implements WeatherFetcherResource {

    private final WeatherStatRepo repository;
    private final ExternalWeatherApiResource externalWeatherApiResource;

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherFetcherResourceImpl.class);
    private static final String API_KEY = "50e633653c83b8b7fe03b924b9e3a6ed";

    @Override
    public String saveExternalWeatherStats(String country, String city) {
        String location = String.format("%s,%s", country, city);

        ExternalResponseDto response = externalWeatherApiResource.getWeather(location, API_KEY, MeasureUnits.METRIC);

        WeatherStat weatherStat = new WeatherStat(
                null,
                country,
                city,
                LocalDate.now(),
                response.getConditions()[0].getOverall(),
                response.getMainMeasures().getTemp(),
                MeasureUnits.METRIC.name()
        );

        try {
            repository.save(weatherStat);
        } catch (Exception ex) {
            LOGGER.error("Error saving weather result", ex);
        }
        return weatherStat.toString();
    }

    @Override
    public String getAllStats() {
        return repository.getAllStats().toString();
    }
}
