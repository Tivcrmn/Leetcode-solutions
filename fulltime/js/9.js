/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
    // lazy way...
    if (x < 0) return false;
    let reverseString = (x + "").split("").reverse().join("");
    return x == reverseString;
};
