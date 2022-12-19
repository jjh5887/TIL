import React from "react";
import AppLayout from "../components/AppLayout";

const Home = () => {
    return (
        // 아래 방식처럼 통으로 넘길 수 있음
        <AppLayout>
            <div>Hello, Next!</div>
        </AppLayout>
    );
}
export default Home;
