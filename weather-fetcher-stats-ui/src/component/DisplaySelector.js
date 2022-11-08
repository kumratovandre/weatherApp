import React from 'react';

export default function DisplaySelector(props) {

    if (props.apiData && props.apiData.length === 0) {
        return <p>no weather stats for selected location</p>;
    }
    if (props.apiData && props.apiData.length > 0) {
        return (
            <div>
                <button onClick={() => {
                    props.setDisplayType('table');
                }}>
                    Table View
                </button>
                <span> </span>
                <button onClick={() => {
                    props.setDisplayType('chart');
                }}>
                    Chart View
                </button>
            </div>
        )
    }

}
