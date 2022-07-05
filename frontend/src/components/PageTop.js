import React, {useState,useEffect} from "react";
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
const PageTop = () => {
    //const [connect, setConnect] = useState("연결안됨");
    const [Spring3, setSpring3] = useState("");
    //const [userName, setUserName] = useState("사용자 정보 없음");
    const [userList, setUserList] = useState([]);  
    /*
    useEffect(()=> {
        fetch('/ping')
            .then(response => response.text())
            .then(msg => {
                setConnect(msg);
            });
    },[])
    */
    useEffect(()=> {
        fetch('/spring3/test')
            .then(response => response.text())
            .then(msg => {
                setSpring3(msg);
            });
    },[])
    useEffect(()=> {
        fetch('/user')
            .then(response => response.text())
            .then(msg => {
                setUserList(msg);
            });
    },[])
    return (
        <Card sx={{ minWidth: 275 }}>
            <CardContent>
                <Typography variant="h5" component="div">
                    사용자정보창
                </Typography>
                <Typography variant="body2">
                    Spring3 Rest: {Spring3}
                    <br/>
                    userList: {userList}
                </Typography>
            </CardContent>
        </Card>
    );
}
export default PageTop;