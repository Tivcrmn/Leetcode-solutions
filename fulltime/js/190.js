/**
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function(n) {
    let res = 0;
    let e = 1;
    // there is a bug for js if we use 1 << 32
    for (let i = 31; i >= 0; i--) {
        res += (1 & (n >> i)) * e;
        e *= 2;
    }
    return res;
};
