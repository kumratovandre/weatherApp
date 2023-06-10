import axios from 'axios';

export type Scale = 'CELSIUS' | 'FAHRENHEIT'

export type WeatherStat = {
  county: string
  city: string
  date: string
  overall: string
  temperature: number
  scale: Scale
}

export type WeatherFetchParams = {
  country: string | undefined,
  city: string | undefined,
  sort?: string,
};

const getWeatherStats = async (fetchParams: WeatherFetchParams): Promise<WeatherStat> => {
  const { data } = await axios.get('/stats/search/findByCountryAndCity', {
    baseURL: 'http://localhost:8080',
    params: fetchParams
  });
  return data;
};

export default {
  getWeatherStats,
};
