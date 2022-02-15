import React from 'react';

export interface Channel {
    channelname: string;
    channelImageUrl: string;
    channelDescription: string;
}

export interface LiveChannel {
    isLive : boolean;
    viewersCount : number;
    category : string;
    tags : string[];
}