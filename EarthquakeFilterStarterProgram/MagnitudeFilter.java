
/**
 * Write a description of MagnitudeFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagnitudeFilter implements Filter {
    private double magMin; 
    private double magMax;
    private String name;
    
    public MagnitudeFilter (double min, double max,String names) { 
        magMin = min;
        magMax = max;
        name = names;
    } 

    public boolean satisfies(QuakeEntry qe) { 
        //return qe.getMagnitude() >= magMin; 
          return qe.getMagnitude() >= magMin && qe.getMagnitude() <= magMax;
    } 
    
    public String getName(){
        return name;
    }
}
