CREATE DATABASE IF NOT EXISTS weatherDb;

INSERT INTO weather_stat (country, city, result_date, weather_overall, weather_temperature, weather_scale) VALUES
('ukraine', 'poltava', '2022-11-01', 'sunny', 11.2, 'metric'),
('ukraine', 'poltava', '2022-11-02', 'rain', 2.1, 'metric'),
('ukraine', 'poltava', '2022-11-03', 'heavy clouds', 3.7, 'metric'),
('ukraine', 'poltava', '2022-11-04', 'clouds', 5.5, 'metric'),
('ukraine', 'poltava', '2022-11-05', 'clouds', 4.15, 'metric');
