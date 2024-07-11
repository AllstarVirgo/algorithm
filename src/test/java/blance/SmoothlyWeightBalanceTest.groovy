package blance

import spock.lang.Specification

class SmoothlyWeightBalanceTest extends Specification {
    def "Pick"() {
        given:
        def weights = [3, 1, 1, 1] as int[]
        def smoothlyWeightBalance = new SmoothlyWeightBalance(weights)

        def totalPickCount = 300
        def index2Count = [0: 0, 1: 0, 2: 0, 3: 0]

        for (i in 0..<totalPickCount) {
            def pickedIndex = smoothlyWeightBalance.pick()
            index2Count[pickedIndex] = index2Count[pickedIndex]  + 1;
        }

        expect:
        index2Count[0] == 150
        index2Count[1] == 50
        index2Count[2] == 50
        index2Count[3] == 50
    }
}
