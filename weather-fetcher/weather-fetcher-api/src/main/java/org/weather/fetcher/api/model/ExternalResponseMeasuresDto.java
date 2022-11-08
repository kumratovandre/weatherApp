package org.weather.fetcher.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ExternalResponseMeasuresDto {

    @JsonProperty
    private Float temp;

    @JsonProperty
    private Integer pressure;

    @Override
    public String toString() {
        return "WeatherTempDto{" +
                "temp=" + temp +
                ", pressure=" + pressure +
                '}';
    }
}
