package filesprocessing.Filter.SizeFilter;

import filesprocessing.Filter.Filter;

import java.nio.file.Path;

public abstract class SizeFilter implements Filter<Path> {

    protected final static int BYTE_TO_K_BYTE=1024;

}
