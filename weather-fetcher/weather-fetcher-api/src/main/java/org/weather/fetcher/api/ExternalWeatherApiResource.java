package org.weather.fetcher.api;

import org.weather.fetcher.api.model.ExternalResponseDto;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("")
public interface ExternalWeatherApiResource {

    @GET
    @Path("/weather")
    @Produces({MediaType.APPLICATION_JSON})
    ExternalResponseDto getWeather(@QueryParam("q") String location,
                                   @QueryParam("appid") String apikey,
                                   @QueryParam("units") MeasureUnits units);
}
