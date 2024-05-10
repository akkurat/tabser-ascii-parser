import com.google.common.collect.RowSortedTable;
import com.google.common.collect.TreeBasedTable;

import java.util.Map;

public class MutableTabs {

    private final RowSortedTable<Integer, String, String> backing = TreeBasedTable.create();

    public void setNote(int time, int stringIdx, String fret) {
        setNote(time, String.valueOf(stringIdx), fret);
    }

    public void setNote(int time, String stringName, String fret) {
        if(backing.get(time,stringName) != null ) {
            throw new IllegalArgumentException("already note at this place");
        }
        backing.put(time, stringName, fret);
    }


    public Map<String, String> getTime(int i) {
        return backing.row(i);
    }
}
