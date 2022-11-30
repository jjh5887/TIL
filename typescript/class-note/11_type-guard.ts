// 형변환 느낌?
interface Developer {
    name: string;
    skill: string;
}

interface Person {
    name: string;
    age: number;
}

function introduce(): Developer | Person {
    return {name: 'Tony', age: 33, skill: 'Iron Making'};
}

let tony = introduce();
console.log(tony.name);
// console.log(tony.skill);

// 나쁜 예
if ((tony as Developer).skill) {
    let skill = (tony as Developer).skill;
    console.log(skill);
} else if ((tony as Person).age) {
    let age = (tony as Person).age;
    console.log(age);
}

// 타입 가드 정의
function isDeveloper(target: Developer | Person): target is Developer {
    return (target as Developer).skill !== undefined;
}

// 유니온 그외 나머지 타입으로 자동 형변환
if (isDeveloper(tony)) {
    console.log(tony.skill);
} else {
    console.log(tony.age);
}