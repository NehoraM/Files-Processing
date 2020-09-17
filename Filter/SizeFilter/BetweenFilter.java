package filesprocessing.Filter.SizeFilter;

import filesprocessing.Exceptions.TypeOne.TypeOne;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BetweenFilter extends SizeFilter {

    private double maxDouble;
    private double minDouble;

    public BetweenFilter (String max , String min){
        minDouble= Double.parseDouble(min);
        maxDouble= Double.parseDouble(max);

        if (minDouble<0 || maxDouble<0 || maxDouble<minDouble){
            throw new NumberFormatException();
        }
    }

    public boolean accept(Path path) throws IOException {

        File file= path.toFile();

        // checks if we are on range of size
        return (file.length() >= this.minDouble*BYTE_TO_K_BYTE &&
                file.length() <= this.maxDouble* BYTE_TO_K_BYTE);
    }
}

