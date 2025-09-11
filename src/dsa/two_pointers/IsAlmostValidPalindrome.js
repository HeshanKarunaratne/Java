const {performance} = require("perf_hooks");

const findIsAlmostValidPalindrome = (str) => {
    str = str.toLowerCase().replace(/[^a-z0-9]/gi, '');
    let left = 0;
    let right = str.length - 1;

    while (left < right) {
        if (str[left] !== str[right]) {
            return findIsAlmostValidPalindrome(str.substring(left + 1, right + 1)) || findIsAlmostValidPalindrome(str.substring(left, right));
        }
        left++;
        right--;
    }
    return true;
}

const str = "abccdba";
const start = performance.now();
const result = findIsAlmostValidPalindrome(str);
const end = performance.now();
console.log(`findIsAlmostValidPalindrome: ${result} - Execution in: ${(end - start).toFixed(6)} ms`);