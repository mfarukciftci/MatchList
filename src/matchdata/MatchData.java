
package matchdata;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class MatchData {


    private static double doubleValue(Object value) {
    return (value instanceof Number ? ((Number)value).doubleValue() : -1.0);
  }
    
    
    public static String calculatePossibilty(double a, double b, double c){
        if(a == b & b>c) return("SAME_POSSBILITY_FOR_HOME_AND_DRAW");
        else if(a == c & a>b) return("SAME_POSSBILITY_FOR_HOME_AND_AWAY");
        else if(b == c & b>a) return("SAME_POSSBILITY_FOR_DRAW_AND_AWAY");
        else if(a == b && b ==c) return("SAME_POSSIBILITY_FOR_EACH");
        else if(a > b && a > c) return ("HOME_TEAM_WIN " + a);
        else if(b > a && b > c)return ("DRAW " + b);
        else return ("AWAY_TEAM_WIN" + c);
    }

   
    
    public static Double calculateDouble(double a, double b, double c){
        if(a == b & b>c) return a;
        else if(a == c & a>b) return a;
        else if(b == c & b>a) return b;
        else if(a == b && b ==c) return a;
        else if(a > b && a > c) return a;
        else if(b > a && b > c)return b;
        else return c;
    }
    
    
    
    public static void main(String[] args) throws IOException {
       
       
        
        
        ClassLoader classLoader = new MatchData().getClass().getClassLoader();
        String fileName = "matchdata/BE_data.json";
        File file  = new File(classLoader.getResource(fileName).getFile());

        JSONParser parser = new JSONParser();
        
        
        try{
            
            FileReader reader = new FileReader(file.getAbsolutePath());
            Object obj = parser.parse(reader);
            JSONObject jsonObj = (JSONObject) obj;
            JSONArray jsonArrayEvents = (JSONArray) jsonObj.get("Events");
 
            ArrayList<Model> matchList = new ArrayList<>();
            
            for(int i =0; i < jsonArrayEvents.size();i++){
                String home = null,away = null,stadium = null,startDate,countryHome = null,countryAway = null,highestPossibility;
                double homeTeam,draw,awayTeam;
                long capacityStadium=0;
                JSONObject jsonEvents = (JSONObject) jsonArrayEvents.get(i);
                
                
                homeTeam = doubleValue(jsonEvents.get("probability_home_team_winner"));
                draw = doubleValue( jsonEvents.get("probability_draw"));
                awayTeam = doubleValue( jsonEvents.get("probability_away_team_winner"));
                startDate = (String) jsonEvents.get("start_date");
                highestPossibility = calculatePossibilty(homeTeam,draw,awayTeam);
                double possibilityDouble = calculateDouble(homeTeam,draw,awayTeam);
                
               
                
                JSONArray jsonArrayCompetitors = (JSONArray) jsonEvents.get("competitors");
                for(int x =0; x < jsonArrayCompetitors.size();x++){
                    JSONObject Competitors = (JSONObject) jsonArrayCompetitors.get(x);
                    
                    
                    
                    if(x == 0) {
                        home = (String) Competitors.get("name");
                        countryHome = (String) Competitors.get("country");
                    }
                    else{
                        away = (String) Competitors.get("name");
                        countryAway = (String) Competitors.get("country");
                    }   
                }
                
                
                if ( (JSONObject) jsonEvents.get("venue") != null){
                JSONObject venue = (JSONObject) jsonEvents.get("venue");
                stadium = (String) venue.get("name");
                capacityStadium=(long) venue.get("capacity");  
                }
             
               
                 
                 
                        
                matchList.add(new Model(startDate,home,away,
                             countryHome,countryAway,
                             stadium,highestPossibility,possibilityDouble));

                
                
                
                }
            int number,loop=0,option=5;
            Scanner scan = new Scanner(System.in);
            while(option < 1 || option > 2){
            if (loop>0) System.out.println("Please write 1 to 4");
            
            System.out.println("""
                               Press 1 for Sort by Value
                               Press 2 for Sort by Alphabetical
                               """);
                               
            option = scan.nextInt();
            loop += 1;
            
            }
            System.out.println("There are " + matchList.size() + " matches in this data.");
            System.out.println("How many most probable match results do you want to see?");
            number = scan.nextInt();
            switch(option){
                case 1 :
                   
                    if(number<=matchList.size() && number>0){
                        matchList.sort(new ValueComparator());
                        Collections.reverse(matchList);
                        for(int i = 0; i < number;i++){
                            matchList.get(i).showInfos();}}
                    else System.out.println("invalid value. (Value can't be more than " + matchList.size() + " and can't be negative. )");
                    break;
                
                
                case 2:
                    if(number<=matchList.size() && number>0){
                        matchList.sort(new ValueComparator());
                        int size = matchList.size();
                        for(int i = 0; i < size-number; i++){
                            matchList.remove(0);
                    }
                   
                    matchList.sort(new AlphabeticalComparator());          
                    for(int i = 0; i < number;i++){
                    matchList.get(i).showInfos();}}
                    else System.out.println("invalid value. (Value can't be more than " + matchList.size() + " and can't be negative. )");
                    break;
                
                
                }
             
        
     
          
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
    
    
}