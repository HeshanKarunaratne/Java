const {performance} = require("perf_hooks");

const findContainerWithMostWaterOptimized = (nums) => {
    if (nums.length < 2) return 0;
    let maxArea = 0;

    let p1 = 0;
    let p2 = nums.length - 1;

    while (p1 < p2) {
        maxArea = Math.max(maxArea, Math.min(nums[p1], nums[p2]) * (p2 - p1));
        if (nums[p1] <= nums[p2]) p1++; else p2--;
    }
    return maxArea;
}

const nums = [1, 8, 6, 2, 9, 4]
const start = performance.now();
const result = findContainerWithMostWaterOptimized(nums);
const end = performance.now();
console.log(`findContainerWithMostWaterBruteForce: ${result} - Execution in: ${(end - start).toFixed(6)} ms`);