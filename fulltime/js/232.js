/**
 * Initialize your data structure here.
 */
var MyQueue = function() {
    this.st1 = [];
    this.st2 = [];
};

/**
 * Push element x to the back of queue.
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function(x) {
    while (this.st2.length) this.st1.push(this.st2.pop());
    this.st1.push(x);
};

/**
 * Removes the element from in front of queue and returns that element.
 * @return {number}
 */
MyQueue.prototype.pop = function() {
    while (this.st1.length) this.st2.push(this.st1.pop());
    return this.st2.pop();
};

/**
 * Get the front element.
 * @return {number}
 */
MyQueue.prototype.peek = function() {
    while (this.st1.length) this.st2.push(this.st1.pop());
    return this.st2[this.st2.length - 1];
};

/**
 * Returns whether the queue is empty.
 * @return {boolean}
 */
MyQueue.prototype.empty = function() {
    return !this.st1.length && !this.st2.length;
};
