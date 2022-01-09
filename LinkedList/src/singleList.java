
 class singleList {
    // singleList Node
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
     // Create a new SingleList and specify its size
     public static ListNode createList(int num) {
         ListNode head = new ListNode(0);
         ListNode pointer = head;
         for (int i = 0; i < num; i++) {
             ListNode curr = new ListNode(i);
             pointer.next = curr;
             pointer = pointer.next;
         }
         return head.next;
     }

     //find the middle point
     public static ListNode findMiddelPoint(ListNode head){
         if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // reverse singleList
     public static ListNode reverse(ListNode head) {
         ListNode curr = head;
         ListNode sentinel = new ListNode(0);
         while (curr != null) {
             ListNode temp = curr.next;
             ListNode temp2 = sentinel.next;
             curr.next = temp2;
             sentinel.next = curr;
             curr = temp;
         }
         return sentinel.next;
     }
}
