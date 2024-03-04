package linkedlist;

import java.util.Objects;

public class ReversedByK {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (Objects.isNull(head)) {
            return head;
        }
        ListNode slow = head;
        ListNode quick = head;
        int cur = 1;
        boolean reversed = false;
        ListNode res = head;
        ListNode lastSlow = slow;
        while (quick != null) {
            quick = quick.next;
            cur++;
            if (cur == k) {
                final ListNode nextNode = Objects.nonNull(quick) ? quick.next : null;
                ListNode reversedHead;
                if (Objects.nonNull(quick)) {
                    reversedHead = reversed(slow, nextNode);
                } else {
                    reversedHead = slow;
                }
                if (!reversed) {
                    res = reversedHead;
                } else {
                    lastSlow.next = reversedHead;
                    lastSlow = slow;
                }
                slow = quick = nextNode;
                reversed = true;
                cur = 1;
            }
        }
        if (cur < k && cur != 1) {
            lastSlow.next = slow;
        }
        return res;
    }

    public ListNode reversed(ListNode start, ListNode end) {
        if (start == null || start.next == null || start.next == end) {
            return start;
        }
        final ListNode next = reversed(start.next, end);
        start.next.next = start;
        start.next = null;
        return next;
    }

    public ListNode reverseKGroupV2(ListNode head, int k) {
        ListNode slow = head;
        ListNode quick = head;
        for (int i = 0; i < k; i++) {
            if (Objects.isNull(quick)) {
                return slow;
            }
            quick = quick.next;
        }
        final ListNode newHead = reversed(slow, quick);
        slow.next = reverseKGroupV2(quick, k);
        return newHead;
    }
}
