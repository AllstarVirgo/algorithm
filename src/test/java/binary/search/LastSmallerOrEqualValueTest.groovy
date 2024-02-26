package binary.search

import spock.lang.Specification

class LastSmallerOrEqualValueTest extends Specification {

    def "LastSmallerOrEqualValue"() {
        given:
        def array = [3,4,6,7,10] as int[]
        def lastSmallerOrEqualValue = new LastSmallerOrEqualValue()

        expect:
        lastSmallerOrEqualValue.lastSmallerOrEqualValue(array, 5) == 1
    }
}
