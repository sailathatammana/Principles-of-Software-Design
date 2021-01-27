
/**
 * Write a description of LargestQuakes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class LargestQuakes {
    public void findLargestQuakes(int howMany) {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        //list.forEach(System.out::println);
        System.out.println("read data for " + list.size() + " quakes");
        //System.out.println(this.indexOfLargest(list) + "\t" + list.get(this.indexOfLargest(list)).getMagnitude());
        ArrayList<QuakeEntry> largest;
        largest = this.getLargest(list, howMany);
        largest.forEach(System.out::println);
        System.out.println(largest.size());
    }
    
    public int indexOfLargest (ArrayList<QuakeEntry> data) {
        int indexOfLargest = 0;
        double maxMagnitude = data.stream().map(a -> a.getMagnitude()).max(Double::compareTo).orElse(null);

        for (int i = 0; i < data.size(); ++i) {
            if (data.get(i).getMagnitude() == maxMagnitude) {
                indexOfLargest = i;
            }
        }
        return indexOfLargest;
    }
    
    public ArrayList<QuakeEntry> getLargest (ArrayList<QuakeEntry> quakeData, int howMany) {
        ArrayList<QuakeEntry> quakeDataCopy = new ArrayList<>(quakeData);
        ArrayList<QuakeEntry> largestQuakes = new ArrayList<>();
        if (howMany > quakeDataCopy.size()) {
            howMany = quakeDataCopy.size();
        }
        for (int i = 0; i < howMany; ++i) {
            int largestQuakeIndex = this.indexOfLargest(quakeDataCopy);
            largestQuakes.add(quakeDataCopy.get(largestQuakeIndex));
            quakeDataCopy.remove(largestQuakeIndex);
        }
        return largestQuakes;
    }
}
