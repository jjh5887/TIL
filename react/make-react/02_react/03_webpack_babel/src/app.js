import { render, createElement } from './react';

const vdom2 = createElement('p', {},
    createElement('h1', {}, 'react 만들기'),
    createElement('ul', {},
        createElement('li', {style: 'color:red'}, '첫번째 아이템'),
        createElement('li', {style: 'color:blue'}, '두번째 아이템'),
        createElement('li', {style: 'color:green'}, '세번째 아이템'),
        )
    );

console.log(vdom2);

render(vdom2, document.querySelector('#root'));
