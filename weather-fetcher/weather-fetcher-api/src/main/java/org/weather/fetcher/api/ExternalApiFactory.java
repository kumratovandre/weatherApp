package org.weather.fetcher.api;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import java.util.List;

public class ExternalApiFactory {

    public static ExternalWeatherApiResource createExternalWeatherApi(String uri) {
        return JAXRSClientFactory.create(uri, ExternalWeatherApiResource.class,
                List.of(new JacksonJsonProvider()));
    }

}
