import React from "react";
import { Link } from "react-router-dom";
import "./Card.css"


const Card=(props)=>{
    return(
        <div className="box">
            {
            props.details.map((value,index)=>(
            <Link to={`/${index}`} className="link">
            <div className="col" key={index}>
                <div className="card h-100">
                    <img src={value.imgv} className="card-img-top" alt="..."/>
                    <div className="card-body">
                        <h5 className="card-title">{value.title}</h5> 
                    </div>
                </div>
            </div>
            </Link>
            ))
           }
        </div>
    );
}

export default Card;