enum Shoes {
    Nike,
    Adidas
}

let myShoes = Shoes.Nike;
console.log(myShoes); // 0


enum Shoes2 {
    Nike = 10,
    Adidas
}

let myShoes2 = Shoes2.Adidas;
console.log(myShoes2); // 11

enum Shoes3 {
    Nike = '나이키',
    Adidas = '아디다스'
}

let myShoes3 = Shoes3.Nike;
console.log(myShoes3); // '나이키'

enum Answer {
    Yes = 'Y',
    No = 'N',
}

function askQuestion(answer: Answer) {
    if (answer === Answer.Yes) {
        console.log('정답입니다');
    }
    if (answer === Answer.No) {
        console.log('오답입니다');
    }
}

askQuestion(Answer.No);
// askQuestion('Yes');
