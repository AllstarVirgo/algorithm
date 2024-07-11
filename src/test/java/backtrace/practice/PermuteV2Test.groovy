package backtrace.practice

import spock.lang.Specification

class PermuteV2Test extends Specification {
    def "Permute"() {
        given:
        def array = [1,2,3] as int[]
        def permuteV2 = new PermuteV2()
        def res = permuteV2.permute(array)
        println(res)
    }
}
