CREATE TABLE IF NOT EXISTS weather_stat (
    result_id INT PRIMARY KEY auto_increment,
    country varchar(50) not null,
	city varchar(50) not null,
	result_date date not null,
	weather_overall varchar(50) not null,
	weather_temperature decimal(4,1) not null,
    weather_scale varchar(10) not null
);