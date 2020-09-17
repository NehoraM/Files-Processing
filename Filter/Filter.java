package filesprocessing.Filter;
import java.io.IOException;
import java.nio.file.DirectoryStream;


/**
 * this class is an interface of the filters
 * @param <Path> the path of the file
 */
public interface Filter<Path> extends DirectoryStream.Filter<Path> {

    boolean accept(Path path) throws IOException;


}
