
package matchdata;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator <Model> {
    @Override
    public int compare(Model o1, Model o2) {
        return o1.getHomeTeam().compareTo(o2.getHomeTeam());
    }
    
    
}
