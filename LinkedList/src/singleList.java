
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

     // 61. Rotate List
     public static ListNode rotateRight(ListNode head, int k) {
         if (head == null ) return head; //return null
         // find the size of the link
         int n = 0;
         ListNode curr = head;
         while (curr != null) {
             n++;
             curr = curr.next;
         }
         // find the true rotate location
         int l = k % n;
         return trueRotate(head,l);
     }
     /// true rotation  val l < link.size
     public static ListNode trueRotate(ListNode head, int l) {
         // two pointer
         ListNode fast = head;
         for (int i = 0; i < l; i++) {
             fast = fast.next;
         }
         ListNode slow = head;

         while (fast.next != null) {
             slow= slow.next;
             fast = fast.next;
         }

         // rotate
         fast.next = head;
         head = slow.next;
         // new tail
         slow.next = null;
         return head;
     }

}
