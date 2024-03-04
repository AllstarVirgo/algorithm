package tree

import spock.lang.Specification

class BinarySearchTreeTest extends Specification {
    def "测试插入和查找功能"() {
        given: "一个空的二叉搜索树"
        def bst = new BinarySearchTree()

        when: "向树中插入元素"
        bst.insert(5)
        bst.insert(2)
        bst.insert(8)
        bst.insert(1)
        bst.insert(3)

        then: "可以找到这些元素"
        bst.find(5).val == 5
        bst.find(2).val == 2
        bst.find(8).val == 8
        bst.find(1).val == 1
        bst.find(3).val == 3
        bst.find(10) == null
    }

    def "测试删除功能"() {
        given: "一个已填充的二叉搜索树"
        def bst = new BinarySearchTree()
        bst.insert(5)
        bst.insert(2)
        bst.insert(8)
        bst.insert(1)
        bst.insert(3)

        when: "从树中删除元素"
        bst.delete(2)

        then: "该元素不应该被找到"
        bst.find(2) == null

        and: "其他元素仍然可以被找到"
        bst.find(5).val == 5
        bst.find(8).val == 8
        bst.find(1).val == 1
        bst.find(3).val == 3

        when: "删除根节点"
        bst.delete(5)

        then: "根节点被正确替换"
        bst.find(5) == null
        bst.find(8).val == 8 // 假设8成为了新的根节点或其他逻辑，这需要根据实际的delete实现来调整
    }
}
