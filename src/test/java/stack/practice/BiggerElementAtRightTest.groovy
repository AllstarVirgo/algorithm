package stack.practice

import spock.lang.Specification

class BiggerElementAtRightTest extends Specification {
    def "biggerElementAtRight"() {
        given:
        def bear = new BiggerElementAtRight()

        expect:
        bear.biggerElementAtRight(array) == res

        where:
        array                        || res
        [2, 6, 3, 8, 10, 9] as int[] || [6, 8, 8, 10, -1, -1] as int[]
        [2] as int[]                 || [-1] as int[]
        [] as int[]                  || [] as int[]
    }

    def "nextGreaterElements"() {
        given:
        def nextGreaterElements = new BiggerElementAtRight()

        expect:
        nextGreaterElements.nextGreaterElements(array) == res

        where:
        array || res
        [1,2,1] as int[] || [2,-1,2] as int[]
    }
}
