import org.junit.Test;


import java.util.Random;

import static org.junit.Assert.*;

public class BSTtest {
    @Test
    public void naiveBSTtest() {
        BinarySearchTree bst = new naiveBST();
        int[] a = new int[10];
        addTenRandomNumber(a, bst);
        for (int num : a) {
            assertEquals(true, bst.find(num));
        }

        deleteTenNum(a, bst);
        for (int num : a) {
            assertEquals(false, bst.find(num));
        }
    }

    private void addTenRandomNumber(int[] a, BinarySearchTree bst) {
        Random r = new Random();
        for (int i = 0; i < 10; i ++) {
            int num = r.nextInt();
            a[i] = num;
            bst.insert(num);
        }
    }

    private void deleteTenNum(int[] a, BinarySearchTree bst){
        for (int num : a) {
            bst.delete(num);
        }
    }

}
