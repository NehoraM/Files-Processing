package filesprocessing.Exceptions.TypeOne;

/**
 * create exception of type one.
 */
public class TypeOne extends Throwable {

    private int line;

    /**
     * constructor
     * @param line the line of the error
     */

    public TypeOne(int line) {
        this.line = line;
    }


    /**
     *  override to the method toString
     * @return which line there error
     */
    @Override
    public String toString() {
        return "Warning in line " + this.line;
    }

    /**
     *
     * @param value the string that should be yes or no
     * @return true if the value is "YES", false if the value is "NO"
     * @throws IllegalArgumentException is the value is not "YES" or "NO"
     */

    public static Boolean valueYesOrNo(String value) throws IllegalArgumentException{

        if(value.equals("NO")){
            return false;
        }
        else if (value.equals("YES")){
            return true;
        }
        else {
            throw new IllegalArgumentException();
        }
    }


    /**
     * check if the length of the filter text legal
     * @param filterText the array of the filter (each cell in the array should be word or number)
     * @return true if the length of the filter text legal, false otherwise.
     */
    public static boolean checkFilterLength(String [] filterText){

        int expectedArgumentAmount = 1;

        if(filterText.length == 0){
            return false;
        }

        if (!filterText[0].equals("all")){
            expectedArgumentAmount++;
        }

        if (filterText[filterText.length - 1].equals("NOT")){
            expectedArgumentAmount++;
        }

        if (filterText[0].equals("between")){
            expectedArgumentAmount++;
        }

        return filterText.length == expectedArgumentAmount;
    }


    /**
     * check if the length of the order text legal
     * @param orderText the array of the filter (each cell in the array should be word or number)
     * @return true if the length of the filter text legal, false otherwise.
     */
    public static boolean checkOrderLength(String [] orderText){

        int OrderLength = 1;

        if(orderText.length == 0){
            return false;
        }

        if(orderText[orderText.length - 1].equals("REVERSE")){
            OrderLength ++;
        }

        return orderText.length == OrderLength;
    }
}

