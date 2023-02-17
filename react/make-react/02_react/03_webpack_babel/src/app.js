/* @jsx createElement */
import { createElement, render, Component } from './react';
// createElement 를 해당 코드에서 실행되지 않고 있더라도 번들링하는 파일에서 쓰고 있으니 포함시켜줘야함 (컴파일 에러는 안나지만 런타임 에러 발생)

class Title extends Component {
    render() {
        return <h1>{ this.props.children }</h1>;
    }
}

function Item(props) {
    return <li style={ 'color:' + props.color }>{ props.children }</li>;
}

const App = () => <p>
    <Title>React 정말 잘 만들기</Title>
    <ul>
        <Item color="red">첫 번째 아이템</Item>
        <Item color="blue">두 번째 아이템</Item>
        <Item color="green">세 번째 아이템</Item>
    </ul>
</p>

render(<App />, document.querySelector('#root'));
