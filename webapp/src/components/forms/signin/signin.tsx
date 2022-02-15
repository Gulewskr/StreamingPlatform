import React from "react";
import { Link } from "react-router-dom";

import './../forms.css';
import './signin.css';

const SignIn = () => (
    <div className="SignInFrom FormDiv mx-auto">
        <h1>Welcome to the Family</h1>
        <form className="mx-auto" action="">
            <div className="mb-3">
              <label htmlFor="exampleInputEmail1" className="form-label">Nickname</label>
              <input type="text" className="form-control" id="input-nickname"/>
            </div>
            <div className="mb-3">
              <label htmlFor="exampleInputEmail1" className="form-label">E-mail</label>
              <input type="email" className="form-control" id="input-email"/>
            </div>
            <div className="mb-3">
              <label htmlFor="exampleInputPassword1" className="form-label">Password</label>
              <input type="password" className="form-control" id="input-password"/>
            </div>
            <div className="mb-3">
              <label htmlFor="exampleInputPassword1" className="form-label">Reapeat Password</label>
              <input type="password" className="form-control" id="input-password"/>
            </div>
            <div className="mb-3">
              <label htmlFor="exampleInputPassword1" className="form-label">Date of Born</label>
              <input type="date" className="form-control" id="input-borndate"/>
            </div>
            <button type="submit" className="btn btn-primary FormButton">Sign In</button>
            <div className="form-text FormTextRef">
                <Link className="FormTextRef" to="/Login">Already have an account? - Log In</Link>
            </div>
        </form>
      </div>
)

export default SignIn;