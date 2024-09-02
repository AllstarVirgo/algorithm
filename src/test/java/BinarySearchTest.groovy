import spock.lang.Specification

class BinarySearchTest extends Specification {
    def "Search"() {
        given:
        def input = [1, 2, 5, 6] as int[]
        def bs = new BinarySearch()

        expect:
//        bs.search(input, 2) == 1
        bs.search(input, 3) == 2
    }
}
