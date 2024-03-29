package dp.practice

import dp.practice.zero1bag.CanPartition
import spock.lang.Specification

class CanPartitionTest extends Specification {
    def "CanPartition"() {
        given:
        def input = [1,5,11,5] as int[]
        def canPartition = new CanPartition()

        expect:
        canPartition.canPartition(input)
    }
}
