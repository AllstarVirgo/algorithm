package sort

import spock.lang.Specification

class SelectionSortTest extends Specification {

    def "Sort"() {
        given:
        def array = [4, 2, 3, 1, 6] as int[]
        def selectSort = new QuickSort()
        selectSort.sort(array)

        expect:
        array == [1, 2, 3, 4, 6] as int[]
    }

    def "random sort"() {
        given:
        def random = new Random();
        def sorts = [new InsertSort(), new BubbleSort(), new SelectSort(), new MergeSort(), new QuickSort()]
        def arrayList = []
        for (i in 0..<1000) {
            def length = random.nextInt(1000)
            def array = new int[length]
            for (j in 0..<array.length) {
                array[j] = random.nextInt(1000)
            }
            arrayList.add(array)
        }

        expect:
        for (sort in sorts) {
            for (ele in arrayList) {
                def copy = Arrays.copyOf(ele, ele.length)
                sort.sort(ele)
                Arrays.sort(copy)
                assert ele == copy
            }
        }
    }
}
