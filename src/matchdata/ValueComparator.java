
package matchdata;

import java.util.Comparator;


public class ValueComparator implements Comparator <Model> {
    @Override
    public int compare(Model o1, Model o2) {
        return Double.compare(o1.getDoublePossibility(), o2.getDoublePossibility());
        
    }
    
}
