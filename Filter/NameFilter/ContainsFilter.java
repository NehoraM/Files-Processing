package filesprocessing.Filter.NameFilter;

import filesprocessing.Filter.Filter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

//is contained in the file name (excluding path)
public class ContainsFilter implements Filter<Path> {

    private String filterValue;

    public ContainsFilter (String value){
        filterValue=value;
    }

    public boolean accept(Path path) throws IOException {

        File file= path.toFile();
        String fileName=file.getName();

        // checks if we are on range of size
        return fileName.contains(filterValue);
    }

}
