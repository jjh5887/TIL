import React, { useCallback, useMemo, useState } from "react";
import { Button, Form, Input } from "antd";
import Link from "next/link";
import styled from "styled-components";

const ButtonWrapper = styled.div`
    margin-top: 10px;
`;

const LoginForm = () => {
    const [id, setId] = useState('');
    const [password, setPassword] = useState('');

    const onChangeId = useCallback((e) => {
        setId(e.target.value);
    }, []);

    const onChangePassword = useCallback((e) => {
        setPassword(e.target.value);
    }, []);

    // 리랜더링 돼도 값을 유지
    const style = useMemo(() => ({ marginTop: 10 }), []);

    return (
        <Form>
            <div>
                <label htmlFor="user_id">아이디</label>
                <br/>
                <Input name="user-id" value={id} onChange={onChangeId} required/>
            </div>
            <div>
                <label htmlFor="user_id">비밀번호</label>
                <br/>
                <Input name="user-password"
                       value={password}
                       onChange={onChangePassword}
                       type="password"
                       required
                />
            </div>

            {/*
                <div style={{ marginTop: 10 }}>
                style을 객체로 하면 리랜더링 할때 마다 다시 그림 (객체로 비교를 해서)
            */}
            <ButtonWrapper style={style}>
                <Button type="primary" htmlType="submit" loading={false}>로그인</Button>
                <Link href="/signup"><a><Button>회원가입</Button></a></Link>
            </ButtonWrapper>
        </Form>
    )
};

export default LoginForm;