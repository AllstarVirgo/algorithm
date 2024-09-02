package backtrace.practice

import spock.lang.Specification

class FactorCombinationsTest extends Specification {
    def "FactorCombinations"() {
        given:
        def fc = new FactorCombinations()

        expect:
        fc.getFactors(12) == [[2,6],[2,2,3],[3,4]]
    }
}
