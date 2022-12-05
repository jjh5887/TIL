import React, {Component, Fragment} from 'react';
import './App.css';

class App extends Component {
    render() {
        const name = 'react';
        const value = 2;

        const style = {
            backgroundColor: 'black',
            padding: '16px',
            color: 'white',
            fontSize: 5 + 10 + 'px'
        }

        return (
            <Fragment>
                <div>hello {name}</div>
                <div>hello2</div>
                <div>
                    {
                        name === 'react' && <div> 리액트 </div>
                    }
                </div>

                {
                    (() => function () {
                        if (value === 1) return <div> 1이다! </div>
                        if (value === 2) return <div> 2이다! </div>
                        if (value === 3) return <div> 3이다! </div>
                        return <div>없다</div>
                    })()
                }

                <div style={style}>
                    안녕하세요!
                </div>

                <div className="App">
                    안녕하세요!
                </div>

                {/* 주석 작성 법*/}
                <div something="asdasdsd" // 주석 작성법 2
                >
                    주석 테스트
                </div>
            </Fragment>
        );
    }
}