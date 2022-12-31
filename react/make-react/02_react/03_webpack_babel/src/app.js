import { render } from './react';

const vdom = {
    tag: 'p',
    props: {},
    children: [
        {
            tag: 'h1',
            props: {},
            children: ["React 만들기"],
        },
        {
            tag: 'ul',
            props: {},
            children: [
                {
                    tag: 'li',
                    props: {
                        style: 'color:red',
                    },
                    children: ['첫번째 아이템']
                },
                {
                    tag: 'li',
                    props: {
                        style: 'color:blue',
                    },
                    children: ['두번째 아이템']
                },
                {
                    tag: 'li',
                    props: {
                        style: 'color:green',
                    },
                    children: ['세번째 아이템']
                }
            ],
        }
    ],
}

render(vdom, document.querySelector('#root'));
