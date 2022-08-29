import React, { useState } from "react";
import hq from "../asset/images/hq.jpg";
import logo from "../asset/logo/digi.png";
import postElement from "../services/postElement";
import Button from ".//Button";
import Input from ".//Input";
import { useNavigate } from "react-router-dom";
const LoginForm = () => {
  const [username, setUsername] = useState();
  const [password, setPassword] = useState();
  const navigate = useNavigate();
  const handleSubmit = () => {
    const employee={
      employeeName:username,
      password:password
    }
    postElement(`/checkemployee`,employee)
      .then((res) => {
        navigate("/home");
      })
      .catch((err) => {
        alert("Invalid credentials");
      });
  };
  return (
    <div className="digi">

    
    <div className="container-fluid ">
     
      <form className="form-horizontal" role="form" method="post" >
        <div className="d-flex py-3">
          <div className="card pb-3 bg-lavender">
            <div className="card-header justify-content-center align-items-center d-md-flex">
              <center><img src={logo} height="60" alt="logo" /></center>
              
            </div>
            <div className="card-body-new">
              <table className="table table-borderless">
                <tbody>
                  <tr>
                    <td>
                      <h6 className="medium mb-0">
                        
                      </h6>
                    </td>
                    <td className="ps-3">
                    <br/>
                      <Input
                        type="text"
                        placeholder="Enter Username"
                        handleKeyUp={(value) => setUsername(value)}
                        isRequired={true}
                      />
                      
                      <div className="invalid-feedback">
                        <span>Please enter a username.</span>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <h6 className="small mb-0">
                        
                      </h6>
                    </td>
                    <td className="ps-3">
                      <Input
                        type="password"
                        placeholder="Enter password"
                        handleKeyUp={(value) => setPassword(value)}
                        isRequired={true}
                      />
                      <div className="invalid-feedback">
                        <span>Please enter a password.</span>
                      </div>
                    </td>
                  </tr>
                </tbody>
              </table>
              <br/>
              
              <div className="col-12 justify-content-center align-items-center mx-auto d-flex ">
                <Button
                  type="button"
                  size="lg"
                  text="Login"
                  outline="danger"
                  handleClick={handleSubmit}
                />
              </div>
            </div>
          </div>
        </div>
      </form>
    </div>
    </div>
  );
};

export default LoginForm;
