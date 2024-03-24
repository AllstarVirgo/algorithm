package backtrace.practice

import spock.lang.Specification

class NQueensTest extends Specification {
    def "SolveNQueens"() {
        given:
        def nQ = new NQueens()
        expect:
        nQ.solveNQueens(n) == output

        where:
        n || output
//        1 || [["Q"]]
        4 || [[".Q..", "...Q", "Q...", "..Q."], ["..Q.", "Q...", "...Q", ".Q.."]]
    }
}
