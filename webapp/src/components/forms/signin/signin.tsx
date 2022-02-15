import React from "react";
import { Link } from "react-router-dom";

import './../forms.css';
import './signin.css';

const SignIn = () => (
    <div className="SignInFrom FormDiv mx-auto">
        <h1>Welcome to the Family</h1>
        <form className="mx-auto" action="">
            <div className="form-floating mb-3">
              <input type="text" className="form-control" id="inputNickname" placeholder="Nickname"/>
              <label htmlFor="inputNickname">Nickname</label>
            </div>
            <div className="form-floating mb-3">
              <input type="email" className="form-control" id="input-email" placeholder="Email"/>
              <label htmlFor="input-email">Email</label>
            </div>
            <div className="form-floating mb-3">
              <input type="password" className="form-control" id="input-password" placeholder="password"/>
              <label htmlFor="input-password" className="form-label">Password</label>
            </div>
            <div className="form-floating mb-3">
              <input type="password" className="form-control" id="input-password" placeholder="password"/>
              <label htmlFor="input-password">Reapeat Password</label>
            </div>
            <div className="form-floating mb-3">
              <input type="date" className="form-control" id="input-borndate"/>
              <label htmlFor="input-borndate">Date of Born</label>
            </div>
            <button type="submit" className="btn btn-primary FormButton">Sign In</button>
            <div className="form-text FormTextRef">
                <Link className="FormTextRef" to="/Login">Already have an account? - Log In</Link>
            </div>
        </form>
      </div>
)

export default SignIn;