
/**
 * Write a description of class QuakeSortInPlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class QuakeSortInPlace {
    public QuakeSortInPlace() {
        // TODO Auto-generated constructor stub
    }
   
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    
    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
       
       for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
        
    } 
    
    public int getLargestDepth(ArrayList<QuakeEntry> quakes, int from) {
        int maxIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getDepth() > quakes.get(maxIdx).getDepth()) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }
    
    public void sortByLargestDepth(ArrayList<QuakeEntry> in) {
       System.out.println("The largest depth size array is :" + in.size());
       for (int i=0; i < in.size() ; i++) {
            int maxIdx = getLargestDepth(in,i);
            System.out.println("The id is    :" + maxIdx);
            System.out.println("The id value is :" + in.get(maxIdx));
            QuakeEntry qi = in.get(i);
            QuakeEntry qmax = in.get(maxIdx);
            in.set(i,qmax);
            in.set(maxIdx,qi);
            if (i ==69) {
                break;
		//System.out.println("69=" + in.get(in.size() - 1));
	    }
        }   
        
    } 
    
    public void onePassBubbleSort(ArrayList<QuakeEntry> quakeData, 
                              int numSorted) {
      for(int i = 0; i < quakeData.size()-1; i++) {
          QuakeEntry Current = quakeData.get(i);
                QuakeEntry Next = quakeData.get(i+1);
        if(quakeData.get(i).getMagnitude() > 
            quakeData.get(i+1).getMagnitude()) {
              //swap QuakeEntry
              quakeData.set(i+1,Current);
                    quakeData.set(i,Next);
        }
      }
    }

    public void sortByMagnitudeWithBubbleSort(ArrayList<QuakeEntry> in) {
        for(int i = 0; i < in.size() - 1; i++) {
            System.out.println("Printing quake after pass " + i);
            onePassBubbleSort(in, i);
            for(QuakeEntry qe : in) {   
                System.out.println(qe);
            }
        }
    }
    
    public boolean checkInSortedOrder(ArrayList<QuakeEntry> quakes){
        boolean flag = true;
        for(int i=0; i<quakes.size()-1; i++){
            if(! (quakes.get(i).getMagnitude() <= quakes.get(i+1).getMagnitude())){
                flag = false;
                break;
            }
        }
        return flag;
    }
    
    public void sortByMagnitudeWithBubbleSortWithCheck(ArrayList<QuakeEntry> in){
            int pass =0;
            //System.out.println(i+"\n"+checkInSortedOrder(in));
            
            for(int i = 0; i<in.size()-1;i++){
                if (!checkInSortedOrder(in)){
                onePassBubbleSort(in,i); 
                pass++;
                //System.out.println("pass " + pass);
                }
                
                else{
                    break;
                }
                }   
            
            System.out.println("pass " + pass);
        
    }
    
    public int sortByMagnitudeWithCheck(ArrayList<QuakeEntry> in){
            int i =0;
            //System.out.println(i+"\n"+checkInSortedOrder(in));
            for( i = 0; i <in.size();i++){
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);            
                if (checkInSortedOrder(in)){
                return (i+1);
                //System.out.println("pass " + pass);
                }                              
                }    
                return -1;
    }
    
    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/earthQuakeDataDec6sample1.atom.";
        //String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes");    
        //sortByMagnitude(list);
        sortByLargestDepth(list);
        //sortByMagnitudeWithBubbleSort(list);
        //sortByMagnitudeWithBubbleSortWithCheck(list);
        //int ite = sortByMagnitudeWithCheck(list);
        System.out.println("EarthQuakes in sorted order:"); 
        for(int i=0; i < list.size();i++){
            System.out.println(i);
            System.out.println(list.get(i));
        }
        /*for(QuakeEntry qe: list){
            System.out.println(qe);
        } */   
        //System.out.println("sortByMagnitudeWithCheck ran "+ite+" times");
    }
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }
    
    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                              qe.getLocation().getLatitude(),
                              qe.getLocation().getLongitude(),
                              qe.getMagnitude(),
                              qe.getInfo());
        }
        
    }
}
