import * as ActionType from './action-type';

const InitializeState = { count: 0 };

// 상태를 바꾸는 함수는 반드시 새로운 상태를 반환해라 (참조를 끊어서 무결성을 확보)
export function reducer(state = InitializeState, action) {
    // do something
    // 특별한 로직은 아니고 Redux 자체 룰
    switch (action.type) {
        case ActionType.INCREASE:
            return { ...state, count: state.count + 1 };
        case ActionType.DECREASE:
            return { ...state, count: state.count - 1 };
        case ActionType.RESET:
            // redux는 순수하지 않은 함수를 지원하지 않음. -> 비동기 지원 X
            // 비동기는 미들웨어를 이용하여 처리
            fetch('/reset')
                .then(response => response.json())
                .then(result => {
                    if (result) {
                        return { ...state, count: 0 };
                    }
                });
        default:
            return { ...state };
    }
}