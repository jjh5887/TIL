// 타입 단언: 내가 TS보다 타입 더 잘안다!
// 개인적인 생각으로는 쓰면 안될것 같음

let a;
a = 20;
a = 'a';

let b = a as string;

// DOM API 조작
// <div id="app">hi</div>

// div 가 null 일 수 있음
let div = document.querySelector('div');
// null 체크 필요 (여기에선 안그럼)
if (div) {
    div.innerText
}

let div2 = document.querySelector('div') as HTMLDivElement;
// null 체크 불필요
div2.innerText;