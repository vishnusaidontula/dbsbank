import React from "react";
import { Link } from "react-router-dom";
import "./Card.css"
import asset from "../asset/images/background.png";


const Card=(props)=>{
    return(
        <div>
            <br/>
            <br/>
            <center>
             <img src={asset} width="700" height="200"/>
             </center>
      
        <div className="box" >
            {
            props.details.map((value,index)=>(
            <Link key={index} to={value.path} className="link">
            <div className="col">
                <div className="card h-100">
                  
                    <div className="card-body">
                        <h5 className="card-title">{value.title}</h5> 
                    </div>
                </div>
            </div>
            </Link>
            ))
           }
        </div>
        </div>
    );
}

export default Card;