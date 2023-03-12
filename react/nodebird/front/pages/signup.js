import React, { useCallback, useState } from 'react';
import AppLayout from "../components/AppLayout";
import { Button, Checkbox, Form, Input } from "antd";
import useInput from "../hooks/useInput";
import styled from "styled-components";

const ErrorMessage = styled.div`
    color: red;
`

const Signup = () => {
    // 아래와 같은 코드가 지속적으로 반복되면 커스텀 훅을 생성하라
// const [id, setId] = useState('');
// const onChangeId = useCallback((e) => {
//     setId(e.target.value);
// }, []);

// const [password, setPassword] = useState('');
// const onChangePassword = useCallback((e) => {
//     setId(e.target.value);
// }, []);

    // 커스텀 훅으로 리팩토링
    const [ id, onChangeId ] = useInput('');
    const [ password, onChangePassword ] = useInput('');
    const [ nickName, onChangeNickname ] = useInput('');

    // 중복되지 않은 경우 커스텀 훅 사용 불가능
    const [ passwordError, setPasswordError ] = useState(false);
    const [ passwordCheck, setPasswordCheck ] = useState('');
    const onChangePasswordCheck = useCallback((e) => {
        setPasswordCheck(e.target.value);
        setPasswordError(password !== e.target.value);
    }, [ password ]);

    const [ term, setTerm ] = useState(false);
    const [ termError, setTermError ] = useState(false);
    const onChangeTerm = useCallback((e) => {
        setTerm(e.target.checked);
        setTermError(false);
    }, []);

    const onSubmit = useCallback(() => {
        if (password !== passwordCheck) {
            return setPasswordError(true);
        }
        if (!term) {
            return setTermError(true);
        }

        console.log(id, nickName, password);
    }, [password, passwordCheck, term]);

    return (
        <AppLayout>
            <header>
                <title>회원가입 | NodeBird</title>
            </header>
            <Form onFinish={ onSubmit }>
                <div>
                    <label htmlFor="user-id">아이디</label>
                    <br/>
                    <Input name="user-id" value={ id } required onChange={ onChangeId }/>
                </div>
                <div>
                    <label htmlFor="user-nickname">닉네임</label>
                    <br/>
                    <Input name="user-nickname" value={ nickName } required onChange={ onChangeNickname }/>
                </div>
                <div>
                    <label htmlFor="user-password">비밀번호</label>
                    <br/>
                    <Input name="user-password" value={ password } type="password" required onChange={ onChangePassword }/>
                </div>

                <div>
                    <label htmlFor="user-password-check">비밀번호체크</label>
                    <br/>
                    <Input
                        name="user-password-check"
                        value={ passwordCheck }
                        type="password"
                        required
                        onChange={ onChangePasswordCheck }/>
                </div>
                { passwordError && <ErrorMessage>비밀번호가 일치하지 않습니다.</ErrorMessage> }
                <div>
                    <Checkbox name="user-team" checked={ term } onChange={ onChangeTerm }> 약관의 동의하겠습니다.</Checkbox>
                    { termError && <ErrorMessage>약관에 동의하셔야 합니다.</ErrorMessage> }
                </div>
                <div style={{ marginTop: 10 }}>
                    <Button type="primary" htmlType="submit">가입하기</Button>
                </div>
            </Form>

        </AppLayout>
    );
};

export default Signup;