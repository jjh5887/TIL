import { createStore } from "./redux.js";
import { reducer } from "./reducer.js";
import * as Actions from "./actions.js";

const store = createStore(reducer);

store.subscribe(function () {
    console.log(store.getState());
})

// Currying을 하지 않으면 이용하여 increase에 payload를 넘길 수 없음
// 호출 지연을 이용한 형태
store.dispatch(Actions.increase(1));
store.dispatch(Actions.increase(1));


store.dispatch(Actions.increase());
store.dispatch(Actions.increase());
store.dispatch(Actions.increase());
store.dispatch(Actions.decrease());
store.dispatch(Actions.reset());
