package filesprocessing.Filter;
import java.io.IOException;
import java.nio.file.Path;


/**
 * this class is the reverse filter
 */
public class ReverseFilter implements Filter<Path> {

    private Filter<Path> filterToReverse;

    /**
     *
     * @param filter the filter to reversed
     */
    public ReverseFilter(Filter<Path> filter) {
        this.filterToReverse = filter;
    }


    /**
     *
     * @param path the path of the file to check
     * @return true if the file pass the filter, false if he doesnt
     * @throws IOException if the path is not legal
     */
    public boolean accept(Path path) throws IOException {

        return !filterToReverse.accept(path);
    }

}
