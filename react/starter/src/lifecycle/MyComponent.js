import React, {Component} from 'react';

class MyComponent extends Component {
    state = {
        value: 0
    };

    // props 와 state 를 연동
    static getDerivedStateFromProps(nextProps, prevState) {
        if (prevState.value !== nextProps.value) {
            return {
                value: nextProps.value
            };
        }
        return null;
    }

    // 특정 조건에 따라 렌더링(업데이트)을 막아주는 함수
    shouldComponentUpdate(nextProps, nextState) {
        return nextProps.value !== 10;
    }

    // render() -> getSnapshotBeforeUpdate() -> 실제 DOM에 변화 발생 -> componentDidUpdate() 순으로 발생
    getSnapshotBeforeUpdate(prevProps, prevState) {

    }

    // render 호출하고난 뒤 -> 이 시점에는 this.props 와 this.state 가 바뀌어 있음 (getSnapshotBeforeUpdate 에서 snapshot 받아 올 수 있음)
    componentDidUpdate(prevProps, prevState) {
        if (this.props.value !== prevProps.value) {
            console.log('value 값이 바뀌었다!', this.props.value);
        }
    }

    // 컴포넌트가 제거 될 때
    componentWillUnmount() {
        console.log('good bye');
    }

    render() {
        return (
            <div>
                {this.props.missing.something}
                <p>props: {this.props.value}</p>
                <p>state: {this.state.value}</p>
            </div>
        )
    }
}

export default MyComponent;