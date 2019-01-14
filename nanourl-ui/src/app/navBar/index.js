import React from 'react';
import {Link, withRouter} from 'react-router-dom';
import { authClient } from '../../components/auth';

const NavBar = (props) => {
  const signOut = () => {
    authClient.signOut();
    props.history.replace('/');
  };

  return (
    <nav className="navbar navbar-dark bg-primary fixed-top">
      <Link className="navbar-brand" to="/">
        Q&App
      </Link>
      {
        !authClient.isAuthenticated() &&
        <button className="btn btn-dark" onClick={authClient.signIn}>Sign In</button>
      }
      {
        authClient.isAuthenticated() &&
        <div>
          <label className="mr-2 text-white">{authClient.getProfile().name}</label>
          <button className="btn btn-dark" onClick={() => {signOut()}}>Sign Out</button>
        </div>
      }
    </nav>
  );
}

export default withRouter(NavBar);