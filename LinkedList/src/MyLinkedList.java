public class MyLinkedList {
    private listNode head;
    //利用 size variable 快速确定边界条件
    private int size;
    private class listNode {
        int val;
        listNode next;
        listNode(int v){val = v;}
    }

    public MyLinkedList() {
        //sentinel node
        head = new listNode(0);
        size = 0;
    }

    public int get(int index) {
        if (index > size - 1 || index < 0) return -1;
        listNode curr = head.next;
        while (index > 0) {
            curr = curr.next;
            index--;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        listNode next = head.next;
        listNode curr = new listNode(val);
        curr.next = next;
        head.next = curr;
        size++;
    }

    public void addAtTail(int val) {
        listNode curr = new listNode(val);
        listNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = curr;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) return;
        listNode curr = head;
        while (index > 0) {
            curr = curr.next;
            index--;
        }
        listNode next = curr.next;
        listNode nNode = new listNode(val);
        nNode.next = next;
        curr.next = nNode;
        size++;

    }

    public void deleteAtIndex(int index) {
        if (index > size - 1 || index < 0) return;
        listNode curr = head;
        while (index > 0) {
            curr = curr.next;
            index--;
        }
        listNode next = curr.next.next;
        curr.next = next;
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
