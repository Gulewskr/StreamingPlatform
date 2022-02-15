import React from 'react';
import logo from './../logo.svg';

//components
import SignIn from '../components/forms/signin/signin';

//styles
import './../App.css';

const Signin = () => {
  return(
    <div className="App">
      <SignIn />
    </div>
  );
}

export default Signin;
