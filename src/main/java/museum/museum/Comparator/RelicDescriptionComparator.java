package museum.museum.Comparator;


import museum.museum.Entity.Relic;
import museum.museum.UsefulUtils.TempRelic;

import java.util.Comparator;

public class RelicDescriptionComparator implements Comparator<TempRelic> {

    @Override
    public int compare(TempRelic a1, TempRelic a2) {
        return 0-(a1.getTempValue().compareTo(a2.getTempValue()));
    }
}
