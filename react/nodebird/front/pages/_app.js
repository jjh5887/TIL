import React from "react";
import PropTypes from "prop-types";
import Head from "next/head";
import wrapper from "../store/configureStore";

const App = ({ Component }) => {
    return (
        // Next를 안쓰면 필요하지만 Next에선 필요없음(알아서 넣어줌)
        // <Provider store={}></Provider>
        <>
            <Head>
                <meta charSet="utf-8"/>
                <title>
                    NodeBird
                </title>
            </Head>
            <Component/>
        </>
    )
};

App.prototype = {
    Component: PropTypes.elementType.isRequired,
}

export default wrapper.withRedux(App);