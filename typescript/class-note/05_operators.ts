function logMessage(vale: any) {
    console.log(vale);
}

logMessage('hello');
logMessage(100);

// 유니온 타입
let seho: string | number | boolean;

function logMessage2(value: string | number) {
    if (typeof value === 'number') {
        value.toLocaleString();
    }
    if (typeof value === 'string') {
        value.toString();
    }

    throw new TypeError('value must be string or number');
}

logMessage2('hello');
logMessage2(100);

interface Developer {
    name: string;
    skill: string;
}

interface Person {
    name: string;
    age: number;
}

function askSomeone(someone: Developer | Person) {
    someone.name;
    // 보장된(공통) 속성만 제공
    // someone.skill
    // someone.age
}

// 인터섹션 타입
let seho2: string | number | boolean;
let capt: string & number & boolean; // never

function askSomeone2(someone: Developer & Person) {
    someone.name;
    someone.skill;
    someone.age
}