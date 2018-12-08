object TenSortAlgorithm {
    var testArr = intArrayOf(3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48)

    fun bubbleSort1(arr: IntArray): IntArray {
        for (i in 0 until arr.size - 1) {
            for (j in i + 1 until arr.size - 1) {
                if (arr[i] > arr[j]) {
                    val temp = arr[i]
                    arr[i] = arr[j]
                    arr[j] = temp
                }
            }
        }
        return arr
    }

}

fun IntArray.print() {
    for (i in 0 until size - 1) {
        print(if (i != 0) {
            ","
        } else {
            ""
        } + this[i].toString())
    }
}