package filesprocessing.Filter.PermissionsFilter;

import filesprocessing.Exceptions.TypeOne.TypeOne;
import filesprocessing.Filter.Filter;

import java.nio.file.Path;

public abstract class PermissionsFilter implements Filter<Path> {

        private boolean yesOrNo;

        /**
         * a constructor for a permissions filter
         * @param indicator the indicator to test if we want it or not
         */
        public PermissionsFilter(String indicator) throws IllegalArgumentException {
            this.yesOrNo = TypeOne.valueYesOrNo(indicator);
        }

        /**
         * a getter to retrieve our indicator
         * @return our indicator boolean value
         */
        public boolean yesOrNo() {
            return yesOrNo;
        }
}
