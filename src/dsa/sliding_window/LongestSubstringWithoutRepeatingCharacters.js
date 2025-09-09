const {performance} = require("perf_hooks");

const findLongestSubstringWithoutRepeatingCharactersBruteForce = (s) => {
    if (s.length <= 1) return s.length;
    let maxLength = 0;
    for (let i = 0; i < s.length; i++) {
        const seen = new Set();
        for (let j = i; j < s.length; j++) {
            if (seen.has(s[j])) {
                break;
            }
            seen.add(s[j]);
            maxLength = Math.max(maxLength, j - i + 1)
        }
    }
    return maxLength
}

const findLongestSubstringWithoutRepeatingCharactersOptimized = (s) => {
    if (s.length <= 1) return s.length;

}

const start = performance.now();
const result = findLongestSubstringWithoutRepeatingCharactersBruteForce("abccabb");
const end = performance.now();
console.log(`findBackspaceStringCompareBruteForce: ${result} - Execution in: ${(end - start).toFixed(6)} ms`);


const start2 = performance.now();
const result2 = findLongestSubstringWithoutRepeatingCharactersOptimized("abccabb");
const end2 = performance.now();
console.log(`findLongestSubstringWithoutRepeatingCharactersOptimized: ${result2} - Execution in: ${(end2 - start2).toFixed(6)} ms`);
