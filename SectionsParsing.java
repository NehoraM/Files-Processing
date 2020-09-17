package filesprocessing;

import filesprocessing.Compare.CompareFactory;
import filesprocessing.Exceptions.TypeOne.TypeOne;
import filesprocessing.Filter.Filter;
import filesprocessing.Filter.FilterFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;


/**
 * this class parsing each section
 */
public class SectionsParsing {

        private static final int BAD_LINE = -1;
        private static final String DEFAULT_FILTER = "abs";
        private static final String SEPARATOR = "#";
        public String filter;
        public String order;
        public int orderLine;
        public int filterLine;

    /**
     * constructor
     */

    public SectionsParsing() {

    }


    /**
     *
     * @param filter the filter of this section
     * @param filterLine the line of the filter
     */
    public SectionsParsing(String filter, int filterLine) {
            this(filter, DEFAULT_FILTER, filterLine, BAD_LINE);
        }


    /**
     *
     * @param filter  the filter
     * @param order the order
     * @param filterLine the filter line
     * @param orderLine the order line
     */
    public SectionsParsing(String filter, String order, int filterLine, int orderLine) {
            this.filter = filter;
            this.order = order;
            this.filterLine = filterLine + 1;
            this.orderLine = orderLine + 1;
        }


    /**
     *
     * @return array of the filter text
     */
    public String [] filterText() {
            return filter.split(SEPARATOR);
        }

    /**
     *
     * @return true if the word true appear in the filter
     */

    public boolean isNot(){
            return this.filterText()[this.filterText().length - 1].equals("NOT");
        }

    /**
     *
     * @return array of the order text
     */
        public String [] orderText() { return order.split(SEPARATOR);}


    /**
     *
     * @return  true if the filter length legal
     */
    public boolean filterLength() {
            return TypeOne.checkFilterLength(this.filterText());
        }


    /**
     *
     * @return  true if the order length legal, false otherwise
     */

    public boolean orderLength(){
            return TypeOne.checkOrderLength(this.orderText());
        }


    /**
     *
     * @return true if we need to reverse the filter, false otherwise
     */
    public boolean isReverse(){
            return this.orderText()[this.orderText().length - 1].equals("REVERSE");
        }


    /**
     * analyzes each section in the command file
     * @param sectionsArrayList a list of the subsections
     * @param directory the directory we want to filter
     */
    public void sectionAnalyze(ArrayList<SectionsParsing> sectionsArrayList, String directory){


        Path directoryPath = Paths.get(directory);


        for(SectionsParsing section:sectionsArrayList){


            ArrayList<Path> filteredFiles = new ArrayList<Path>();


            Filter<Path> currentFilter = getFilter(section);


            filterList(directoryPath, filteredFiles, currentFilter);


            orderPaths(section, filteredFiles);


            filteredFiles.forEach((x) -> System.out.println(x.getFileName()));
        }
    }

    /**
     * orders the path in the way that we want
     * @param section the section we are working with
     * @param filteredFiles the filtered files
     */
    private void orderPaths(SectionsParsing section, ArrayList<Path> filteredFiles) {
        Comparator<Path> currentCompare;


        try {
            currentCompare = CompareFactory.getCompare(section);

            if(section.isReverse()){
                currentCompare = CompareFactory.reverseCompare(currentCompare);
            }
        }
        catch (TypeOne ex){


            System.err.println(ex.toString());
            currentCompare = CompareFactory.getDefaultCompare();
        }


        Sort.sort(filteredFiles, currentCompare);
        filteredFiles.sort(currentCompare);
    }

    /**
     * filters the files by a filter that we have
     * @param directoryPath the path of our directory
     * @param filteredFiles the files that need to be filtered
     * @param currentFilter the filter to work with
     */
    private void filterList(Path directoryPath, ArrayList<Path> filteredFiles, Filter<Path> currentFilter) {

        try {

            for (Path x : Files.newDirectoryStream(directoryPath, currentFilter)) {
                if (!Files.isDirectory(x)) filteredFiles.add(x);
            }
        }
        catch (Exception e){}
    }


    /**
     * gets the filter we want to work with
     * @param section the section we are currently working with
     * @return the filter
     */
    private Filter<Path> getFilter(SectionsParsing section) {

        Filter<Path> currentFilter;


        try {
            currentFilter = FilterFactory.getFilter(section);


            if(section.isNot()){
                currentFilter =  FilterFactory.reverseFilter(currentFilter);
            }

        }catch (TypeOne ex){

            System.err.println(ex.toString());
            currentFilter = FilterFactory.getDefaultFilter();
        }

        return currentFilter;
    }

}
