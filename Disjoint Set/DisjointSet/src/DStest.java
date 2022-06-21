
import org.junit.Test;


import static org.junit.Assert.*;
public class DStest {

    @Test
    public void QuickFindTest(){
        DisjointSets ds = new QuickFindDS(10);
        tenElements(ds);
        assertEquals(true, ds.isConnected(7,9));
        assertEquals(true, ds.isConnected(1,2));
        assertEquals(true, ds.isConnected(4,5));
        assertEquals(false, ds.isConnected(0,9));
        assertEquals(false, ds.isConnected(3,9));
    }


    private void tenElements(DisjointSets ds) {
        ds.connect(0, 1);
        ds.connect(0, 2);
        ds.connect(3,4);
        ds.connect(3,5);
        ds.connect(6,7);
        ds.connect(6,8);
        ds.connect(6,9);
    }
}
