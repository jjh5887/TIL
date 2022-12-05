import React, {Component} from 'react';
import MyComponent from "./MyComponent";

class App extends Component {
    state = {
        counter: 1,
        error: false,
    }

    // 생성자
    constructor(props) {
        super(props);
        console.log('constructor');
    }

    // 컴포넌트가 화면에 나올 때
    componentDidMount() {
        console.log('componentDidMont');
        console.log(this.myDiv.getBoundingClientRect());
    }

    handleClick = () => {
        this.setState({
            counter: this.state.counter + 1
        })
    }

    // 컴포넌트에 에러가 발생 할 때 (에러가 발생하는 컴포넌트의 부모에서 사용해야함)
    componentDidCatch(error, errorInfo) {
        console.log(error);
        console.log(errorInfo);
        this.setState({
            error: true,
        });
        // API 를 통해서 서버로 오류 내용 날리기
    }

    render() {
        if (this.state.error) {
            return (
                <div>에러 발생</div>
            )
        }
        return (
            <div ref={ref => this.myDiv = ref}>
                <h1>안녕하세요 리액트</h1>
                { this.state.counter < 10 && <MyComponent value={this.state.counter} />}
                <button onClick={this.handleClick}>Click Me</button>
            </div>
        );
    }
}