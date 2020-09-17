package filesprocessing.Exceptions.TypeTwo;

import java.io.File;

public class TypeTwo extends Exception {


    private String errorMessage;
    private String errorCause;

    private static final int NUM_OF_LINES = 2;


    private static final String ENOUGH_LINES = "not enough lines in the command file";
    private static final String READING_PERMISSIONS = "no reading permissions on the command files";
    private static final String MISSING_FILTER = "the word FILTER is missing";
    private static final String MISSING_ORDER= "the word ORDER is missing";
    private static final String INVALID_USAGE= "Invalid Usage";


    public static final String FILTER = "FILTER";
    public static final String ORDER = "ORDER";


    /**
     * constructor
     * @param errorType the type of the error
     * @param errorCause the cause of the error
     */
    private TypeTwo(String errorType, String errorCause){

        this.errorMessage = errorType;
        this.errorCause = errorCause;
    }

    /**
     *
     * @return A string representation of the current exception.
     */
    @Override
    public String toString() {
        return "ERROR: " + this.errorMessage + " " + this.errorCause;
    }


    /**
     *
     * @param lines the lines in the command file
     * @throws TypeTwo error of type two.
     */
    public static void enoughLines(int lines) throws TypeTwo {

        if(lines != NUM_OF_LINES){
            throw new TypeTwo(INVALID_USAGE ,ENOUGH_LINES);
        }
    }


    /**
     * check if the command file readable
     * @param file the command file
     * @throws TypeTwo error of type two.
     */

    public static void readableCommandFile(File file) throws TypeTwo {

        if(!file.canRead()){
            throw new TypeTwo(INVALID_USAGE , READING_PERMISSIONS);
        }
    }


    /**
     * check if the word FILTER exist
     * @param word the word to check
     * @throws TypeTwo error of type two.
     */
    public static void wordEqualsFilter(String word) throws TypeTwo {


        if(!(word.equals(FILTER))){
            throw new TypeTwo(INVALID_USAGE , MISSING_FILTER);
        }
    }


    /**
     * check if the word ORDER exist
     * @param word the word to check
     * @throws TypeTwo error of type two.
     */
    public static void wordEqualsOrder(String word) throws TypeTwo {

        if(!(word.equals(ORDER))){
            throw new TypeTwo(INVALID_USAGE , MISSING_ORDER);
        }
    }



}

