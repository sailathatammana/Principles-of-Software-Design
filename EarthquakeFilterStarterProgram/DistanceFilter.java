
/**
 * Write a description of DistanceFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DistanceFilter implements Filter {
    private Location location;
    private double distMax;
    private String name;
    
    public DistanceFilter (Location from, double distance, String names) { 
        location = from;
        distMax = distance;
        name = names;
    } 
    
    public boolean satisfies(QuakeEntry qe) { 
        //return qe.getMagnitude() >= magMin; 
          return qe.getLocation().distanceTo(location) < distMax;
    } 
    
    public String getName(){
        return name;
    }
}
