import React from 'react';
import PropTypes from 'prop-types';
import Link from "next/link";
import { Col, Input, Menu, Row } from 'antd';
import styled from "styled-components";
import { useSelector } from 'react-redux';

import UserProfile from '../components/UserProfile';
import LoginForm from '../components/LoginForm';

const SearchInput = styled(Input.Search)`
    vertical-align: middle;
`;

const AppLayout = ({ children }) => {
    const { isLoggedIn } = useSelector((state => state.user));

    return (
        <div>
            <Menu mode="horizontal">
                <Menu.Item>
                    <Link href="/"><a>노드버드</a></Link>
                </Menu.Item>
                <Menu.Item>
                    <Link href="/profile"><a>프로필</a></Link>
                </Menu.Item>
                <Menu.Item>
                    <SearchInput enterButton/>
                </Menu.Item>
                <Menu.Item>
                    <Link href="/signup"><a>회원가입</a></Link>
                </Menu.Item>
            </Menu>
            <Row gutter={ 8 } // gutter 컬럼사이의 간격
            >
                <Col xs={ 24 } md={ 6 }>
                    { isLoggedIn ? <UserProfile /> :
                        <LoginForm /> }
                </Col>
                <Col xs={ 24 } md={ 12 }>
                    { children }
                </Col>
                <Col xs={ 24 } md={ 6 }>
                    오른쪽 메뉴
                </Col>
            </Row>
        </div>
    )
}

// redux로 인해 더이상 사용할 필요 X
// propTypes -> js 에서 prop의 타입을 확인해주는 역할
// AppLayout.propTypes = {
//     children: PropTypes.node.isRequired, // node는 react의 모든 타입 (사용은 비추)
// }

export default AppLayout;
