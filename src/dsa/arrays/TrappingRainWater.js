const {performance} = require("perf_hooks");

const findTrappingRainWaterOptimized = (nums) => {
    let n = nums.length;
    if (n < 2) return 0;
    let waterSize = 0;

    const left = new Array(n);
    left[0] = nums[0];
    for (let i = 1; i < n; i++) left[i] = Math.max(nums[i], left[i - 1]);

    const right = new Array(n);
    right[n - 1] = nums[n - 1];
    for (let i = n - 2; i >= 0; i--) right[i] = Math.max(nums[i], right[i + 1]);

    for (let i = 0; i < n; i++) waterSize += (Math.min(left[i], right[i]) - nums[i]);
    return waterSize;
}

const nums = [4, 2, 0, 3, 2, 5]
const start = performance.now();
const result = findTrappingRainWaterOptimized(nums);
const end = performance.now();
console.log(`findTrappingRainWaterOptimized: ${result} - Execution in: ${(end - start).toFixed(6)} ms`);