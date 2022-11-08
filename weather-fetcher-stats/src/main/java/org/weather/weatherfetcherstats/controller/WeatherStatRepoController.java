package org.weather.weatherfetcherstats.controller;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.weather.weatherfetcherstats.WeatherStatsRepo;
import org.weather.weatherfetcherstats.util.WeatherStatUtil;
import org.weather.weatherfetcherstats.model.WeatherStat;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@BasePathAwareController
public class WeatherStatRepoController {

    private final WeatherStatsRepo weatherStatsRepo;

    public WeatherStatRepoController(WeatherStatsRepo repo) {
        this.weatherStatsRepo = repo;
    }

    @RequestMapping(path = "stats/search/findByCountryAndCity", method = RequestMethod.GET, produces = "application/hal+json")
    public @ResponseBody ResponseEntity<?> requestNewStatIfNotFound(
            @Param("country") String country,
            @Param("city") String city,
            Sort sort
    ) {
        List<WeatherStat> stats = weatherStatsRepo.findByCountryAndCity(country, city, sort);
        boolean isTodayStatPresent = stats.stream().anyMatch(stat -> stat.getDate().equals(LocalDate.now()));
        if (stats.size() == 0 || !isTodayStatPresent) {
            String newStat = WeatherStatUtil.getNewStat(country, city);
            System.out.println(newStat);
            stats = weatherStatsRepo.findByCountryAndCity(country, city, sort);
        }

        return ResponseEntity.ok(stats);
    }

}
