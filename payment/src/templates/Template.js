import React from "react";
import Header from "../components/Header";
const Template = (props) => {
  return (
    <div>
      <Header />
      {props.children}
    </div>
  );
};

export default Template;
