import java.util.*;
import edu.duke.*;

public class EarthQuakeClient {
    public EarthQuakeClient() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData,
    double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for(QuakeEntry qe : quakeData){
            if (qe.getMagnitude() > magMin) {
                answer.add(qe);
            }
        }    
        return answer;
    }

    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData,
    double distMax,
    Location from) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for(QuakeEntry qe : quakeData){
            if(qe.getLocation().distanceTo(from) < distMax){
                answer.add(qe);
            }    
        }    
        return answer;
    }
    
    public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData,
    double minDepth,double maxDepth) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for(QuakeEntry qe : quakeData){
            if(qe.getDepth() > minDepth && qe.getDepth() < maxDepth){
                answer.add(qe);
            }    
        }    
        return answer;
    }
    
    public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData,String where,String phrase) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        // TODO
        for(QuakeEntry qe : quakeData){
            String title = qe.getInfo();
            if(title.contains(phrase)){
                if(where.equals("start")){
                answer.add(qe);
                }
                if(where.equals("end")){
                answer.add(qe);
                }
                if(where.equals("any")){
                answer.add(qe);
                }
            } 
        }
        return answer;
    }    

    public void dumpCSV(ArrayList<QuakeEntry> list){
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }

    }

    public void bigQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        ArrayList<QuakeEntry> listBig = filterByMagnitude(list, 5.0);
        for(QuakeEntry qe : listBig){
             System.out.println(qe);
        }    
        System.out.println("Found "+listBig.size()+" quakes that match that criteria");
    }

    public void closeToMe(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        // This location is Durham, NC
        //Location city = new Location(35.988, -78.907);

        // This location is Bridgeport, CA
        Location city =  new Location(38.17, -118.82);

        // TODO
        ArrayList<QuakeEntry> close = filterByDistanceFrom(list, 1000*1000, city);
        for (int k=0; k< close.size(); k++) {
            QuakeEntry entry = close.get(k);
            double distanceInMeters = city.distanceTo(entry.getLocation());
            System.out.println(distanceInMeters/1000 + " " + entry.getInfo());
        }
        System.out.println("Found "+close.size()+" quakes that match that criteria");
    }
    
    public void quakesOfDepth(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        ArrayList<QuakeEntry> depth = filterByDepth(list, -4000.0, -2000.0);
        for(QuakeEntry qe : depth){
             System.out.println(qe);
        } 
        System.out.println("Found "+depth.size()+" quakes that match that criteria");
    }
    
    public void quakesByPhrase(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
        ArrayList<QuakeEntry> phrase = filterByPhrase(list,"any", "Can");
        for(QuakeEntry qe : phrase){
             System.out.println(qe);
        } 
        System.out.println("Found "+phrase.size()+" quakes that match that criteria");
    }

    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
    }
    
}
