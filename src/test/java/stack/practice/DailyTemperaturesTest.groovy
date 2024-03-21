package stack.practice

import spock.lang.Specification

class DailyTemperaturesTest extends Specification {
    def "DailyTemperatures"() {
        given:
        def dt = new DailyTemperatures()
        def array = [89,62,70,58,47,47,46,76,100,70] as int[]

        expect:
        dt.dailyTemperatures(array) == [8,1,5,4,3,2,1,1,0,0] as int[]
    }
}
