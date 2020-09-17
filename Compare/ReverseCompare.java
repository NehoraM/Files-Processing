package filesprocessing.Compare;

import java.nio.file.Path;
import java.util.Comparator;

/**
 * this class is the reverse comparator
 */

public class ReverseCompare implements Comparator<Path> {


    Comparator<Path> comparator;

    /**
     *
     * @param comparator the comparator to reverse
     */

    public ReverseCompare (Comparator<Path> comparator) {
        this.comparator=comparator;
    }


    /**
     *
     * @param path1 the first path to compare
     * @param path2 he second path to compare
     * @return the opposite of the given comparator
     */
    @Override
    public int compare(Path path1, Path path2) {

        return (comparator.compare(path1, path2)*(-1));

    }

}
