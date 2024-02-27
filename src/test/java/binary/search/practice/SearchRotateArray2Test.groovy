package binary.search.practice

import spock.lang.Specification

class SearchRotateArray2Test extends Specification {
    def "Search"() {
        given:
        def sra2 = new SearchRotateArray2()
        def input = [1,3] as int[]

        expect:
        sra2.search(input, 3)

    }
}
