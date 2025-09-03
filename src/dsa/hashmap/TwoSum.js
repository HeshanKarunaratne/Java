const {performance} = require("perf_hooks");

const findTwoSumBruteForce = (nums, target) => {
    for (let p1 = 0; p1 < nums.length; p1++) {
        const numberToFind = target - nums[p1];
        for (let p2 = p1 + 1; p2 < nums.length; p2++) {
            if (numberToFind === nums[p2]) {
                return [p1, p2];
            }
        }
    }
    return null;
}

const start = performance.now();
const result = findTwoSumBruteForce([1, 3, 7, 9, 2], 11);
const end = performance.now();
console.log(`Result:[${result}] - Execution in: ${(end - start).toFixed(3)} ms`);