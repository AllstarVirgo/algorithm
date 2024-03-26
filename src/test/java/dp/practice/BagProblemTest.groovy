package dp.practice

import dp.practice.zero1bag.BagProblem
import spock.lang.Specification

class BagProblemTest extends Specification {
    def "TestWeightBagProblem"() {
        given:
        def bagProblem = new BagProblem()

        expect:
        bagProblem.testWeightBagProblem([1,3,4] as int[], [15,20,30] as int[], 4) == 35
        bagProblem.wightBagProblemV2([1,3,4] as int[], [15,20,30] as int[], 4) == 35
    }
}
