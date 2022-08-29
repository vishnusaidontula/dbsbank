import React from "react";
import "./Input.css";
const Input = (props) => {
    const handleChange = (event)=>{
        props.handleKeyUp(event.target.value)
    }
  return (
    <div className={`input-group form-group row  align-items-center`}>
      <input
        type={props.type}
        className="form-control col-auto"
        onChange={handleChange}
        placeholder={props.placeholder}
        required = {props.isRequired}
        step={props.step}
        min={props.minValue?props.minValue:0}
      />
    </div>
  );
};

export default Input;
