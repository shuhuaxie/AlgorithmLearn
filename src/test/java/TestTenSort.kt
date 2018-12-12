import org.junit.Test

class TestTenSort {
    @Test
    fun testBubbleSort1() {
        TenSortAlgorithm.bubbleSort1(TenSortAlgorithm.testArr).print()
    }

    @Test
    fun testBubbleSort2() {
        TenSortAlgorithm.bubbleSort2(TenSortAlgorithm.testArr).print()
    }

    @Test
    fun testSelectionSort() {
        TenSortAlgorithm.selectionSort(TenSortAlgorithm.testArr).print()
    }

    @Test
    fun testInsertionSort() {
        TenSortAlgorithm.insertionSort(TenSortAlgorithm.testArr).print()
    }

    @Test
    fun testShellSort() {
        TenSortAlgorithm.shellSort(TenSortAlgorithm.testArr).print()
    }


}
