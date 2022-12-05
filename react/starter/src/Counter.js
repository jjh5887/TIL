import React, { Component } from 'react';

class Counter extends Component {
    state = {
        number: 0
    }

    // 화살표 함수를 사용하지 않는다면... (굳이 이렇게 할 필요 x)
    constructor(props) {
        super(props);

        this.handleIncrease = this.handleIncrease.bind(this);
        this.handleDecrease = this.handleDecrease.bind(this);
    }

    // this 바인딩 때문에 화살표 함수만을 사용해야함
    // 일반함수 사용하려면 생성자를 통해서 this 바인딩을 해줘야함
    handleIncrease = () => {
        this.setState({
            number: this.state.number + 1
        })
    }

    handleDecrease = () => {
        this.setState({
            number: this.state.number - 1
        })
    }

    render() {
        return (
            <div>
                <h1>카운터</h1>
                <div>값: {this.state.number}</div>
                <button onClick={this.handleIncrease}>+</button>
                <button onClick={this.handleDecrease}>-</button>
            </div>
        )
    }
}

export default Counter;