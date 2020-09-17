package filesprocessing.Filter;

import java.io.IOException;
import java.nio.file.Path;

/**
 * this class is when all files are matched
 */
public class AllFilters implements Filter<Path>
{

    public boolean accept(Path path)  {

        return true;
    }

}
