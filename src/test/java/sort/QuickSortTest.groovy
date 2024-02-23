package sort

import spock.lang.Specification

class QuickSortTest extends Specification {

    def "FindTopKElement"() {
        given:
        def array = [4, 5, 2, 3, 1] as int[]
        def quickSort = new QuickSort()

        expect:
        quickSort.findTopKElement(array, 5) == 5
    }
}
