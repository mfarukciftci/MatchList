
package matchdata;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class MatchData {
     private static double doubleValue(Object value) {
    return (value instanceof Number ? ((Number)value).doubleValue() : -1.0);
  }
    
    
    public static String calculatePossibilty(double a, double b, double c){
        if(a > b && a > c) return ("HOME_TEAM_WIN " + a);
        else if(b > a && b > a)return ("DRAW " + b);
        else return ("AWAY_TEAM_WIN" + c);
    }
    
    public static Double calculateDouble(double a, double b, double c){
        if(a > b && a > c) return a;
        else if(b > a && b > a)return  b;
        else return  c;
    }

    public static void main(String[] args) {
        ClassLoader classLoader = new MatchData().getClass().getClassLoader();
        String fileName = "matchdata/BE_data.json";
        File file  = new File(classLoader.getResource(fileName).getFile());
        ArrayList <Model> matchList = new ArrayList<>();
        List<Double> possible = new ArrayList<>(); 
        JSONParser parser = new JSONParser();
        
        try{
            FileReader reader = new FileReader(file.getAbsolutePath());
            Object obj = parser.parse(reader);
            JSONObject jsonObj = (JSONObject) obj;
            
            JSONArray jsonArrayEvents = (JSONArray) jsonObj.get("Events");  
            int a=0;
            
            for(int i =0; i < jsonArrayEvents.size();i++){
                String home = null,away = null,stadium = null,startDate,countryHome = null,countryAway = null,highestPosibility;
                double homeTeam,draw,awayTeam;
                JSONObject jsonEvents = (JSONObject) jsonArrayEvents.get(i);
                
                
                startDate = (String) jsonEvents.get("start_date");
                
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
                    stadium = (String) venue.get("name");}  
                
                homeTeam = doubleValue(jsonEvents.get("probability_home_team_winner"));               
                draw = doubleValue( jsonEvents.get("probability_draw"));              
                awayTeam = doubleValue( jsonEvents.get("probability_away_team_winner"));
                highestPosibility = calculatePossibilty(homeTeam,draw,awayTeam);
                 
                double average = calculateDouble(homeTeam,draw,awayTeam);
                 
                possible.add(average);
                 
                 
                matchList.add(new Model(startDate,home,away,
                         countryHome,countryAway,
                         stadium,highestPosibility,average));
                
                 
            
            }
            
            Collections.sort(possible);
            Collections.reverse(possible);
            double average1 = possible.get(10);
            
            for(int i=0; i<matchList.size();i++){
                if(matchList.get(i).getDoublePossibility()>average1)
                    matchList.get(i).showInfos();
            }
            
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
        
    }
    

