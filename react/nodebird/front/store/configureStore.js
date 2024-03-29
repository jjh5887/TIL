import { createWrapper } from 'next-redux-wrapper';
import { applyMiddleware, compose, createStore } from "redux";

import reducer from '../reducers/index';
import { composeWithDevTools } from "redux-devtools-extension";


const configureStore = () => {
    const middlewares = [];
    // redux devtools용 -> 크롬 확장프로그램
    // npm i redux-devtools-extension
    const enhancer = process.env.NODE_ENV === 'production'
        ? compose(applyMiddleware(...middlewares))
        : compose(composeWithDevTools(...middlewares));
    const store = createStore(reducer, enhancer);
    return store;
};

const wrapper = createWrapper(configureStore, {
    debug: process.env.NODE_ENV === 'development',
});

export default wrapper;