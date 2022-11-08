package org.weather.fetcher.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ExternalResponseDto {

    @JsonProperty(value = "name")
    private String city;
    @JsonProperty(value = "weather")
    private ExternalResponseConditionsDto[] conditions;
    @JsonProperty(value = "main")
    private ExternalResponseMeasuresDto mainMeasures;

    @Override
    public String toString() {
        return "WeatherRootDto{" +
                "city='" + city + '\'' +
                ", conditions=" + Arrays.toString(conditions) +
                ", mainMeasures=" + mainMeasures +
                '}';
    }
}
