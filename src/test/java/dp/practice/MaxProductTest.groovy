package dp.practice

import spock.lang.Specification

class MaxProductTest extends Specification {

    def "test max product"(){
        given:
        MaxProduct maxProduct = new MaxProduct();
        def array = [-1,-2,-9,-6] as int[]

        expect:
        maxProduct.maxProduct(array) == 108
    }
}
