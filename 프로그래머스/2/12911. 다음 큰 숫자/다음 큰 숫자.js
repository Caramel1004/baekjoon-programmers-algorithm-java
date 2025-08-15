const solution = n => {
    const { bitOnesCount , bitSize } = countBits(n)
    const pows = [1 << (bitSize - 1)]
    let operand = n % (1 << (bitSize - 1))
    while (operand != 0) {
        const size = countBits(operand).bitSize
        const highestPowerOfTwo = 1 << (size - 1)
        pows.push(highestPowerOfTwo)
        operand %= (highestPowerOfTwo)
    }
    const nextPows = [...pows]
    for (let idx = nextPows.length - 1; idx > 0; idx--) {
        // n번째 비트가 왼쪽으로 쉬프트가 가능한 경우
        if (nextPows[idx - 1] != nextPows[idx] << 1) {
            nextPows[idx] <<= 1;
            let remainedOnesCount = bitOnesCount - (idx + 1);
            let currentBit = 1;
            // 맨 오른쪽 비트부터 순차적으로 1 채우기
            for (let i = nextPows.length - 1; remainedOnesCount > 0; i--) {
                nextPows[i] = currentBit;
                currentBit <<= 1;
                remainedOnesCount--;
            }
            break;
        }
        // 인덱스 1번째 요소도 왼쪽 쉬프트가 불가능한 경우
        if(idx == 1) {
            // 0번째 요소 왼쪽 쉬프트
            nextPows[idx - 1] <<= 1;
            let remainedOnesCount = bitOnesCount - idx;
            let currentBit = 1;
            // 맨 오른쪽부터 순차적으로 1채우기
            for (let i = nextPows.length - 1; remainedOnesCount > 0; i--) {
                nextPows[i] = currentBit;
                currentBit <<= 1;
                remainedOnesCount--;
            }
        }
    }
    return nextPows.reduce((acc, cur) => acc + cur, 0)
}

const countBits = num => {
    let bitOnesCount = 0;
    let bitZerosCount = 0;
    if (num === 0) {
        bitZerosCount = 1;
    }
    while (num !== 0) {
        if (num & 1) bitOnesCount++;
        else bitZerosCount++;
        num >>= 1;
    }

    return { bitOnesCount, bitZerosCount, bitSize: bitOnesCount + bitZerosCount };
}