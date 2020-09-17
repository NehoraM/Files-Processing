package filesprocessing.Compare;

import java.io.File;
import java.nio.file.Path;
import java.util.Comparator;

/**
 * this class compare between two files by they type
 */

public class TypeCompare  implements Comparator<Path> {

    /**
     *
     * @param path1 the first file to compare
     * @param path2 the second file to compare
     * @return 1 if the type of the first file is the first in the abc order,
     * -1 if the type of the second file is the first in the abc order,
     * if the have the same type, compare by they name,
     * 0 if they have the same type and name.
     *
     */
    @Override
    public int compare(Path path1, Path path2) {

        File file1= path1.toFile();
        File file2= path2.toFile();

        String firstFileName = file1.getName();
        String secondFileName = file2.getName();

        String firstType = firstFileName.substring(firstFileName.lastIndexOf(".") + 1);
        String secondType = secondFileName.substring(secondFileName.lastIndexOf(".") + 1);

        int compare = firstType.compareTo(secondType);

        if (compare==0)
            compare=new AbsCompare().compare(path1, path2);

        if (compare>0)
            return 1;
        else if (compare<0)
            return -1;
        else
            return 0;

    }
}
