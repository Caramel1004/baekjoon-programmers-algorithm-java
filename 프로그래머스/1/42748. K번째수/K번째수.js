function solution(array, commands) {
    return firstSolution(array, commands);
}

const firstSolution = (array, commands) => commands
    .map(([startIndex, endIndex, targetIndex]) => {
        return array.slice(startIndex - 1, endIndex).sort((x, y) => x - y)[targetIndex - 1]
    });