import React from "react"

const Button = (props) => {
    return (
        <div>
            <button type={props.type} 
            className={`btn btn-outline-${props.outline} btn-${props.size}`}
            onClick={props.handleClick}>
                {props.text}
            </button>
        </div>
    )
}

export default Button
