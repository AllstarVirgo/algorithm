package binary.search

import spock.lang.Specification

class FirstEqualTargetValueTest extends Specification {

    def "find first equal value"() {
        given:
        def array = [1, 2, 4, 4, 6] as int[]
        def firstEqual = new FirstEqualTargetValue()

        expect:
        firstEqual.findFirstEqual(array, 4) == 2
    }
}
