import logo from './logo.svg';
import React, {useState, useEffect} from 'react';
import './App.css';

function App() {
	
	// message 초기값을 ""으로 설정. 
	const [message, setMessage] = useState("");
	useEffect( () => { 
		// fetch(url,options) : HTTP 요청 함수 
		fetch('/test') 
		.then(response => response.text()) 
		.then(message => { 
		setMessage(message); 
		});
		},[])

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        	<h1 className="App-title">{message}</h1> 
      </header> 
      <p className="App-intro"> 
      	To get started, edit <code>src/App.js</code> and save to reload. 
      </p>
    </div>
  );
}

export default App;
