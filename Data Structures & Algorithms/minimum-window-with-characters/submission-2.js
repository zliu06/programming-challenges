class Solution {
    /**
     * @param {string} s
     * @param {string} t
     * @return {string}
     */
    minWindow(s, t) {
        let left = 0;
        let right = 0;
        let tf = new Map();
        let wf = new Map();
        let minLen = Infinity;
        let result = "";
        for (let i = 0; i < t.length; i++) {
            tf.set(t[i], (tf.get(t[i]) ?? 0) + 1);
        }
        while (right < s.length) {
            wf.set(s[right], (wf.get(s[right]) ?? 0) + 1);
            // add logic that wf covers tf check later
            let covered = true;
            for (let ch of tf.keys()) {
                let c = wf.get(ch) ?? 0;
                if (tf.get(ch) > c) {
                    covered = false;
                    break;
                }
            }
            // shrink left if we found a solution
            if (covered === true) {
                while (true) {
                    let freq = wf.get(s[left]);
                    if ((tf.get(s[left]) ?? 0) > freq - 1) {
                        wf.set(s[left], freq);
                        break;
                    } else {
                        wf.set(s[left], freq - 1);
                        left += 1;
                    }
                }
            }
            if (covered === true) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    result = s.substring(left, right + 1);
                }
            }

            // update length etc.
            right += 1;
        }
        return result;
    }
}
