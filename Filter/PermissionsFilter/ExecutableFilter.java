package filesprocessing.Filter.PermissionsFilter;

import filesprocessing.Filter.Filter;

import javax.xml.crypto.dsig.spec.XPathType;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

//Does file have execution permission? (for the current user)
public class ExecutableFilter extends PermissionsFilter implements Filter<Path> {

    private boolean executable;


    public ExecutableFilter (String value){
        super(value);
        this.executable=super.yesOrNo();
    }

    public boolean accept(Path path) throws IOException {

        String pathString= path.toString();
        File file= new File(pathString);
        return file.canExecute()==executable;
    }

}
