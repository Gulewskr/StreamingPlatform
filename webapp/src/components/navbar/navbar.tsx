import React, { useEffect, useState } from 'react';
//import {} from 'react-'
import logo from './../../logo.svg';
import { NavLink } from 'react-router-dom';
import './navbar.css';

function Navbar()
{
    /*
    TODO - scroll responsive navbar

    const [ scrollPos, setScrollPos] = useState(0);

    useEffect(() => {
        var currentScrollPos = window.pageYOffset;
        if(document){
            var navbar = document.getElementById("navbar");
            if(navbar)
            {
                if (scrollPos < 80 || scrollPos > currentScrollPos) {
                    navbar.style.top = "0";
                } else {
                    navbar.style.top = "-400px";
                }
            }
        }     
        setScrollPos(currentScrollPos);
        console.log(currentScrollPos);
    }, [window.pageYOffset]);
    */

    return (
        <nav className="navbar navbar-expand-lg navbar-dark"  style={{ paddingLeft: "20px", paddingRight: "20px", backgroundColor: '#191919', borderBottom: "solid 2px black"}}>
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
                        <NavLink to="/Following" className={ ({isActive}) =>  "nav-link" + (isActive ? " active" : "")}><div className='linkbutton text-center'>Following</div></NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink to="/Browse" className={ ({isActive}) =>  "nav-link" + (isActive ? " active" : "")}><div className='linkbutton text-center'>Browse</div></NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink to="/Categories" className={ ({isActive}) =>  "nav-link" + (isActive ? " active" : "")}><div className='linkbutton text-center'>Categories</div></NavLink>
                    </li>
                    
                </ul>
                <ul className="navbar-nav navbar-right mb-2 ml-2">
                    <li className="nav-item">
                        <NavLink to="/LogIn" className={ ({isActive}) =>  "nav-link p-2 m-1 loginandregisterbutton text-center" + (isActive ? " active" : "")} style={{color: "white"}}>Log In</NavLink>
                    </li>
                    <li className="nav-item">
                        <NavLink to="/SignIn" className={ ({isActive}) =>  "nav-link p-2 m-1 loginandregisterbutton text-center" + (isActive ? " active" : "")} style={{color: "white"}}>Sign In</NavLink>
                    </li>
                </ul>
            </div>
        </nav>
    )
}

export default Navbar