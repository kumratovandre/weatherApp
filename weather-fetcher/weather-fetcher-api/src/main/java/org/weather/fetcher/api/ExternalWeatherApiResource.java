package org.weather.fetcher.api;

import org.weather.fetcher.repo.model.WeatherStat;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("")
public interface ExternalWeatherApiResource {

    @GET
    @Path("/forecast")
    WeatherStat getWeather(@HeaderParam("X-RapidAPI-Key") String headerKey,
                           @HeaderParam("X-RapidAPI-Host") String headerHost,
                           @QueryParam("aggregateHours") Integer aggregateHours,
                           @QueryParam("location") String location,
                           @QueryParam("contentType") String contentType,
                           @QueryParam("unitGroup") String unitGroup,
                           @QueryParam("forecastDays") Integer forecastDays);

}
