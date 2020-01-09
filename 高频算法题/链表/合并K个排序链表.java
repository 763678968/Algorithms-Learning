class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // 将各条链表的头节点存入list中
        List<ListNode> list = Arrays.asList(lists);
        return mergeKLists(list);
    }

    private ListNode mergeKLists(List<ListNode> list) {
        // 如果list中没有链表，则返回null
        if (list.size()==0) return null;
        // 如果list中只有一条链表，则直接返回这条链表
        if (list.size()==1) return list.get(0);
        // 如果list中有两条链表，则执行合并两条有序链表的常规操作
        if (list.size()==2) return mergeTwoLists(list.get(0), list.get(1));
        // 递归地将K条链表划分成前K/2和后K/2两部分，然后对这两部分进行合并
        return mergeTwoLists(mergeKLists(list.subList(0, list.size()/2)),
                mergeKLists(list.subList(list.size()/2, list.size())));
    }

    // 以下代码来自LeetCode 21.合并两个有序链表
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
        cur.next = l1 == null ? l2 : l1;
        return res.next;
    }
}