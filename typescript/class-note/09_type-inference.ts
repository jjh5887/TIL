let a = 10;

function getB(b = 10) {
    let c = 'hi';
    return b + c;
}

interface Dropdown<T> {
    value: T;
    title: string;
}

interface DetailedDropdown<K> extends Dropdown<K> {
    description: string;
    tag: K;
}

let shoppingItem: Dropdown<string> = {
    value: 'abc',
    title: 'hello'
}

let detailedItem: DetailedDropdown<number> = {
    title: 'abc',
    description: 'ab',
    value: 1,
    tag: 2
}

// Best Common Type
let arr = [1, 2, true, 'a'];