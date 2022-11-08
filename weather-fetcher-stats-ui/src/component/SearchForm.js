import {useState} from 'react';

export default function SearchForm(props) {

    const baseUri = 'http://localhost:8080/stats/search/findByCountryAndCity';
    const [searchCountry, setSearchCountry] = useState(null);
    const [searchCity, setSearchCity] = useState(null);
    const sortColumn = 'date';
    const sortOrder = 'asc';

    const handleSubmit = (e) => {
        e.preventDefault();

        async function fetchData() {
            const response = await fetch(`${baseUri}?country=${searchCountry}&city=${searchCity}&sort=${sortColumn},${sortOrder}`);
            const data = await response.json();
            // const stats = data._embedded.stats;
            props.setApiData(data);
        }

        fetchData();
    }

    return (
        <form onSubmit={handleSubmit}>
            <input type="text" name="country" onChange={(e) => setSearchCountry(e.target.value)}
                   placeholder="enter country"/>
            <input type="text" name="city" onChange={(e) => setSearchCity(e.target.value)} placeholder="enter city"/>
            <input type="submit" value="Search Stats"/>
        </form>
    )
}
