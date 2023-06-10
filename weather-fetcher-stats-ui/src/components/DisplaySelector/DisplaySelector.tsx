import React from 'react';

export const DisplaySelector = (props: any) => {

  if (props.apiData && props.apiData.length === 0) {
    return (
      <>
        <p>no weather stats for selected location</p>
      </>
    );
  }
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
