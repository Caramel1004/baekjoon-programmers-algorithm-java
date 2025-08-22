const fs = require('fs')
const inputArr = fs.readFileSync(0).toString().trim().split('\n')

const main = inputArr => {
    let [_, remainedCost] = inputArr[0].split(' ').map(Number)
    const coinValues = inputArr.slice(1).map(Number).filter(e => e <= remainedCost).sort((a, b) => b - a)
    let coinCount = 0
    coinValues.forEach(coinValue => {
        coinCount += Math.floor(remainedCost / coinValue) // 내림
        remainedCost %= coinValue
    });
    
    return coinCount
}

console.log(main(inputArr))