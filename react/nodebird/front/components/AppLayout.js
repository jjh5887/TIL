import React from 'react';
import PropTypes from 'prop-types';

const AppLayout = ({ children }) => {
    return (
        <div>
            <div>공통메뉴</div>
            {children}
        </div>
    )
}

// propTypes -> js 에서 prop의 타입을 확인해주는 역할
AppLayout.propTypes = {
    children: PropTypes.node.isRequired, // node는 react의 모든 타입 (사용은 비추)
}

export default AppLayout;
