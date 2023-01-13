package matchdata;
        
public class Model {
    private String date;
    private String homeTeam;
    private String awayTeam;
    private String homeCountry;
    private String awayCountry;
    private String stadium;
    private String highestPossibility;
    private double doublePossibility;
    private long capacityStadium;

   

    
    
    public Model(String date, String homeTeam, String awayTeam,String homeCountry, String awayCountry, String stadium, String highestPossibility, double doublePossibility, long capacityStadium){
        this.date = date;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeCountry = homeCountry;
        this.awayCountry = awayCountry;
        this.stadium = stadium;
        this.highestPossibility = highestPossibility;
        this.doublePossibility = doublePossibility;
        this.capacityStadium = capacityStadium; 
        

    
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getHomeCountry() {
        return homeCountry;
    }

    public void setHomeCountry(String homeCountry) {
        this.homeCountry = homeCountry;
    }

    public String getAwayCountry() {
        return awayCountry;
    }

    public void setAwayCountry(String awayCountry) {
        this.awayCountry = awayCountry;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }
    public String getHighestPossibility() {
        return highestPossibility;
    }

    public void setHighestPossibility(String highestPossibility) {
        this.highestPossibility = highestPossibility;
    }
    public double getDoublePossibility() {
        return doublePossibility;
    }

    public void setDoublePossibility(double doublePossibility) {
        this.doublePossibility = doublePossibility;
    }
     public long getCapacityStadium() {
        return capacityStadium;
    }

    public void setCapacityStadium(int capacityStadium) {
        this.capacityStadium = capacityStadium;
    }
    @Override
    public String toString() {
        String possibilityDouble = null;
        return "Matches{" + "date=" + date + ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", homeCountry=" + homeCountry + ", awayCountry=" + awayCountry + ", stadium=" + stadium + ", highestPossibility=" + highestPossibility + ", possibilityDouble=" + possibilityDouble + "capacityStadium="+ capacityStadium + '}';
    }

   
    public void showInfos(){
        System.out.print(this.homeTeam + "(" + this.homeCountry + ")" + " vs ");
        System.out.println(this.awayTeam + "(" + this.awayCountry + ")");
        System.out.println("Venue : " + this.stadium);
        System.out.println("The highest possibility : " + this.highestPossibility );
        System.out.println("");
    }
       public void showInfosWithCapacity(){
        System.out.print(this.homeTeam + "(" + this.homeCountry + ")" + " vs ");
        System.out.println(this.awayTeam + "(" + this.awayCountry + ")");
        System.out.println("Venue : " + this.stadium);
        System.out.println("Highest probable result : " + this.highestPossibility );
        System.out.println("Capacity: " + this.capacityStadium);
        System.out.println("");
    }

}
