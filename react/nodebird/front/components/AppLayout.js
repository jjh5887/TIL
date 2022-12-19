import React from 'react';
import PropTypes from 'prop-types';
import Link from "next/link";

const AppLayout = ({ children }) => {
    return (
        <div>
            <div>
                <Link href="/"><a>노드버드</a></Link>
                <Link href="/profile"><a>프로필</a></Link>
                <Link href="/signup"><a>회원가입</a></Link>

            </div>
            <div>
                {children}
            </div>
        </div>
    )
}

// propTypes -> js 에서 prop의 타입을 확인해주는 역할
AppLayout.propTypes = {
    children: PropTypes.node.isRequired, // node는 react의 모든 타입 (사용은 비추)
}

export default AppLayout;
