import React, {Component} from 'react';

class MyName extends Component {
    // props 기본값 1 -> 요게 최신
    static defaultProps = {
        name: '기본이름'
    }

    render() {
        return (
            <div>
                안녕하세여! 제 이름은 <b>{this.props.name}</b> 입니다.
            </div>
        )
    }
}

// props 기본값 2
// MyName.defaultProps = {
//     name: 'velopert'
// };

export default MyName;