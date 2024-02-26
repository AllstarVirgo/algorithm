package binary.search.practice

import spock.lang.Specification

class MinValueInRotateArrayWithSameElementTest extends Specification {
    def "FindMin"() {
        given:
        def mvIWE = new MinValueInRotateArrayWithSameElement()
//        def array = [1,3,3] as int[]

        expect:
        mvIWE.findMin(array) == res

        where:
        array                        | res
        [3, 3, 1, 3] as int[]        | 1
        [10, 1, 10, 10, 10] as int[] | 1
        [2, 0, 1, 1, 1] as int[]     | 0
    }
}
