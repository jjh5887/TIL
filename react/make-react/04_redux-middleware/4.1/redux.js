export const actionCreator = type => payload => ({
  type,
  payload,
});

export function createStore(reducer, middlewares = []) {
  let state;
  const handlers = [];

  function dispatch(action) {
    state = reducer(state, action);
    handlers.forEach(handler => handler());
  }

  function getState() {
    return state;
  }

  function subscribe(handler) {
    handlers.push(handler);
  }

  const store = {
    getState,
    subscribe,
    dispatch,
  };

  // Monkey patching
  let lastDispatch = dispatch;
  middlewares = Array.from(middlewares).reverse();
  middlewares.forEach(middleware => {
    lastDispatch = middleware(store)(lastDispatch);
  });

  store.dispatch = lastDispatch;

  return store;
}
