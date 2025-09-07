const {performance} = require("perf_hooks");

const findBackspaceStringCompareBruteForce = (s, t) => {
    const buildCorrectString = (str) => {
        const arr = [];
        for (let char of str) {
            if (char === '#') {
                arr.pop();
            } else {
                arr.push(char);
            }
        }
        return arr.join('');
    }
    return buildCorrectString(s) === buildCorrectString(t);
}

const findBackspaceStringCompareOptimal = (s, t) => {
    // Points to the last character in each string
    let i = s.length - 1, j = t.length - 1;

    while (i >= 0 || j >= 0) {

        let skipS = 0;
        while (i >= 0) {
            if (s[i] === '#') {
                skipS++;
                i--;
            } else if (skipS > 0) {
                skipS--;
                i--;
            } else break;
        }

        let skipT = 0;
        while (j >= 0) {
            if (t[j] === '#') {
                skipT++;
                j--;
            } else if (skipT > 0) {
                skipT--;
                j--;
            } else break;
        }

        if (i >= 0 && j >= 0 && s[i] !== t[j]) return false;
        if ((i >= 0) !== (j >= 0)) return false;

        i--, j--;
    }
    return true;
}

const start = performance.now();
const result = findBackspaceStringCompareBruteForce("abcc#d", "abzz##d");
const end = performance.now();
console.log(`findBackspaceStringCompareBruteForce: ${result} - Execution in: ${(end - start).toFixed(6)} ms`);

const start2 = performance.now();
const result2 = findBackspaceStringCompareOptimal("abcc#d", "abzz##d");
const end2 = performance.now();
console.log(`findBackspaceStringCompareOptimal: ${result2} - Execution in: ${(end2 - start2).toFixed(6)} ms`);