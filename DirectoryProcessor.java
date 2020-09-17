package filesprocessing;
import filesprocessing.Exceptions.TypeTwo.TypeTwo;
import java.util.ArrayList;

/**
 * the main class
 */

public class DirectoryProcessor {

    /**
     *
     * @param args the data given from the user
     */

    public static void main(String[] args) {


        CommandParsing commandFileData = new CommandParsing();
        SectionsParsing filterAndOrderFiles = new SectionsParsing();

        try {
            ArrayList<SectionsParsing> actionsToExecute = commandFileData.runSetUp(args);

            filterAndOrderFiles.sectionAnalyze(actionsToExecute, args[0]);

        }catch (TypeTwo e){
            System.err.println(e.toString());
        }
    }
}
