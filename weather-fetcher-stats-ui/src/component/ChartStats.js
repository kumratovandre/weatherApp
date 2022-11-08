import React from 'react';
import { Line, LineChart, XAxis, YAxis, CartesianGrid, Tooltip } from 'recharts';

export default function ChartStats(props) {

    if (props.apiData && props.apiData.length > 0) {
        return (
            <div className='chart'>
                <LineChart width={600} height={300} data={props.apiData}>
                    <Line type="natural" dataKey="temperature" stroke="#8884d8" />
                    <CartesianGrid stroke="#ccc" />
                    <XAxis dataKey="date" />
                    <YAxis />
                    <Tooltip />
                </LineChart>
            </div>
        )
    }
}
