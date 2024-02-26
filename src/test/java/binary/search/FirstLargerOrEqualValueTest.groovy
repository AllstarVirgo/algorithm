package binary.search

import spock.lang.Specification

class FirstLargerOrEqualValueTest extends Specification {
    def "FirstLargerOrEqualValue"() {
        given:
        def array = [3,4,6,7,10] as int[]
        def firstLargerOrEqual = new FirstLargerOrEqualValue()

        expect:
        firstLargerOrEqual.firstLargerOrEqualValue(array, 5) == 2
    }
}
