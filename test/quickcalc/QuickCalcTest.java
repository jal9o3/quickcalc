
package quickcalc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuickCalcTest {
    
    public QuickCalcTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of calculate method, of class QuickCalc.
     */
    @Test
    public void testCalculate() throws Exception {
        System.err.println("Running testCalculate...");
        Calculator quickCalc = new QuickCalc();
        double result = quickCalc.calculate("1+1");
        assertEquals(2.0, 2.0);
    }
    
}
