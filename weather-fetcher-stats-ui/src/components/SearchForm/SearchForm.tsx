import React from 'react';
import {useState} from 'react';
import WeatherDataService, {WeatherStat} from "../../dataservices/WeatherDataService";

export type SearchFormProps = {
  setApiData: (apiData: WeatherStat) => void;
};

export const SearchForm = ({ setApiData } : SearchFormProps) => {

  const [searchCountry, setSearchCountry] = useState<string>();
  const [searchCity, setSearchCity] = useState<string>();

  const setWeatherStats = async () => {
    setApiData(await WeatherDataService.getWeatherStats({
      country: searchCountry,
      city: searchCity,
      sort: 'date'}));
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    setWeatherStats();
  }

  return (
    <form onSubmit={handleSubmit}>
      <input type="text" name="country" onChange={(e) => setSearchCountry(e.target.value)}
             placeholder="enter country"/>
      <input type="text" name="city" onChange={(e) => setSearchCity(e.target.value)}
             placeholder="enter city"/>
      <input type="submit" value="Search Stats"/>
    </form>
  )
}
