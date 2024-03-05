package heap

import spock.lang.Specification

class MergeSortedArrayTest extends Specification {

    def "mergeSortedArray method should correctly merge multiple sorted arrays into a single sorted array"() {
        given: "A MergeSortedArray instance and several sorted arrays"
        MergeSortedArray mergeSortedArray = new MergeSortedArray()
        int[][] input = [
                [1, 4, 7],
                [2, 5, 8],
                [3, 6, 9]
        ]

        when: "mergeSortedArray method is called"
        int[] result = mergeSortedArray.mergeSortedArray(input)

        then: "The result should be a single sorted array containing all elements from the input arrays"
        assert result == [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}
