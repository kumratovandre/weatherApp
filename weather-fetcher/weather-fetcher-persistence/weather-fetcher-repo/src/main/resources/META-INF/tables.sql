create table if not exists weather_stats (
    result_id int auto_increment,
    country varchar(50) not null,
	city varchar(50) not null,
	result_date date not null,
	weather_overall varchar(50) not null,
	weather_temperature decimal(4,1) not null,
    weather_scale varchar(10) not null,
    primary key(result_id)
);