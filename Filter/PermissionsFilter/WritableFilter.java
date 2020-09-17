package filesprocessing.Filter.PermissionsFilter;

import filesprocessing.Filter.Filter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

//Does file have writing permission? (for the current user)
public class WritableFilter extends PermissionsFilter implements Filter<Path> {

        private boolean writable;

        public WritableFilter (String value){
            super(value);
            writable=super.yesOrNo();

        }

        public boolean accept(Path path) throws IOException {

            File file= path.toFile();
            return file.canWrite()==writable;
        }
}


