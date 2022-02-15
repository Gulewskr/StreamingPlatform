import React from "react";
import { Link } from "react-router-dom";

const Login = () => (
    <div className="SignInFrom FormDiv mx-auto">
        <h1>Log In to GulLive</h1>
        <form className="mx-auto" action="">
            <div className="mb-3">
              <label htmlFor="exampleInputEmail1" className="form-label">E-mail</label>
              <input type="email" className="form-control" id="input-email"/>
            </div>
            <div className="mb-3">
              <label htmlFor="exampleInputPassword1" className="form-label">Password</label>
              <input type="password" className="form-control" id="input-password"/>
            </div>
            <button type="submit" className="btn btn-primary FormButton">Log In</button>
            <div className="form-text">
                <Link className="FormTextRef" to="/Login">Forgot a password?</Link>
            </div>
        </form>
      </div>
);

export default Login;