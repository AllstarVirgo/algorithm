package dp.practice.completebag

import spock.lang.Specification

class ChangeTest extends Specification {
    def "Change"() {
        given:
        def change = new Change()

        expect:
        change.change(5, [1,2,5] as int[]) == 4
    }

    def "Change1"() {
        given:
        def change = new Change()

        expect:
        change.coinChange([1,2,5] as int[], 11) == 3
    }
}
