
/**
 * Write a description of class MinMaxFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinMagFilter implements Filter
{
    private double magMin;
    private String name;
    
    public MinMagFilter(double min,String names) { 
        magMin = min;
        names = name;        
    } 

    public boolean satisfies(QuakeEntry qe) { 
        return qe.getMagnitude() >= magMin; 
    } 
    public String getName(){
        return name;
    }

}
