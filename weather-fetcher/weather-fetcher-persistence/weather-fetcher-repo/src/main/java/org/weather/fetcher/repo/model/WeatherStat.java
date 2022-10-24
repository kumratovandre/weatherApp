package org.weather.fetcher.repo.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "WEATHER_STATS")
@NoArgsConstructor
@AllArgsConstructor
public class WeatherStat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String country;
    private String city;
    @Column(name = "RESULT_DATE")
    private Date date;
    @Column(name = "WEATHER_OVERALL")
    private String overall;
    @Column(name = "WEATHER_TEMPERATURE")
    private Float temperature;
    @Column(name = "WEATHER_SCALE")
    private String scale;

    @Override
    public String toString() {
        return "WeatherResult{" +
                "id='" + id + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", resultDate=" + date +
                ", weatherOverall='" + overall + '\'' +
                ", weatherTemperature='" + temperature + '\'' +
                ", weatherScale='" + scale + '\'' +
                '}';
    }
}
