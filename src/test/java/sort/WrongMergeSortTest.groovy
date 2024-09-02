package sort

import spock.lang.Specification

class WrongMergeSortTest extends Specification {
    def "SortArray"() {
        given:
        def array = [-2, 3, -5] as int[]

        expect:
        new WrongMergeSort().sortArray(array) == [-5, -2, 3] as int[]
    }
}
