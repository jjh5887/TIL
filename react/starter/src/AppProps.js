import React, {Component, Fragment} from 'react';
import MyName from './MyName';
import MyName2 from './MyName2';

class AppProps extends Component {
    render() {
        return (
            <Fragment>
                <MyName name="리액트" />
                <MyName2 name="리액트" />
            </Fragment>

        );
    }
}