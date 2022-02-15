import React from 'react';
import { Link } from 'react-router-dom';

import './other.css'

const INVCreateAccount = () => (
    <div className='mx-auto StyledDiv1'>
        <div className='row'>
            <div className='col'>
                <div style={{
                    "width": '200px',
                    "height": '200px',
                    "backgroundColor": "green"
                }} className="mx-auto">
            </div>
            </div>
            <div className='text-start col'>
                Don't have an account?<br />
                Join now and become <br />
                a streamer <br />
                or<br />
                an active fan<br />
                of our family. 
            </div>
        </div>
        <div className='row'>
                <Link className="SimpleButton" to="/Signin">Create new Account</Link>
        </div>
    </div>
);

export default INVCreateAccount;