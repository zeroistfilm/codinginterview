
// 어떤 문자가 오는거지
// map을 사용하고 싶지만, 배열 챕터니까 배열을 써보자
// 0-9a-zA-Z로 가정하고  
// 1. 62(10 + 26*2 = 62이므로) 짜리 배열을 만든다.
// 2. 문자열 순회하면서 해당하는 인덱스에 숫자 올린다
// 3. 이전꺼가 0보다 컸으면 바로 true 리턴
// 0-9a-zA-Z로 가정하면 if문 겁나 써야함 아스키로 가자
// 그러면 0으로 채워진 128크기 배열 만들고 하면 됨 

function check(str) {
    const array = new Array(128).fill(false);
    let flag = false;
    for (let i = 0 ; i<str.length ; i++) {
        const code = str.charCodeAt(i);
        if (array[code]) {
            flag = true;
            break;
        }
        array[code] = true;
    }
    return flag;
}

console.log(check('abcdef'));
console.log(check('abcdefa'));
console.log(check('tomato'));
console.log(check('target'));
