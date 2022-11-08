import React from 'react';
import './App.css';
import ChartStats from './component/ChartStats'
import TableStats from './component/TableStats'
import DisplaySelector from './component/DisplaySelector'
import SearchForm from './component/SearchForm';
import { useState } from "react";

function App() {

    const [displayType, setDisplayType] = useState(null);
    const [apiData, setApiData] = useState(null);

    return (
        <div className="App">
            <header>
                <h1>Weather Stats and Search</h1>
            </header>
            <main>
                <SearchForm setApiData={setApiData} />
                <p></p>
                <DisplaySelector apiData={apiData} setDisplayType={setDisplayType} />
                <p></p>
                {displayType === 'chart'
                    ? <ChartStats apiData={apiData} />
                    : <TableStats apiData={apiData} />}
            </main>
        </div>
    )
}

export default App;
