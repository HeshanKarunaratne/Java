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

const findTwoSumOptimized = (nums, target) => {
    const numMap = new Map();
    for (let p1 = 0; p1 < nums.length; p1++) {
        const numberToFind = target - nums[p1];

        if (numMap.has(numberToFind)) {
            return [numMap.get(numberToFind), p1];
        }
        numMap.set(nums[p1], p1);
    }
    return null;
}

const nums = [1, 3, 7, 9, 2, 4, 6, 5, 8, 0, 20]
const target = 28;
const start = performance.now();
const result = findTwoSumBruteForce(nums, target);
const end = performance.now();
console.log(`findTwoSumBruteForce:[${result}] - Execution in: ${(end - start).toFixed(6)} ms`);

const start2 = performance.now();
const result2 = findTwoSumOptimized(nums, target);
const end2 = performance.now();
console.log(`findTwoSumOptimized:[${result}] - Execution in: ${(end2 - start2).toFixed(6)} ms`);