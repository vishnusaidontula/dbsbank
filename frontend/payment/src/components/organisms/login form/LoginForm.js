import React, { useState } from "react";
import logo from "../../../asset/logo/brand-left.jpg";
import postElement from "../../../services/postElement";
import Button from "../../atom/button/Button";
import Input from "../../atom/input/Input";
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
    <div className="container-fluid">
      <form>
        <div className="d-flex justify-content-center align-items-center py-3">
          <div className="card pb-3">
            <div className="card-header align-items-center d-md-flex">
              <img src={logo} height="60" alt="logo" />
              <h4 className="p-3 text-danger">Login Form</h4>
            </div>
            <div className="card-body">
              <table className="table table-borderless">
                <tbody>
                  <tr>
                    <td>
                      <h6 className="small mb-0">
                        <span className="text-reset">Username</span>
                      </h6>
                    </td>
                    <td className="ps-3">
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
                        <span className="text-reset">Password</span>
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
  );
};

export default LoginForm;
