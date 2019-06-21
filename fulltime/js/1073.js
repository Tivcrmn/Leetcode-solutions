/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var addNegabinary = function(arr1, arr2) {
    let p1 = arr1.length - 1, p2 = arr2.length - 1, carry = 0;
    let res = [];
    while (p1 >= 0 || p2 >= 0 || carry != 0) {
        let n1 = p1 >= 0 ? arr1[p1--] : 0;
        let n2 = p2 >= 0 ? arr2[p2--] : 0;
        let sum = n1 + n2 + carry;
        res.unshift(sum & 1);
        carry = -1 * (sum >> 1);
    }
    let index = res.findIndex(e => e !== 0);
    if (index == -1) return [0];
    return res.slice(index);
};
