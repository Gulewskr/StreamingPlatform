import React from 'react';
import logo from '../logo.svg';
import '../App.css';
import Sidebar from '../components/sidebar/sidebar';

const Home = () => {
  return(
    <div className="App">
    <Sidebar />
    <header className="App-header">
      <img src={logo} className="App-logo" alt="logo" />
      <p>
        Place Under Construction - Home.
      </p>
    </header>
  </div>
  );
}

export default Home;
