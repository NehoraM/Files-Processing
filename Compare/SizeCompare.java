package filesprocessing.Compare;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

/**
 * this class compare between to files by they size
 */

public class SizeCompare  implements Comparator<Path> {

    /**
     *
     * @param path1  the first path of the file to compare
     * @param path2 the second path of the file to compare
     * @return 1 if the first file bigger then the second,
     * -1 if the second file bigger, if they equals- 1 if the first file first in the abc order,
     * -1 if the first file first in the abc order , 0 if they have the same name.
     */
    @Override
    public int compare(Path path1, Path path2) {

        try {
            if (Files.size(path1) > Files.size(path2))
                return 1;
            else if (Files.size(path1) < Files.size(path2))
                return -1;

        } catch (IOException e) { };

        return  new AbsCompare().compare(path1, path2);
    }
}
