package tree.practice

import spock.lang.Specification
import tree.TravelTreeNode
import tree.TreeNode

class TreeLCPracticeTest extends Specification {

    def "test travel tree node"() {
        given:
        def root = new TreeNode(1)
        def r = new TreeNode(2)
        def rR = new TreeNode(3)
        def rL = new TreeNode(4)

        def l = new TreeNode(5)
        def lL = new TreeNode(6)
        def lR = new TreeNode(7)

        root.right = r
        r.right = rR
        r.left = rL

        root.left = l
        l.left = lL
        l.right = lR

        def ttn = new TravelTreeNode()
        def res = []
        ttn.specialTravel(root, res)

        expect:
        res == [1, 2, 3, 4, 5, 7, 6]
    }
}
