fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()

    val max = 10000
    val size = br.readLine().toInt()

    val nums = IntArray(max + 1)

    nums[1] = 1
    nums[2] = 2
    nums[3] = 4

    for (i in 4..10000) {
        nums[i] = nums[i - 1] + nums[i - 2] + nums[i - 3]
    }

    repeat(size) {
        val num = br.readLine().toInt()
        sb.append(nums[num]).append("\n")
    }
    print(sb)
}