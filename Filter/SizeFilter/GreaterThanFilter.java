package filesprocessing.Filter.SizeFilter;

import filesprocessing.Exceptions.TypeOne.TypeOne;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GreaterThanFilter extends SizeFilter {

    private double minDouble;

    public GreaterThanFilter (String min) {
        minDouble= Double.parseDouble(min);

        if (minDouble<0){
            throw new NumberFormatException();
        }
    }

    public boolean accept(Path path) {

        File file= path.toFile();
        return ((file.length())>minDouble*BYTE_TO_K_BYTE);


    }


}