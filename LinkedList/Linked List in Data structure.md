> # Linked List in Data structure

## Concept

- Similar to the array, the linked list is also a `linear` data structure.
- There are two types of linked list: singly linked list and doubly linked list.

## Singly linked list

Each node in a singly-linked list contains not only the value but also `a reference field` to link to the next node

<aside>
💡 every linked list depends on the public node class

</aside>

```java
// Definition for singly-linked list.
public class SinglyListNode {
    int val;
    SinglyListNode next;
    SinglyListNode(int x) { val = x; }
}
```

In most cases, we will use the `head` node (the first node) to represent the whole list.

### Add a new node in linked list

1. Initialize a new node `cur` with the given value;

   ![https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/26/screen-shot-2018-04-25-at-163224.png](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/26/screen-shot-2018-04-25-at-163224.png)
2. Link the "next" field of `cur` to prev's next node `next`;

   ![https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/26/screen-shot-2018-04-25-at-163234.png](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/26/screen-shot-2018-04-25-at-163234.png)
3. Link the "next" field in `prev` to `cur`.

   ![https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/26/screen-shot-2018-04-25-at-163243.png](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/26/screen-shot-2018-04-25-at-163243.png)

### Delete  a node in the linked list

1. Find cur's previous node `prev` and its next node `next`;

   ![https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/27/screen-shot-2018-04-26-at-203558.png](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/27/screen-shot-2018-04-26-at-203558.png)
2. Link `prev` to cur's next node `next`.

   ![https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/26/screen-shot-2018-04-26-at-203640.png](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/26/screen-shot-2018-04-26-at-203640.png)

### implementation

[Implementation of single list](https://github.com/matthewhou19/data-structure-and-algorithm/blob/main/LinkedList/src/MyLinkedList.java)

## doubly Linked list

### Inpelmentation

```java
class MyLinkedList {
    class ListNode {
        int val;
        ListNode pre,next;
        ListNode(int v) {
            val = v;
        }
    }
    // two sentinel Node at head and tail
    ListNode head;
    ListNode tail;
    int size;

    public MyLinkedList() {
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }
  
    public int get(int index) {
        if (index < 0 || index > size -1) return -1;
        ListNode curr =head;
        for (int i = 0; i < index + 1; i++) {
            curr = curr.next;
        }
        return curr.val;
    }
  
    public void addAtHead(int val) {
        ListNode remain = head.next;
        ListNode curr = new ListNode(val);
        head.next = curr;
        curr.pre = head;
        curr.next = remain;
        remain.pre = curr;
        size++;
    }
  
    public void addAtTail(int val) {
        ListNode remain = tail.pre;
        ListNode curr = new ListNode(val);
        tail.pre = curr;
        curr.next = tail;
        curr.pre = remain;
        remain.next = curr;
        size++;
    }
  
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        ListNode curr =head;
        for (int i = 0; i < index + 1; i++) {
            curr = curr.next;
        }
        ListNode p = curr.pre;
        ListNode newNode = new ListNode(val);
        p.next = newNode;
        newNode.pre = p;
        newNode.next = curr;
        curr.pre = newNode;
        size++;
    }
  
    public void deleteAtIndex(int index) {
        if (index < 0 || index > size - 1) return;
         ListNode curr =head;
        for (int i = 0; i < index + 1; i++) {
            curr = curr.next;
        }
        ListNode p = curr.pre;
        ListNode n = curr.next;
        p.next = n;
        n.pre = p;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
```

### property

They are similar in many operations:

1. Both of them are `not able to access the data at a random position` in constant time.
2. Both of them can `add a new node after given node or at the beginning of the list in O(1) time`.
3. Both of them can `delete the first node in O(1) time`.

But it is a little different to `delete a given node` (including the last node).

- In a singly linked list, it is not able to get the previous node of a given node so we have to spend `O(N)` time to find out the previous node before deleting the given node.
- In a doubly-linked list, it will be much easier because we can get the previous node with the "prev" reference field. So we can delete a given node in `O(1)` time.

## Algorithms

### Sentinel

For the Linked list, it is very tricky in the head case. So we can add a sentinel Node for at the front of the head Node. And that action dosen’t increase the space complexity.

```java
//206. Reverse Linked List
class Solution {
    public ListNode reverseList(ListNode head) {
        // create a sentinel Node ,  make this node the head of the result list
        ListNode sentinel = new ListNode(0);
        ListNode curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = sentinel.next;
            sentinel.next = curr;
            curr = temp;
        }
        return sentinel.next;
    }
}
```

### Find the middle point

```java
public static ListNode findMiddelPointOfSingleList(ListNode head){
         if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
```

### Reverse

### Rotate right
