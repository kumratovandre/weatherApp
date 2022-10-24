package org.weather.fetcher.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
public interface WeatherFetcherResource {

    @GET
    @Path("/{country}/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    String getWeatherByCountryCity(@PathParam("country") String country, @PathParam("city") String city);

}
