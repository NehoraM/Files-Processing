package filesprocessing.Compare;

import java.io.File;
import java.nio.file.Path;
import java.util.Comparator;

/**
 * this class compare between two files by they order.
 */

public class AbsCompare implements Comparator<Path> {

    /**
     *
     * @param path1 path of the first file to compare
     * @param path2 path of the second file to compare
     * @return positive if the file name of path1 is the first in the abc order,
     * negative if the file name of path2 is the first in the abc order, 0 if they equals
     */

    @Override
    public int compare(Path path1, Path path2) {
        File file1= path1.toFile();
        File file2= path2.toFile();

        String file1Name= file1.getName();
        String file2Name=file2.getName();

       return file1Name.compareTo(file2Name);
      }
}
