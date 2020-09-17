package filesprocessing.Filter.NameFilter;

import filesprocessing.Filter.Filter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

// value equals the file name (excluding path)
public class FileFilter implements Filter<Path> {

    private String filterValue;

    public FileFilter (String value){
        filterValue=value;
    }

    public boolean accept(Path path) throws IOException {

        File file = path.toFile();

        String fileName= file.getName();
        //String pathString= path.toString();
        //String fileName= pathString.substring(pathString.lastIndexOf("."+1));
        return fileName.equals(filterValue);
    }

}
