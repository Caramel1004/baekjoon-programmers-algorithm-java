const solution = s => {
    const arr = [...s]
    
    if(arr.length % 2 != 0) {
        return 0
    }
    
    const stack = []
    arr.forEach(str => {
        if(stack.length != 0 && stack[stack.length - 1] == str) {
            stack.pop();
        } else {
            stack.push(str);
        }
    })
    
    return stack.length == 0 ? 1 : 0;
}