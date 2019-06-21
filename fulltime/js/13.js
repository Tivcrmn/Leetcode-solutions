/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function(s) {
    let res = 0;
    let chars = [...s];
    res += convert(chars[0]);
    for (let i = 1; i < chars.length; i++) {
        let curNum = convert(chars[i]);
        let preNum = convert(chars[i - 1]);
        if (curNum > preNum) {
            res = res - 2 * preNum + curNum;
        } else {
            res += curNum;
        }
    }
    return res;
};

const convert = c => {
    let res = 0;
    switch(c) {
        case 'I': return 1;
        case 'V': return 5;
        case 'X': return 10;
        case 'L': return 50;
        case 'C': return 100;
        case 'D': return 500;
        case 'M': return 1000;
    }
    return res;
}
