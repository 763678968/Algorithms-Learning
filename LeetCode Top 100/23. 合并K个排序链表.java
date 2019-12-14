class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> list = Arrays.asList(lists);
        return mergeKLists(list);
    }
    
    private ListNode mergeKLists(List<ListNode> list) {
        if (list.size()==0) return null;
        if (list.size()==1) return list.get(0);
        if (list.size()==2) return mergeTwoLists(list.get(0), list.get(1));
        // 将
        return mergeTwoLists(mergeKLists(list.subList(0, list.size()/2)),
                mergeKLists(list.subList(list.size()/2, list.size())));
    }

    // 以下代码来自21.合并两个有序链表
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        ListNode res = new ListNode(0);
        ListNode cur = res;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // 当其中一个链表已经合并完成后，直接将另一个链表的剩余部分接续上即可
        cur.next = l1 == null ? l2 : l1;
        return res.next;
    }
}
