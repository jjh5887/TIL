function createStore() {
    let state;
    let handlers = [];

    function send(action) {
        state = worker(state, action);
        handlers.forEach(handler => handler());
    }

    function subscribe(handler) {
        handlers.push(handler);
    }

    function getState() {
        return state;
    }

    return {
        send,
        getState,
        subscribe,
    };
}

// 상태를 바꾸는 함수는 반드시 새로운 상태를 반환해라 (참조를 끊어서 무결성을 확보)
function worker(state = { count: 0 }, action) {
    // do something
    // 특별한 로직은 아니고 Redux 자체 룰
    switch (action.type) {
        case 'increase':
            return { ...state, count: state.count + 1 };
        default:
            return { ...state };
    }
}

const store = createStore(worker);

store.subscribe(function () {
    console.log(store.getState());
})

store.send({ type: 'increase' });
store.send({ type: 'increase' });
store.send({ type: 'increase' });
