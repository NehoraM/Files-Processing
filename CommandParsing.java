package filesprocessing;
import filesprocessing.Exceptions.TypeTwo.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * this class parse the command file
 */
public class CommandParsing {


    /**
     * goes through the whole list and puts the values in the new array
     * @param fileLines the lines of the file
     * @return the values we will need to sort the files by each time
     * @throws TypeTwo if the word filter or order missing
     */

    private ArrayList<SectionsParsing> prepareTheSections(ArrayList<String> fileLines)  throws TypeTwo {


        ArrayList<SectionsParsing> allSections = new ArrayList<>();

        int counter = 0;


        if (fileLines.size()==0)
            TypeTwo.wordEqualsFilter(" ");

        while (counter < fileLines.size()){

            TypeTwo.wordEqualsFilter(fileLines.get(counter));

            try {
                TypeTwo.wordEqualsOrder(fileLines.get(counter + 2));
            }
            catch (IndexOutOfBoundsException ex){
                TypeTwo.wordEqualsOrder(" ");
            }


            if((counter + 3) >= fileLines.size() || fileLines.get(counter + 3).equals("FILTER")) {
                allSections.add(new SectionsParsing(fileLines.get(counter + 1), counter + 1));
                counter += 3;
                
            }
            else
            {
                allSections.add(new SectionsParsing( fileLines.get(counter + 1), fileLines.get(counter + 3),
                        (counter + 1), (counter + 3)));
                counter += 4;
            }
        }

        return allSections;
    }


    /**
     *
     * @param args the data
     * @return the sections to analyze
     * @throws TypeTwo type two error
     */


    public ArrayList<SectionsParsing> runSetUp(String[] args) throws TypeTwo {


        TypeTwo.enoughLines(args.length);


        ArrayList<String> fileLines = this.readFile(args[1]);


        return this.prepareTheSections(fileLines);
    }

    private ArrayList<String> readFile(String fileName) throws TypeTwo {

        File commandFile = new File(fileName);
        ArrayList<String> allFileLines = new ArrayList<>();


        TypeTwo.readableCommandFile(commandFile);

        try (Scanner reader = new Scanner(commandFile)){


            while (reader.hasNextLine()){
                allFileLines.add(reader.nextLine());
            }

        } catch (Exception e) {

            TypeTwo.readableCommandFile(commandFile);
        }

        return allFileLines;
    }
}
