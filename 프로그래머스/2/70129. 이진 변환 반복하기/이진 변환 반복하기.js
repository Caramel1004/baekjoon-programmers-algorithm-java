const solution = s => {
    let removedZerosCount = 0
    let trialCount = 0
    let keyword = s
    while(keyword !== '1') {
        const strs = [...keyword]
        removedZerosCount += strs.filter(s => s === '0').length
        keyword = strs.filter(s => s === '1').length.toString(2)
        trialCount++
    }
    return [trialCount, removedZerosCount]
}