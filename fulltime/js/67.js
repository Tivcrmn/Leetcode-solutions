/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
var addBinary = function(a, b) {
    let pa = a.length - 1, pb = b.length - 1;
    let res = "", carry = 0;
    while (pa >= 0 || pb >= 0) {
        let da = pa >= 0 ? a.charAt(pa--) - '0' : 0;
        let db = pb >= 0 ? b.charAt(pb--) - '0' : 0;
        let sum = da + db + carry;
        res = sum % 2 + res;
        carry = parseInt(sum / 2);
    }
    if (carry == 1) res = "1" + res;
    return res;
};
