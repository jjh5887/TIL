function sum(a: number, b: number): number {
    return a + b;
}

let number = sum(10, 20);

// 파리미터 제한
// sum(10, 20, 30, 40);
// sum(10);

// 함수의 옵셔널 파라미터 -> ? -> 써도되고 안써도 되고
function log(a: string, b?: string, c?: string) {

}

log('hi');
log('hi', 'bye');
log('hi', 'bye', 'hello');