
package matchdata;

import java.util.Comparator;


public class AlphabeticalComparatorAway implements Comparator <Model>{
   
    @Override
     public int compare(Model o1, Model o2) {
        return o1.getAwayTeam().compareTo(o2.getAwayTeam());
    
     }
}
