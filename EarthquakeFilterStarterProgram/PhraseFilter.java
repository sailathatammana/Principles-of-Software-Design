
/**
 * Write a description of PhraseFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhraseFilter implements Filter {
    private String request; // values "start", "end", "any"
    private String phrase;
    private String name;
    
    public PhraseFilter(String req, String phr, String names) {
        request = req;
        phrase = phr;
        name = names;
    }
    
    public boolean satisfies(QuakeEntry qe) { 
        String info = qe.getInfo(); 
        switch (request) {
            case "start":
            if (info.startsWith(phrase)) return true;
            break;
            case "end":
            if (info.endsWith(phrase)) return true;
            break;
            case "any":
            if (info.contains(phrase)) return true;
        }
        return false;
    } 
    
    public String getName(){
        return name;
    }
}
