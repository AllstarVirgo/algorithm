package hash

import spock.lang.Specification

class ConsistentHashingTest extends Specification {
    def "SearchInsert"() {
        given:
        def ch = new ConsistentHashing()

        expect:
        ch.searchInsert([1,3,5,6] as int[], 0) == 0
    }
}
