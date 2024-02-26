package binary.search

import spock.lang.Specification

class RotateArrayBinarySearchTest extends Specification {
    def "Search"() {
        given:
        def rotateArray = new RotateArrayBinarySearch()
        def array = [4,5,6,7,0,1,2] as int[]

        expect:
        rotateArray.search(array, 0) == 4

    }
}
