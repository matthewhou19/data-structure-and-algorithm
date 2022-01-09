public class test {


    public static void main(String[] args){
        // 1.single list middel point
        //testMiddlePoint();

        // 2.single list reverse
        //testReverse();

        // 3. rotate right
        testRotate();
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
        singleList.ListNode singList = singleList.createList(10);
        singleList.ListNode reverse = singleList.reverse(singList);
        while (reverse != null) {
            System.out.print(reverse.val);
            System.out.print(",");
            reverse = reverse.next;
        }
    }

    public static  void testRotate(){
        singleList.ListNode singList = singleList.createList(10);
        singleList.ListNode res = singleList.rotateRight(singList, 15);
        while (res != null) {
            System.out.print(res.val);
            System.out.print(",");
            res = res.next;
        }
    }


}
