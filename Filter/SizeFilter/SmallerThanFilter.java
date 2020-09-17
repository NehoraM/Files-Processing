package filesprocessing.Filter.SizeFilter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SmallerThanFilter extends SizeFilter {


    private double maxDouble;

    public SmallerThanFilter (String max){
        this.maxDouble= Double.parseDouble(max);

        if ( maxDouble<0 ){
            throw new NumberFormatException();
        }
    }

    public boolean accept(Path path) throws IOException {

        File file= path.toFile();

        // checks if we are on range of size
        return file.length() < this.maxDouble*BYTE_TO_K_BYTE;
    }

}
