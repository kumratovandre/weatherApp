package org.weather.fetcher.api;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

public class ExternalApiFactory {

    public static ExternalWeatherApiResource createExternalWeatherApi(String uri) {
        return JAXRSClientFactory.create(uri, ExternalWeatherApiResource.class);
    }

}
