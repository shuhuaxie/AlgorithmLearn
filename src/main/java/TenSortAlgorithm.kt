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


    private fun merge(headArr: IntArray, tailArr: IntArray): IntArray {

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

    // 快速排序
    fun quickSort(arr: IntArray): IntArray {
        if (arr.size < 2)
            return arr
        var leftArr = ArrayList<Int>()
        var rightArr = ArrayList<Int>()
        for (index in 1 until arr.size) {
            if (arr[index] > arr[0]) {
                rightArr.add(arr[index])
            } else {
                leftArr.add(arr[index])
            }
        }

        return mergeOfQuick(quickSort(leftArr.toIntArray()), quickSort(rightArr.toIntArray()), arr[0])
    }

    private fun mergeOfQuick(leftArr: IntArray, rightArr: IntArray, middle: Int): IntArray {

        var arr = IntArray(leftArr.size + rightArr.size + 1)
        for (index in 0 until leftArr.size) {
            arr[index] = leftArr[index]
        }
        arr[leftArr.size] = middle
        for (index in 0 until rightArr.size) {
            arr[leftArr.size + index + 1] = rightArr[index]
        }
        return arr
    }

    // 堆排序
    fun heapSort(arr: IntArray): IntArray {
        var len = arr.size
        buildMaxHeap(arr)
        for (i in 0 until arr.size) {
            swapItem(arr, 0, len - 1)
            len--
            rebuild(arr, 0, len)
        }
        return arr
    }

    private fun buildMaxHeap(arr: IntArray) {
        for (i in arr.size / 2 downTo 0) {
            rebuild(arr, i, arr.size)
        }
    }

    private fun rebuild(arr: IntArray, startIndex: Int, len: Int) {
        var root = startIndex
        var left = startIndex * 2 + 1
        var right = startIndex * 2 + 2


        if (left < len && arr[left] > arr[root]) {
            when {
                right >= len -> {
                    swapItem(arr, startIndex, left)
                    rebuild(arr, left, len)
                }
                arr[left] > arr[right] -> {
                    swapItem(arr, startIndex, left)
                    rebuild(arr, left, len)
                }
                else -> {
                    swapItem(arr, startIndex, right)
                    rebuild(arr, right, len)
                }
            }
        } else if (right < len && arr[right] > arr[root]) {
            swapItem(arr, startIndex, right)
            rebuild(arr, right, len)
        }


    }

    private fun swapItem(arr: IntArray, firstNum: Int, second: Int) {
        var temp = arr[firstNum]
        arr[firstNum] = arr[second]
        arr[second] = temp
    }

    // 计数排序
    fun countSort(arr: IntArray): IntArray {
        var assembleArr = Array<ArrayList<Int>>(100) {ArrayList()}
        for (i in 0 until arr.size) {
            assembleArr[arr[i]].add(arr[i])
        }
        var index = 0
        for (i in 0 until assembleArr.size) {
            if (assembleArr[i] != null) {
                for (j in 0 until assembleArr[i].size) {
                    arr[index] = assembleArr[i][j]
                    index++
                }
            }
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
