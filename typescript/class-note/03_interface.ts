interface User {
    age: number;
    name: string;
}

let seho: User = {
    age: 33,
    name: '세호'
}

function getUser(user: User) {
    console.log(user);
}

const capt = {
    name: '캡틴',
    age: 100
}

getUser(capt);

// 함수의 스펙(구조)에 인터페이스 활용
interface SumFunction {
    (a: number, b: number): number;
}

let sum: SumFunction;
sum = function (a: number, b: number): number {
    return a + b;
}

// 인덱싱
interface StringArray {
    // index2든 머든 아무 상관 없음
    [index2: number]: string;
}

let arr: StringArray = ['a', 'b', 'c'];
let str: string = arr[0]; // a

// 딕셔너리
interface StringRegexDictionary {
    [key: string]: RegExp;
}

let obj: StringRegexDictionary = {
    // sth: /abc/,
    cssFile: /\.css$/,
    jsFile: /\.js$/,
}

// obj['cssFile'] = 'a';

Object.keys(obj).forEach(function (value) {

})