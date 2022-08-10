import React from 'react'
import './Input.css';
const Input = (props) => {
    return (
        <div className={`input-group input-group-lg row`}>
            <label for="input" className="col-form-label col-sm-2">{props.label}</label> 
            <input type={props.type} 
            id="input"
            className="form-control col-sm-10"
            onKeyUp={props.handleKeyUp}
             placeholder={props.placeholder} />
        </div>
    )
}

export default Input
