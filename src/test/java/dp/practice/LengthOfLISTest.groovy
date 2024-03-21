package dp.practice

import spock.lang.Specification

class LengthOfLISTest extends Specification {
    def "LengthOfLIS"() {
        given:
        def lis = new LengthOfLIS();

        expect:
        lis.lengthOfLIS(array) == res

        where:
        array                                 || res
        [10, 9, 2, 5, 3, 7, 101, 18] as int[] || 4
    }

    def "lenLongestFibSubseq"(){
        given:
        def input = [1,2,3,4,5,6,7,8] as int[]
        def lis = new LengthOfLIS();

        expect:
        lis.lenLongestFibSubseqDP(input) == 5
    }
}
