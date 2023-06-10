import React from 'react';
import './App.css';
import {useState} from "react";
import {ChartStats} from "./components/ChartStats";
import {SearchForm} from './components/SearchForm';
import {DisplaySelector} from './components/DisplaySelector';
import {TableStats} from './components/TableStats';
import {WeatherStat} from "./dataservices/WeatherDataService";

function App() {

  type DisplayType =  'table' | 'chart';

  const [displayType, setDisplayType] = useState<DisplayType>('table');
  const [apiData, setApiData] = useState<WeatherStat>();

  return (
    <div className="App">
      <header>
        <h1>Weather Stats and Search</h1>
      </header>
      <main>
        <SearchForm setApiData={setApiData}/>
        <p></p>
        <DisplaySelector apiData={apiData} setDisplayType={setDisplayType}/>
        <p></p>
        {displayType === 'chart'
          ? <ChartStats apiData={apiData}/>
          : <TableStats apiData={apiData}/>}
      </main>
    </div>
  )
}

export default App;
