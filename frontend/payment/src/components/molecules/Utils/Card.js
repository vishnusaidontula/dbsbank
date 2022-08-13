import React from "react";
import "./Card.css"


const Card=(props)=>{
    return(
        <div className="row row-cols-1 row-cols-md-3 g-4">
            {
            props.details.map(value=>(
            <div className="col" key={value.id}>
                <div className="card h-100">
                    <img src={value.imgv} className="card-img-top" alt="..."/>
                    <div className="card-body">
                        <h5 className="card-title">{value.title}</h5> 
                    </div>
                </div>
            </div>
            ))
           }
        </div>
    );
}

export default Card;