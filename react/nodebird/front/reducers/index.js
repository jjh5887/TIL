import { HYDRATE } from "next-redux-wrapper";

const initState = {
    user: {
        isLoggedIn: false,
        user: null,
        signUpData: {},
        loginData: {},
    },
    post: {
        mainPosts: [],
    },
};

export const loginAction = (data) => {
    return {
        type: 'LOG_IN',
        data,
    }
}
export const logoutAction = () => {
    return {
        type: 'LOG_OUT',
    }
}

// (이전상태, 액션) => 다음상태
const rootReducer = (state = initState, action) => {
    switch (action.type) {
        // 지금은 그냥 넣기만
        case HYDRATE:
            console.log('HYDRATE', action);
            return { ...state, ...action.payload };
        case 'LOG_IN':
            return {
                ...state,
                user: {
                    ...state.user,
                    isLoggedIn: true,
                    user: action.data,
                },
            };
        case 'LOG_OUT':
            return {
                ...state,
                user: {
                    ...state.user,
                    isLoggedIn: false,
                    user: null,
                },
            }
        default:
            return state;
    }
}

export default rootReducer;