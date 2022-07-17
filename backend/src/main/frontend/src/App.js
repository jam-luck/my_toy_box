import * as React from 'react';
import Blog from './components/blog/Blog';
import ErrorPage from './ErrorPage';
import SignIn from './components/blog/SignIn';
import NotFoundPage from './NotFoundPage';
import { BrowserRouter, Route, Routes } from "react-router-dom";
function App() {
  const [serverConnect,setServerConnect] = React.useState(false);
  React.useEffect(()=>{
    fetch('/ping')
    .then(response => response.text())
    .then(msg => {
      console.log(msg);
      if(msg === "connected"){
        setServerConnect(true);
      }
    })
    .catch((error) => {
      console.error("서버연결실패",error);
    })
  })
  return (
  <BrowserRouter>
    <Routes>
      <Route exact path="/" element={serverConnect ? <Blog/> : <ErrorPage/>}/>
      <Route exact path="/signin" element={<SignIn/>}/>
      <Route path="*" element={<NotFoundPage/>}/>
    </Routes>
  </BrowserRouter>
  );
}

export default App;
