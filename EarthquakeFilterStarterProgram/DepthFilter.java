
/**
 * Write a description of DepthFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DepthFilter implements Filter {
    private double magMin; 
    private double magMax;
    private String name;
    
    public DepthFilter (double min, double max, String names) { 
        magMin = min;
        magMax = max;
        name = names;
    } 

    public boolean satisfies(QuakeEntry qe) { 
        //return qe.getMagnitude() >= magMin; 
          return qe.getDepth() >= magMin && qe.getDepth() <= magMax;
    } 
    
    public String getName(){
        return name;
    }
}
