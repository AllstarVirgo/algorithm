package backtrace.practice

import spock.lang.Specification

class CombinationSumTest extends Specification {

    def "test sum2"(){
        given:
        def cst = new CombinationSum()

        expect:
        cst.combinationSum2V2([10,1,2,7,6,1,5] as int[], 8) == [[1,1,6],[1,2,5],[1,7],[2,6]]
    }

    def "test sum4"(){
        given:
        def smb4 = new CombinationSum()

        expect:
        smb4.combinationSum4([1,2,3] as int[], 4) == 7
        smb4.combinationSum4DP([1,2,3] as int[], 4) == 7
    }

}
