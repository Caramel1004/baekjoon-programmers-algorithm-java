const solution = s => {
    let count = 0;
    const isInvalid = [...s].some(bracket => {
        if(bracket === '(') count++
        if(bracket === ')') count--
        return count < 0 // 0 아래로 떨어지면 반복 종료
    })
    return !isInvalid && count === 0
}