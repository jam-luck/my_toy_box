import React, {useState} from "react";
const PageTop = () => {
    const [userName, setUserName] = useState("사용자 정보 없음"); 
    return (
        <div>
            사용자정보창 <br/>
            {userName}
        </div>
    );
}
export default PageTop;