object TenSortAlgorithm {
    /**
     *  参考自 @link https://www.cnblogs.com/onepixel/articles/7674659.html
     *  十大经典排序算法（动图演示）
     */

    var testArr = intArrayOf(
            3, 44, 38, 5, 47,
            15, 36, 26, 27, 2,
            46, 4, 19, 50, 48)

    // 冒泡排序 从最小的开始排
    fun bubbleSort1(arr: IntArray): IntArray {
        for (i in 0 until arr.size) {
            for (j in i + 1 until arr.size) {
                if (arr[i] > arr[j]) {
                    val temp = arr[i]
                    arr[i] = arr[j]
                    arr[j] = temp
                }
            }
        }
        return arr
    }

    // 冒泡排序 从最大的开始排
    fun bubbleSort2(arr: IntArray): IntArray {
        for (i in 0 until arr.size) {
            for (j in 0 until arr.size - i) {
                if (arr[j] > arr[j + 1]) {
                    val temp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = temp
                }
            }
        }
        return arr
    }

    // 选择排序
    fun selectionSort(arr: IntArray): IntArray {
        for (i in 0 until arr.size - 1) {
            var tempSmall = i
            for (j in i + 1 until arr.size) {
                if (arr[j] < arr[tempSmall]) {
                    tempSmall = j
                }
            }
            val temp = arr[tempSmall]
            arr[tempSmall] = arr[i]
            arr[i] = temp
        }
        return arr
    }

    // 插入排序
    fun insertionSort(arr: IntArray): IntArray {
        for (i in 1 until arr.size) {
            var startIndex = i - 1
            var tempValue = arr[i]
            while (startIndex >= 0 && arr[startIndex] > tempValue) {
                arr[startIndex + 1] = arr[startIndex]
                startIndex--
            }
            arr[startIndex + 1] = tempValue

        }
        return arr
    }


    // 希尔排序
    fun shellSort(arr: IntArray): IntArray {
        var len = 1
        while (len < arr.size / 3) {
            len = len * 3 + 1
        }
        while (len > 0) {
            for (i in len until arr.size) {
                var temp = arr[i]
                var j = i - len
                while (j > -1 && arr[j] > temp) {
                    arr[j + len] = arr[j]
                    j -= len
                }
                arr[j + len] = temp

            }
            len = Math.floorDiv(len, 3)
        }
        return arr
    }

    // 归并排序
    fun mergeSort(arr: IntArray): IntArray {
        if (arr.size == 1) {
            return arr
        }
        var rightArr = IntArray(arr.size - arr.size / 2)

        for (i in arr.size / 2 + 1..(arr.size - 1)) {
            rightArr[i - arr.size / 2 - 1] = arr[i]
        }
        var leftArr = IntArray(arr.size / 2)

        for (i in 0..arr.size / 2) {
            leftArr[i] = arr[i]
        }

        return merge(mergeSort(leftArr), mergeSort(rightArr))
    }


    fun merge(headArr: IntArray, tailArr: IntArray): IntArray {

        var arr = IntArray(headArr.size + tailArr.size)

        var headIndex = 0
        var tailIndex = 0

        while (headIndex < headArr.size || tailIndex < tailArr.size) {
            var index = 0
            if (headIndex < headArr.size && headArr[headIndex] < tailArr[tailIndex]) {
                arr[index] = headArr[headIndex]
                headIndex++
            } else {
                arr[index] = tailArr[headIndex]
                tailIndex++
            }
            index++

        }

        return arr
    }
}

fun IntArray.print() {
    for (i in 0 until size) {
        if (i != size - 1) {
            print("${this[i]},")
        } else {
            println("${this[i]}")
        }
    }
}
