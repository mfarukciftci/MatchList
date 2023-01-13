




import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import matchdata.MatchData;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

public class MatchDataTest {
    
    public MatchDataTest() {
    }
    
    /*@BeforeAll
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
     * Test of calculatePossibilty method, of class matchData.
     */
    @Test
    public void calculatePossibilty() {
        System.out.println("calculatePossibilty");
        double a = 9.5;
        double b = 20.4;
        double c = 70.1;
        String expResult = "AWAY_TEAM_WIN" + c;
        String result = MatchData.calculatePossibilty(a, b, c);
        assertEquals(expResult, result);

        
    }

    /**
     * Test of calculateDouble method, of class JavaApplication53.
     */
    @Test
    public void testCalculateDouble() {
        System.out.println("calculateDouble");
        double a = 10.5;
        double b = 840.2;
        double c = 5.3;
        Double expResult = b;
        Double result = MatchData.calculateDouble(a, b, c);
        assertEquals(expResult, result);
        
    }

   
    @Test
    public void testMain(){
       System.out.println("main");
        String[] args = null;
        try {
            MatchData.main(args);
            // TODO review the generated test code and remove the default call to fail.
        } catch (IOException ex) {
            Logger.getLogger(MatchDataTest.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
