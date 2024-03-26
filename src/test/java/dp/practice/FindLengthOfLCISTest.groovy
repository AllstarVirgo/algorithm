package dp.practice

import spock.lang.Specification

class FindLengthOfLCISTest extends Specification {
    def "LongestCommonSubsequence"() {
        given:
        def lcs = new FindLengthOfLCIS()

        expect:
        lcs.longestCommonSubsequence("abcde", "ace") == 3

    }
}
