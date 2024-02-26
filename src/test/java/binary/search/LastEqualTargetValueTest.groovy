package binary.search

import spock.lang.Specification

class LastEqualTargetValueTest extends Specification {
    def "test last equal value"(){
        given:
        def array = [1, 2, 4, 4, 6] as int[]
        def firstEqual = new LastEqualTargetValue()

        expect:
        firstEqual.lastEqualTargetValue(array, 4) == 3
    }
}
