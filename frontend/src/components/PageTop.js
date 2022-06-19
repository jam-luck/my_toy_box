import React, {useState,useEffect} from "react";
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
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
        <Card sx={{ minWidth: 275 }}>
            <CardContent>
                <Typography variant="h5" component="div">
                    사용자정보창
                </Typography>
                <Typography variant="body2">
                    서버 연결상태: {connect}
                    <br />
                    유저정보: {userName}
                </Typography>
            </CardContent>
        </Card>
    );
}
export default PageTop;