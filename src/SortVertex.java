import java.util.Comparator;

public class SortVertex implements Comparator<PriorityVertex> {

    @Override
    public int compare(PriorityVertex o1, PriorityVertex o2) {

        if(o1.priority < o2.priority) {
            return -1;
        }

        else {
            return 1;
        }
    }
}
