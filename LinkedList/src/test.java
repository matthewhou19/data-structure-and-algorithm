public class test {


    public static void main(String[] args){
        // single list middel point
        //testMiddlePoint();

        // single list reverse
        //testReverse();
    }

    // test find middle point
    public static void testMiddlePoint() {
        // change the val of createList METHOD to check different length of List
        singleList.ListNode singList = singleList.createList(0);
        singleList.ListNode middelPoint = singleList.findMiddelPoint(singList);
        if (middelPoint != null) {
            System.out.println(middelPoint.val);
        }
    }

    public static void testReverse() {
        // change the val of createList METHOD to check different length of List
        singleList.ListNode singList = singleList.createList(0);
        singleList.ListNode reverse = singleList.reverse(singList);
        while (reverse != null) {
            System.out.print(reverse.val);
            System.out.print(",");
            reverse = reverse.next;
        }
    }


}
