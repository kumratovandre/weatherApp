package org.weather.fetcher.repo.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "WEATHER_STATS")
@NoArgsConstructor
@AllArgsConstructor
public class WeatherStat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESULT_ID")
    private Integer resultId;
    private String country;
    private String city;
    @Column(name = "RESULT_DATE")
    @Temporal(TemporalType.DATE)
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
                "id='" + resultId + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", resultDate=" + date +
                ", weatherOverall='" + overall + '\'' +
                ", weatherTemperature='" + temperature + '\'' +
                ", weatherScale='" + scale + '\'' +
                '}';
    }
}
