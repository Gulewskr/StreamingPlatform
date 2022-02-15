import React from "react";
import { Link } from "react-router-dom";

const Login = () => (
    <div className="SignInFrom FormDiv mx-auto">
        <h1>Log In to GulLive</h1>
        <form className="mx-auto" action="">
            <div className="form-floating mb-3">
              <input type="email" className="form-control" id="input-email" placeholder="email" />
              <label htmlFor="input-email">E-mail</label>
            </div>
            <div className="form-floating mb-3">
              <input type="password" className="form-control" id="input-password" placeholder="password" />
              <label htmlFor="input-password">Password</label>
            </div>
            <div className="checkbox mb-3">
              <label className="checkbox-label">
                <input type="checkbox" value="remember-me"/> <span>Remember me</span>
              </label>
            </div>
            <button type="submit" className="btn btn-primary FormButton">Log In</button>
            <div className="form-text">
                <Link className="FormTextRef" to="/Login">Forgot a password?</Link>
            </div>
        </form>
      </div>
);

export default Login;