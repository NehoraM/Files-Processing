package filesprocessing.Filter.PermissionsFilter;

import filesprocessing.Exceptions.TypeOne.TypeOne;
import filesprocessing.Filter.Filter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

//Is the file a hidden file?
public class HiddenFilter extends PermissionsFilter implements Filter<Path>
{

    private boolean hidden;


    public HiddenFilter (String value){
       super(value);
       hidden=super.yesOrNo();
    }


    public boolean accept(Path path) throws IOException {

        File file= path.toFile();

        return file.isHidden()==hidden;
    }

}
