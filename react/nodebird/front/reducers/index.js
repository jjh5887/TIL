import { HYDRATE } from "next-redux-wrapper";
import user from '../reducers/user';
import post from '../reducers/post';
import { combineReducers } from "redux";

// (이전상태, 액션) => 다음상태
const rootReducer = combineReducers({
    // index 부분은 원래 없어도 되지만 서버 사이드 렌더링(HYDRATE)를 위해서 사용
    index: (state = {}, action) => {
        switch (action.type) {
            // 지금은 그냥 넣기만
            case HYDRATE:
                console.log('HYDRATE', action);
                return { ...state, ...action.payload };
            default:
                return state;
        }
    },
    user,
    post,
});

export default rootReducer;