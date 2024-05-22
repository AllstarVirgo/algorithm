package tree.practice

import spock.lang.Specification

class BuildTreeTest extends Specification {
    def "BuildTree"() {
        given:
        def inorder = [9, 3, 15, 20, 7] as int[]
        def postorder = [9, 15, 7, 20, 3] as int[]
        def builder = new BuildTree()

        expect:
        builder.buildTree(inorder, postorder).val == 3
    }
}
