const fs = require('fs')
const inputArr = fs.readFileSync(0).toString().trim().toString().split('\n')

const max = 100
const dp = Array.from({ length: max + 1 })
        .reduce((acc, _, idx) => [
            ...acc,
            idx === 0 ? 0 : (idx > 0 && idx <= 3) ? 1 : acc[idx - 2] + acc[idx - 3]
        ], [])

const main = inputArr.slice(1)
        .map(i => dp[i])
        .join('\n')

console.log(main)