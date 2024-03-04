package linkedlist

import spock.lang.Specification

class ReversedByKTest extends Specification {
    def "ReverseKGroup"() {
        given:
        def head = new ListNode(1);
        def p1 = new ListNode(2);
        def p2 = new ListNode(3);
        def p3 = new ListNode(4);
        def p4 = new ListNode(5);

        head.next = p1
        p1.next = p2
        p2.next = p3
        p3.next = p4

        def reversedByK = new ReversedByK()

        def res = reversedByK.reverseKGroup(head, 3)
        def cur = res

        expect:
        cur.val == 3;
        cur.next.val == 2;
        cur.next.next.val == 1
        cur.next.next.next.val == 4
        cur.next.next.next.next.val == 5
    }
}
