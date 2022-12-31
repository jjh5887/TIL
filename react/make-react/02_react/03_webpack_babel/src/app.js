/* @jsx createElement */
import { render, createElement } from './react';
// createElement 를 해당 코드에서 실행되지 않고 있더라도 번들링하는 파일에서 쓰고 있으니 포함시켜줘야함 (컴파일 에러는 안나지만 런타임 에러 발생)

const vdom = <p>
    <h1>React 만들기</h1>
    <ul>
        <li style="color:red">첫 번째 아이템</li>
        <li style="color:blue">두 번째 아이템</li>
        <li style="color:green">세 번째 아이템</li>
    </ul>
</p>

render(vdom, document.querySelector('#root'));
