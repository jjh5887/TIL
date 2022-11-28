function logText(text: any) {
    console.log(text);
    return text;
}

logText(10); // 숫자 10
logText('하이'); // 문자열 하이
logText(true); // 진위값

function logText2<T>(text: T): T {
    console.log(text);
    return text;
}

logText2<string>('10');

function logText3<T>(text: T[]): T[] {
    console.log(text.length);
    text.forEach(function (text) {
        console.log(text);
    })
    return text;
}
logText3<string>(['hi', 'abc']);

interface LengthType {
    length: number;
}

function logTextLength<T extends LengthType>(text: T): T {
    text.length;
    return text;
}

// .length 가 있음
logTextLength('a');
// .length 가 없음
// logTextLength(10);
logTextLength({length: 10});
