import React from 'react'
import { Channel, LiveChannel } from '../channel';

import './style.css';

const ChannelSidebar = (channel : (Channel & LiveChannel & {wide : boolean})) => {
    
    return(
        <div className='channelSidebar container'>
            {(channel.wide &&
                <div className='row'>
                    <div className={channel.isLive ? 'img-container' : 'img-container offline'}><img src={"https://static-cdn.jtvnw.net/jtv_user_pictures/7f9fb630-6a2d-487d-aa25-4c95c2238f72-profile_image-70x70.png"} alt="profile" /></div>
                    <div className='col'>
                        <div className='channelName'>{channel.channelname}</div>
                        <div className='channelCategory'>{channel.category}</div>
                    </div>
                    {channel.isLive ?
                    <div className='col'>🔴 {channel.viewersCount}</div>
                    :
                    <div className='col' style={{color: "grey"}}>
                        Offline
                    </div>
                    }   
                </div>
            ) || 
                <div className={channel.isLive ? 'img-container' : 'img-container offline'}><img src={"https://static-cdn.jtvnw.net/jtv_user_pictures/7f9fb630-6a2d-487d-aa25-4c95c2238f72-profile_image-70x70.png"} alt="profile" /></div>
            }
        </div>
    );
}

export default ChannelSidebar;