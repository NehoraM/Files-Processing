package filesprocessing.Filter;
import filesprocessing.Exceptions.TypeOne.TypeOne;
import filesprocessing.Filter.NameFilter.ContainsFilter;
import filesprocessing.Filter.NameFilter.FileFilter;
import filesprocessing.Filter.NameFilter.PrefixFilter;
import filesprocessing.Filter.NameFilter.SuffixFilter;
import filesprocessing.Filter.PermissionsFilter.ExecutableFilter;
import filesprocessing.Filter.PermissionsFilter.HiddenFilter;
import filesprocessing.Filter.PermissionsFilter.WritableFilter;
import filesprocessing.Filter.SizeFilter.BetweenFilter;
import filesprocessing.Filter.SizeFilter.GreaterThanFilter;
import filesprocessing.Filter.SizeFilter.SmallerThanFilter;
import filesprocessing.SectionsParsing;
import java.nio.file.Path;


/**
 * this class if a filter factory
 */
public class FilterFactory {

    /**
     * constructor
     */
    private FilterFactory(){}


    /**
     *
     * @param Section the given section
     * @return the filter of this section
     * @throws TypeOne when the filter name not legal
     */
    public static Filter<Path> getFilter(SectionsParsing Section) throws TypeOne {


        if(!Section.filterLength()){
            throw new TypeOne(Section.filterLine);
        }

        try {

            String filter=Section.filterText()[0];

            if (filter.equals("greater_than"))
                return new GreaterThanFilter(Section.filterText()[1]);
            else if (filter.equals("between"))
                return new BetweenFilter(Section.filterText()[2], Section.filterText()[1]);
            else if (filter.equals(("smaller_than")))
                return new SmallerThanFilter(Section.filterText()[1]);
            else if (filter.equals("contains"))
                return new ContainsFilter(Section.filterText()[1]);
            else if (filter.equals("prefix"))
                return new PrefixFilter(Section.filterText()[1]);
            else if (filter.equals("file"))
                return new FileFilter(Section.filterText()[1]);
            else if (filter.equals("suffix"))
                return new SuffixFilter(Section.filterText()[1]);
            else if (filter.equals("writable"))
                return new WritableFilter(Section.filterText()[1]);
            else if (filter.equals("executable"))
                return new ExecutableFilter(Section.filterText()[1]);
            else if (filter.equals("hidden"))
                return new HiddenFilter(Section.filterText()[1]);
            else if (filter.equals("all"))
                return new AllFilters();
            else
                throw new TypeOne(Section.filterLine);
        }
        catch (Exception ex){
            throw new TypeOne(Section.filterLine);
        }
    }

    /**
     *
     * @return the default filter
     */
    public static Filter<Path> getDefaultFilter(){
        return new AllFilters();
    }


    /**
     *
     * @param filterToReverse the filter to revers
     * @return the filter reversed
     */
    public static Filter<Path> reverseFilter (Filter<Path> filterToReverse){
        return new ReverseFilter(filterToReverse);
    }
}
