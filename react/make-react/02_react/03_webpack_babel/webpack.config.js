// nodeJS 가 제공하는 안전한 경로
const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin')

module.exports = {
    mode: 'development',
    entry: './src/app.js', // 입력 (어떤 js에서 시작할거야)
    output: {
        path: path.resolve(__dirname, 'dist'),
        filename: 'bundle.js'
    },

    devServer: {
        compress: true,
        port: 9999,
    },
    module: {
        // loader 들
        rules: [
            {
                test: /\.js$/, // 해당 정규식 파일만 loader 에게
                exclude: /node_modules/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: ['@babel/preset-env', '@babel/preset-react']
                    }
                }
            }
        ]
    },
    plugins: [
        new HtmlWebpackPlugin({
            title: '2.3 setup webpack & babel',
            template: 'index.html',
        })
    ]
}