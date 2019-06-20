/**
 * @param {string[]} emails
 * @return {number}
 */
var numUniqueEmails = function(emails) {
    let set = new Set();
    for (let email of emails) {
        set.add(convert(email));
    }
    return set.size;
};

const convert = email => {
    let res = "";
    let [local, domain] = email.split("@");
    for (let c of [...local]) {
        if (c === '+') break;
        else if (c === '.') continue;
        else {
            res += c;
        }
    }
    res += `@${domain}`;
    return res;
}
