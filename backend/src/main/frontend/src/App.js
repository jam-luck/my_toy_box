import * as React from 'react';
import Blog from './components/blog/Blog';
import ErrorPage from './ErrorPage'
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
    <div>
      {serverConnect ? <Blog/> : <ErrorPage/>}
    </div>
  );
}

export default App;
