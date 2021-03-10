
import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";

import {NavLink} from "react-router-dom";
class HeaderComponent extends React.Component {
    render() {
        return (

            <div >
            
            <nav className="navbar navbar-expand-sm bg-light navbar-light">
              <NavLink className="navbar-brand" to="/home">
                Grocers
              </NavLink>
              <button
                className="navbar-toggler"
                type="button"
                data-toggle="collapse"
                data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false"
                aria-label="Toggle navigation"
              >
                <span className="navbar-toggler-icon"></span>
              </button>
     
              <div className="collapse navbar-collapse" id="navbarSupportedContent">
                <ul className="navbar-nav mr-auto">
                 
                  <li className="nav-item">
                    <NavLink className="nav-link" to="/home">
                      Home
                    </NavLink>
                  </li>
                 
                    <li className="nav-item"><NavLink className="nav-link" to="/about">About Us</NavLink></li>
                    <li className="nav-item"><NavLink className="nav-link" to="/contact">Contact Us</NavLink></li>
                  <li className="nav-item"><NavLink className="nav-link" to="/products">Product</NavLink></li>
                  <li className="nav-item"><NavLink className="nav-link" to="/order">Order</NavLink></li>
                  <li className="nav-item"><NavLink className="nav-link" to="/orderReview">OrderReview</NavLink></li>
                  <li className="nav-item"><NavLink className="nav-link" to="/tracking">Tracking</NavLink></li>
                  </ul>
                  <ul className="navbar-nav ml-auto">
                  <li className="nav-item"><NavLink className="nav-link" to="/login">Login</NavLink></li>
                  <li className="nav-item"><NavLink className="nav-link" to="/signUp">SignUp</NavLink></li>
                  </ul>
                  
                  
                
              </div>
            </nav>
          </div>
        );
      }
    }
    export default HeaderComponent;



