/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    let st = [];
    for (let c of [...s]) {
        if (c === '(') {
            st.push(')');
        } else if (c === '{') {
            st.push('}');
        } else if (c === '[') {
            st.push(']');
        } else {
            if (!st.length || st.pop() != c) return false;
        }
    }
    return !st.length;
};
