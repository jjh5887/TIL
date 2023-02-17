export class Component {
    constructor(props) {
        this.props = props;
    }
}

export function createDOM(node) {
    if (typeof node === 'string') {
        return document.createTextNode(node);
    }
    const element = document.createElement(node.tag);

    Object.entries(node.props)
        .forEach(([ name, value ]) => element.setAttribute(name, value));

    node.children
        .map(createDOM)
        // bind를 해주지 않으면 Context 깨짐
        .forEach(element.appendChild.bind(element));

    return element;
}

export function render(vdom, container) {
    container.appendChild(createDOM(vdom));
}

function makeProps(props, children) {
    return {
        ...props,
        children: children.length === 1 ? children[0] : children,
    }
}

export function createElement(tag, props, ...children) {
    props = props || {};

    if (typeof tag === 'function') {
        // 실제 리액트는 Symbol을 이용해서 클래스 컴포넌트를 체크함
        if (tag.prototype instanceof Component) {
            // 클래스 컴포넌트 vs 함수 컴포넌트
            // 클래스 컴포넌트는 렌더링이 될 때마다 new를 해서 인스턴스를 새로 만들지 않고 render()만 호출하여 상태를 유지 (이 코드에선 안함)
            // 또 라이프 사이클을 이용하여 원하는 시점에 작업을 할 수 있음
            // 함수는 이런 상태를 가질 수 없지만 요즘은 Hook을 이용하여 다 가능해짐
            const instance = new tag(makeProps(props, children));
            return instance.render();
        } else {
            if (children.length > 0) {
                return tag(makeProps(props, children));
            } else {
                return tag(props);
            }
        }
    } else {
        return { tag, props, children, };
    }
}