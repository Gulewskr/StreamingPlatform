import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";

import ChannelSidebar from '../channels/sidebar/channelSidebar';

import './sidebar.css';

const Sidebar = () =>
{ 
    const [ showed, setShowed ] = useState(true);
    const [ active, setActive ] = useState(true);
    //const change
    useEffect(() => {
        if( window.innerWidth < 768)
        {
            setActive(false);
            setShowed(false);
        }

        function onResize() {
            if( window.innerWidth < 768)
            {
                setActive(false);
            }else{
                setActive(true);
            }
        }

        window.addEventListener('resize', onResize)
    }, [])

    return(
        <nav className={showed ? "l-navbar showed" : "l-navbar hidden" } style={{"color" : "white"}}> 
            { active && 
            <div className="nav-item" style={{"whiteSpace" : "nowrap", "minHeight": "30px"}}>
                <span id="sidebar-button-span" >{showed && "Followed channels"}</span>
                <a id="sidebar-button" onClick={() => setShowed(!showed)}>{showed ? '<-' : '->'}</a>
            </div>
            }
            {(active && showed) || <div>💚</div>}
            {
                //Followed channels list
                <div className="nav-item">
                    <ChannelSidebar channelname={"Kanał"} channelImageUrl={"zdjecie"} channelDescription={"opis szybki"} isLive={true} viewersCount={100} category={"Fortnite"} tags={["Polski", "Gaming"]} wide={active && showed} />
                    <ChannelSidebar channelname={"Kanał"} channelImageUrl={"zdjecie"} channelDescription={"opis szybki"} isLive={true} viewersCount={100} category={"Fortnite"} tags={["Polski", "Gaming"]} wide={active && showed} />
                    <ChannelSidebar channelname={"Kanał"} channelImageUrl={"zdjecie"} channelDescription={"opis szybki"} isLive={true} viewersCount={100} category={"Fortnite"} tags={["Polski", "Gaming"]} wide={active && showed} />
                    <ChannelSidebar channelname={"Kanał"} channelImageUrl={"zdjecie"} channelDescription={"opis szybki"} isLive={false} viewersCount={100} category={"Fortnite"} tags={["Polski", "Gaming"]} wide={active && showed} />
                </div>
            }
            <Link className="link" to="/">{showed ? 'Show More' : 'more'}</Link>
            <div className="nav-item" style={{"whiteSpace" : "nowrap", "marginTop" : "15px"}}>
                {showed && <span id="sidebar-button-span" >Recomended channels</span>}
            </div>
            {(active && showed) || <div>🎥</div>}
            {
                //Recomended channels list
                <div className="nav-item">
                    <ChannelSidebar channelname={"Kanał"} channelImageUrl={"zdjecie"} channelDescription={"opis szybki"}
                    isLive={true} viewersCount={100} category={"Fortnite"} tags={["Polski", "Gaming"]} wide={active && showed}/>
                </div>
            }
            <Link className="link" to="/">{showed ? 'Show More' : 'more'}</Link>
        </nav>
    );
};
export default Sidebar;