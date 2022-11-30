// 멤버나 필드들의 범위가 더 크면 작은것들 호환 가능
// 인터페이스
interface Developer {
    name: string;
    skill: string;
}

interface Person {
    name: string;
}

class Person2 {
    name: string;
}

let developer: Developer;
let person: Person;

// 불가능
// developer = person;
// developer = new Person2();

// 가능
person = developer;


// 함수
let add = function (a: number) {
    // console.log(a);
}

let sum = function (a: number, b: number) {
    // return a + b;
}

// 불가능
// add = sum;
sum = add;


// 제네릭
interface Empty<T> {

}

let empty1: Empty<string>;
let empty2: Empty<number>;
// 가능
empty2 = empty1;
empty1 = empty2;


interface NotEmpty<T> {
    data: T;
}

let notEmpty1: NotEmpty<string>;
let notEmpty2: NotEmpty<number>;
// 불가능
// notEmpty2 = notEmpty1;
// notEmpty1 = notEmpty2;



