import logo from './logo.svg';
import './App.css';
import { useEffect, useState } from "react";
import axios from "axios"

function App() {

  const [name, setName] = useState("kys0522");
  const [counter, setCounter] = useState(1);
  const [todos, setTodos] = useState([]);

  useEffect(()=>{
    console.log('use effect')
    return ()=>{
      console.log('cleanup')
    }
  }, [name, counter])

  useEffect(()=>{
    axios.get('https://dummyjson.com/todos?limit=' + counter)
    .then(res =>  {
      console.log(res.data.todos);
      setTodos(res.data.todos);
    });
  }, [counter])

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <p onClick={()=>setName("TGC")}>
          {name}
        </p>
        <p onClick={()=>setCounter(counter + 1)}>
          {counter}
        </p>
        <ul>
          {
            todos.map((todo)=><li>{todo.todo}</li>)
          }
        </ul>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
