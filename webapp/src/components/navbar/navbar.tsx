import React from 'react';
//import {} from 'react-'
import logo from './../../logo.svg';
import { NavLink } from 'react-router-dom';
import './navbar.css';

function Navbar()
{
    return (
        <nav className="navbar navbar-expand-lg navbar-dark"  style={{ paddingLeft: "20px", paddingRight: "20px", backgroundColor: '#191919'}}>
            <NavLink  to="/" className="navbar-brand">
                <img src={logo} alt="" width="30" height="30" className="d-inline-block align-text-top" />
                GulLive
            </NavLink>
            <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarSupportedContent">
                <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                    <li className="nav-item">
                        <NavLink to="/Following" className={ ({isActive}) =>  "nav-link" + (isActive ? " active" : "")}>Following</NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink to="/Browse" className={ ({isActive}) =>  "nav-link" + (isActive ? " active" : "")}>Browse</NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink to="/Categories" className={ ({isActive}) =>  "nav-link" + (isActive ? " active" : "")}>Categories</NavLink>
                    </li>
                    
                </ul>
                <ul className="navbar-nav navbar-right mb-2 ml-2">
                    <li className="nav-item">
                        <NavLink to="/LogIn" className={ ({isActive}) =>  "nav-link p-2 m-1 loginandregisterbutton" + (isActive ? " active" : "")}>Log In</NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink to="/SignIn" className={ ({isActive}) =>  "nav-link p-2 m-1 loginandregisterbutton" + (isActive ? " active" : "")}>Sign In</NavLink>
                    </li>
                </ul>
            </div>
        </nav>
    )
}

export default Navbar