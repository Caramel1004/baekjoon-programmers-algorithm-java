const solution = n => {
    // int -> String -> String[] -> int
    return n.toString().split('').reduce((sum, v) => sum + parseInt(v), 0);
}