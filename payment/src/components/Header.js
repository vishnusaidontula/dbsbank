import React from "react";
import { Link } from "react-router-dom";
import logo from "../asset/logo/digi.png";
import "./Header.css";
const Header = () => {
  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark" >
      <div className="container-fluid" >
        <Link to="/home" className="navbar-brand ms-2">
          <img src={logo} height="60" alt="logo" />
        </Link>
        <ul className="navbar-nav ms-auto mb-2 mb-lg-0">
          <li className="nav-item">
            <Link
              className="nav-link"
              style={{ fontWeight: "600", color: "white" }}
              to="/home"
            >
              Home
            </Link>
          </li>
          <li className="nav-item">
            <Link
              className="nav-link"
              style={{ fontWeight: "600", color: "white" }}
              to="/transaction"
            >
              Make Transaction
            </Link>
          </li>
          <li className="nav-item">
            <Link
              className="nav-link"
              style={{ fontWeight: "600", color: "white" }}
              to="/"
            >
              Logout
            </Link>
          </li>
        </ul>
      </div>
    </nav>
  );
};

export default Header;
