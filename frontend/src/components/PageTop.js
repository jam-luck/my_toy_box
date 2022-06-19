import React, {useState,useEffect} from "react";
const PageTop = () => {
    const [connect, setConnect] = useState("연결안됨"); 
    const [userName, setUserName] = useState("사용자 정보 없음"); 
    useEffect(()=> {
        fetch('/ping')
            .then(response => response.text())
            .then(msg => {
                setConnect(msg);
            });
    },[])
    return (
        <div>
            사용자정보창 <br/>
            
            <p>서버 연결상태: {connect}</p>
            <p>유저정보: {userName}</p>
        </div>
    );
}
export default PageTop;