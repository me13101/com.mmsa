import java.util.Date;

/**
 * Created by micha on 4/10/2017.
 */
public class Game {
    String home;
    String away;
    int hScore;
    int aScore;
    Date date;

    public Game(String home, String away, double hScore, double aScore, Date date){
        this.home = home;
        this.away = away;
        this.hScore = (int)hScore;
        this.aScore = (int)aScore;
        this.date = date;
    }

    public String getWinner(){
        if (aScore > hScore){
            return away;
        }
        else if (hScore > aScore){
            return home;
        }
        else return "";
    }
    public String getLoser(){
        if (aScore > hScore){
            return home;
        }
        else if (hScore > aScore){
            return away;
        }
        else return away+" and "+home+" are tied";
    }


    public String getScore(){
        if (aScore > hScore){
            return aScore+"-"+hScore;
        }
        else if (hScore > aScore){
            return hScore+"-"+aScore;
        }
        else return hScore+"-"+aScore;
    }
}
