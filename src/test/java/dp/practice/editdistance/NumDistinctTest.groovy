package dp.practice.editdistance

import spock.lang.Specification

class NumDistinctTest extends Specification {
    def "NumDistinct"() {
        given:
        def nd = new NumDistinct()
        expect:
        nd.numDistinct("rabbbit", "rabbit") == 3
    }
}
