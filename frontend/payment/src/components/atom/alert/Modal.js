import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

const Modal = (props) => {
    const [loading, setLoading] = useState(true);
    const params=useParams();
    const navigate=useNavigate();
    const buttonHandler=()=>{
        navigate(`/transaction/${params.obj}`);
    }

    useEffect(()=>{
        setLoading(false);
    },[loading])
    console.log("Details",params);
  return (
    <>
    {loading ? (
        <h1>loading</h1>
      ) : (
        <div>
        <button type="button" className="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
        Launch demo modal
      </button>
    <div className="modal" tabIndex="-1" role="dialog">
      <div className="modal-dialog" role="document">
        <div className="modal-content">
          <div className="modal-header">
            <h5 className="modal-title">{props.title}</h5>
            <button
              type="button"
              className="close"
              data-dismiss="modal"
              aria-label="Close"
            >
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div className="modal-body">
            <p>{props.body}</p>
          </div>
          <div className="modal-footer">
            <button type="button" className="btn btn-secondary" onClick={buttonHandler}>
              Close
            </button>
          </div>
        </div>
      </div>
    </div>
    </div>
      )}
    </>
  );
};

export default Modal;
