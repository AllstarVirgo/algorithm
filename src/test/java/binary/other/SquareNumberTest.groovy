package binary.other

import spock.lang.Specification

class SquareNumberTest extends Specification {

    def "square"(){
        given:
        def squareNumber = new SquareNumber()

        expect:
        squareNumber.squareNumber(8) == 2
    }
}
