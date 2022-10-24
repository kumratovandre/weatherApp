package org.weather.fetcher.repo;

import org.weather.fetcher.repo.model.WeatherStat;

public interface WeatherStatRepo {

    void save(WeatherStat ws);

}
