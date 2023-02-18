// Currying
// Currying한 이유는 payload를 별도로 넘기기 위해서 (app.js 파일 확인)
export const actionCreator = type => payload => ({
    type,
    payload,
})

export function createStore(reducer) {
    let state;
    let handlers = [];

    function dispatch(action) {
        state = reducer(state, action);
        handlers.forEach(handler => handler());
    }

    function subscribe(handler) {
        handlers.push(handler);
    }

    function getState() {
        return state;
    }

    return {
        dispatch,
        getState,
        subscribe,
    };
}