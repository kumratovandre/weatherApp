package org.weather.weatherfetcherstats;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.weather.weatherfetcherstats.model.WeatherStat;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "stats", path = "stats")
public interface WeatherStatsRepo extends JpaRepository<WeatherStat, Long> {

    @RestResource(path = "findByCountryAndCity", rel = "findByCountryAndCity")
    List<WeatherStat> findByCountryAndCity(
            @Param("country") String country,
            @Param("city") String city,
            Sort sort);
}
