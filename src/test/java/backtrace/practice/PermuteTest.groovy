package backtrace.practice

import spock.lang.Specification

class PermuteTest extends Specification {
    def "Permute"() {
        given:
        def array = [1,2,3] as int[]
        def permute = new Permute()
        def res  = permute.permute(array)
        println(res)
    }
}
