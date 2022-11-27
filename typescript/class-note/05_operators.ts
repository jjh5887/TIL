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

askSomeone({name: '디벨로퍼', skill: '웹 개발'});
askSomeone({name: '캡틴', age: 100});

// 인터섹션 타입
let seho2: string | number | boolean;
let capt: string & number & boolean; // never

function askSomeone2(someone: Developer & Person) {
    someone.name;
    someone.skill;
    someone.age
}

askSomeone2({name: '캡틴', age: 100, skill: '웹 개발'});