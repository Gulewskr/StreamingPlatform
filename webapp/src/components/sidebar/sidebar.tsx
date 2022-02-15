import React from "react";

import './sidebar.css';

const Sidebar = () => (
    <div className="l-navbar" style={{"color" : "white"}}> 
        <ul className="nav_list">
            <li className="nav_link">
                jeden
            </li>
            <li className="nav_link">
                dwa
            </li>
            <li className="nav_link">
                trzy
            </li>
            <li className="nav_link">
                cztery
            </li>
        </ul>
    </div>
);

export default Sidebar;