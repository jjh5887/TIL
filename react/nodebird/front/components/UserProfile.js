import React, { useCallback } from "react";
import { Avatar, Button, Card } from "antd";
import { useDispatch } from "react-redux";
import { logoutAction } from "../reducers/user";

const UserProfile = () => {
    const dispatch = useDispatch();
    const onLogOut = useCallback(() => {
        dispatch(logoutAction());
    }, []);

    return (
        <Card
            actions={ [
                <div key="twit">짹짹<br/>0</div>,
                <div key="following">팔로잉<br/>0</div>,
                <div key="follower">팔로워<br/>0</div>,
            ] }
        >

            <Card.Meta
                avatar={ <Avatar>ZC</Avatar> }
                title="ZeorCho"
            />
            <Button onClick={ onLogOut }>로그아웃</Button>
        </Card>
    )
};

export default UserProfile;