package dp.practice.editdistance

import spock.lang.Specification

class MinDistanceTest extends Specification {
    def "MinDistance"() {
        given:
        def minDistance = new MinDistance()

        expect:
        minDistance.minDistance("sea", "eat") == 2
    }

    def "minDistanceV2"() {
        given:
        def minDistance = new MinDistance()

        expect:
//        minDistance.minDistanceV2('horse', 'ros') == 3
//        minDistance.minDistanceV2('intention', 'execution') == 5
        minDistance.minDistanceV2('e', 'execution') == 8
    }
}
