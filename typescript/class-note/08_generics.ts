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

