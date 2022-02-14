import React from 'react';
import logo from './logo.svg';
import './App.css';
import Navbar from './components/navbar/navbar';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { Home, Login, Signin } from './pages/';

function App() {
  return (
    <BrowserRouter>
      <div className='background'/>
      <div>
        <Navbar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/Following" element={<Home />} />
          <Route path="/Browse" element={<Home />} />
          <Route path="/Categories" element={<Home />} />
          <Route path="/LogIn" element={<Login />} />
          <Route path="/SignIn" element={<Signin />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
