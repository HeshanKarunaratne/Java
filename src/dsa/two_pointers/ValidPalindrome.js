const {performance} = require("perf_hooks");

const findValidPalindrome = (str) => {
    str = str.toLowerCase().replace(/[^a-z0-9]/gi, '');
    let left = 0;
    let right = str.length - 1;

    while (left < right) {
        if (str[left] !== str[right]) return false;

        left++;
        right--;
    }
    return true;
}

const str = "A man, a plan, a canal: Panama";
const start = performance.now();
const result = findValidPalindrome(str);
const end = performance.now();
console.log(`findValidPalindrome: ${result} - Execution in: ${(end - start).toFixed(6)} ms`);