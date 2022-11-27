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