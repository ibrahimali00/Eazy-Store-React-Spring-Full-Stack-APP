import React from 'react';

const BootstrapBtn = ({ text, type }) => {
  return <button className={`btn btn-${type}`}>{text}</button>;
};

export default BootstrapBtn;
