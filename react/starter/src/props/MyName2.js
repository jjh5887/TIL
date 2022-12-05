import React from 'react';

// 함수형 컴포넌트
// 클래스형보다 조금 빠르고, 메모리 사용량이 적음 -> 간단한 출력용 컴포넌트만
const MyName2 = ({name}) => {
    return <div>안녕하세요! 제 이름은 {name} 입니다.</div>
}

MyName2.defaultProps = {
    name: 'velopert'
};

export default MyName2;