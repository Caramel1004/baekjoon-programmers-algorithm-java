const fs = require('fs')
const inputArr = fs.readFileSync(0).toString().trim().toString().split('\n')
    
console.log(Number(inputArr[0]) + Number(inputArr[1] - Number(inputArr[2])))
console.log(inputArr[0] + inputArr[1] - inputArr[2])