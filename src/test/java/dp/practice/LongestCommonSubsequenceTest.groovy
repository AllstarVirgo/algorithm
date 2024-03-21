package dp.practice

import spock.lang.Specification

class LongestCommonSubsequenceTest extends Specification {
    def "LongestCommonSubsequence"() {
        given:
        def lcs = new LongestCommonSubsequence()

        expect:
        lcs.longestCommonSubsequence("abcde", "ace") == 3
    }
}
