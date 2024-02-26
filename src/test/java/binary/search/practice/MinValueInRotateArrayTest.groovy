package binary.search.practice

import spock.lang.Specification

class MinValueInRotateArrayTest extends Specification {
    def "MinValueInRotateArray"() {
        given:
        def nums = [3,1,2] as int[]
        def minValueInRotateArray = new MinValueInRotateArray()

        expect:
        minValueInRotateArray.minValueInRotateArraySimplerVersion(nums) == 1
    }
}
