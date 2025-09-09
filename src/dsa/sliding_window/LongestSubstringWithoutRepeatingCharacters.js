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
    let maxLength = 0;

    let windowStart = 0;
    let windowEnd = 0;

    const map = new Map();
    for (windowEnd; windowEnd < s.length; windowEnd++) {
        let rightChar = s[windowEnd];

        if (map.has(rightChar) && map.get(rightChar) >= windowStart) {
            windowStart = map.get(rightChar) + 1;
        }

        map.set(rightChar, windowEnd);
        maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }
    return maxLength;
}

const start = performance.now();
const result = findLongestSubstringWithoutRepeatingCharactersBruteForce("abccabb");
const end = performance.now();
console.log(`findBackspaceStringCompareBruteForce: ${result} - Execution in: ${(end - start).toFixed(6)} ms`);


const start2 = performance.now();
const result2 = findLongestSubstringWithoutRepeatingCharactersOptimized("abccabb");
const end2 = performance.now();
console.log(`findLongestSubstringWithoutRepeatingCharactersOptimized: ${result2} - Execution in: ${(end2 - start2).toFixed(6)} ms`);
