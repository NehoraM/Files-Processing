package filesprocessing.Compare;

import filesprocessing.Exceptions.TypeOne.TypeOne;
import filesprocessing.SectionsParsing;

import java.nio.file.Path;
import java.util.Comparator;

/**
 * this class is compare factory.
 */
public class CompareFactory {


    /**
     * constructor
     */
    private CompareFactory(){}

    /**
     * get the required comparator
     * @param Section the section
     * @return the required comparator
     * @throws TypeOne if the the required comparator not legal comparator
     */
    public static Comparator<Path> getCompare(SectionsParsing Section) throws TypeOne{


        if(!Section.orderLength()){
            throw new TypeOne(Section.orderLine);
        }

        switch (Section.orderText()[0]){
            case "type":
                return new TypeCompare();
            case "abs":
                return new AbsCompare();
            case "size":
                return new SizeCompare();
            default:
                throw new TypeOne(Section.orderLine);
        }
    }

    /**
     * reverse the order of the filter
     * @param CompareToReverse the Comparator to reverse
     * @return the comparator reversed
     */
    public static Comparator<Path> reverseCompare(Comparator<Path> CompareToReverse){

        return new ReverseCompare(CompareToReverse);
    }


    /**
     * gets a default comparator
     * @return the default compare
     */
    public static Comparator<Path> getDefaultCompare(){
        return new AbsCompare();
    }




}
