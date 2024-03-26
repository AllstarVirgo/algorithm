package dp.practice.completebag

import spock.lang.Specification

class NumSquaresTest extends Specification {
    def "NumSquares"() {
        given:
        def ns = new NumSquares()

        expect:
        ns.numSquares(4) == 1
    }
}
