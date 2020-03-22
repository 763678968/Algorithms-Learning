class Solution {
    public ListNode deleteDuplication(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        // 如果cur不为空（包括1.链表为空、2.遍历完整个链表 两种情况）
        while(cur!=null){
            // 下一个节点不为空，且与当前节点的值相同
            if(cur.next!=null && cur.next.val==cur.val){
                // 继续循环地查找是否有重复的节点
                while(cur.next!=null && cur.next.val==cur.val)
                    // 将cur指向下一个重复节点
                    cur=cur.next;
                // 将cur指向下一个节点
                cur=cur.next;
                // 如果头节点就与之后的节点重复，则将头指针指向cur
                if(pre==null)
                    head=cur;
                    // 否则，将pre的下一个节点指向cur
                else
                    pre.next=cur;
            }else{
                pre=cur;
                cur=cur.next;
            }
        }
        return head;
    }
}