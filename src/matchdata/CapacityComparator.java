
package matchdata;

import java.util.Comparator;

public class CapacityComparator implements Comparator <Model> {
    @Override
    public int compare(Model o1, Model o2) {
        return Long.compare(o1.getCapacityStadium(), o2.getCapacityStadium());
     
    
    }
}

