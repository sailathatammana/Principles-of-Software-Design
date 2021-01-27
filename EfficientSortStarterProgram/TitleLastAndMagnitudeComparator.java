
/**
 * Write a description of TitleLastAndMagnitudeComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry>{
    
    public TitleLastAndMagnitudeComparator() {
        
    }

    public int compare(QuakeEntry q1, QuakeEntry q2) {
        /*String info1 = q1.getInfo();
        String info2 = q1.getInfo();
        String last1 = info1.substring(info1.lastIndexOf(" ")+1);
        String last2 = info2.substring(info2.lastIndexOf(" ")+1);
        int i = last1.compareTo(last2);
        if ( i == 0){
           i = Double.compare(q1.getMagnitude(), q2.getMagnitude());
        }    
        return i;*/
        String lastWord1=q1.getInfo().substring(q1.getInfo().lastIndexOf(" ")+1);
        String lastWord2=q2.getInfo().substring(q2.getInfo().lastIndexOf(" ")+1);
        int result=lastWord1.compareTo(lastWord2);
        if(result==0){
            result =  Double.compare(q1.getMagnitude(), q2.getMagnitude());
        }
        return result; 
    }
}
