import React from 'react';
import PageTile from './PageTile';

function PageHeading({ children, title }) {
  return (
    <div className="page-heading-container">
      <PageTile title={title} />
      <p className="page-heading-paragraph">{children}</p>
    </div>
  );
}

export default PageHeading;
