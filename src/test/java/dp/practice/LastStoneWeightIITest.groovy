package dp.practice

import spock.lang.Specification

class LastStoneWeightIITest extends Specification {
    def "FindTargetSumWays"() {
        given:
        def array = [1] as int[]
        def lsw = new LastStoneWeightII()

        expect:
        lsw.findTargetSumWays(array, 1) == 2
    }
}
