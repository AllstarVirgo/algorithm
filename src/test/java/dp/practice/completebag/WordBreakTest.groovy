package dp.practice.completebag

import spock.lang.Specification

class WordBreakTest extends Specification {
    def "WordBreak"() {
        given:
        def wb = new WordBreak()

        expect:
        wb.wordBreak("dogs", ["dog","s","gs"])
    }
}
