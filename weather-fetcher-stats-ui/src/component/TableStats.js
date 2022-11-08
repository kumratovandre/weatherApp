import '../App.css';
import React from 'react';

export default function TableStats(props) {
    const stats = props.apiData;
    if (stats && stats.length > 0) {
        return (
            <div className="wrapper">
                <table>
                    <thead>
                    <tr>
                        <th>country</th>
                        <th>city</th>
                        <th>overall</th>
                        <th>temperature</th>
                        <th>date</th>
                    </tr>
                    </thead>
                    <tbody>
                    {stats.map((stat, index) => (
                        <tr key={index}>
                            <td>{stat.country}</td>
                            <td>{stat.city}</td>
                            <td>{stat.overall}</td>
                            <td>{stat.temperature}</td>
                            <td>{stat.date}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        )
    }

}
