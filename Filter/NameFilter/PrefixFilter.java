package filesprocessing.Filter.NameFilter;

import filesprocessing.Filter.Filter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

//value is the prefix of the file name (excluding path)
public class PrefixFilter implements Filter<Path> {


        private String prefix;

        public PrefixFilter (String value){
            prefix=value;
        }

        public boolean accept(Path path) throws IOException {

            File file= path.toFile();
            String fileName=file.getName();

            // checks if we are on range of size
            return fileName.startsWith(prefix);
        }

}


