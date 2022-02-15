import React from 'react';
import logo from './../logo.svg';

//components
import {default as LoginForm} from '../components/forms/login/login' ;
import INVCreateAccount from '../components/other/createAccount';

//styles
import './../App.css';

const Login = () => {
  return(
    <div className="App">
      <div className='row row-cols-1 row-cols-lg-2'>
        <div className='col'><LoginForm /></div>
        <div className='col'><INVCreateAccount /></div>
      </div>
    </div>
  );
}

export default Login;
