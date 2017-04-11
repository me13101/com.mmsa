import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.camel.ProducerTemplate;

/**
 * Created by micha on 4/10/2017.
 */

public class App {

    private ProducerTemplate template;

    public App(){

    }

    public static void main(String[] args){
        try {
            URL url = new URL("https://api.sportradar.us/mlb-t6/games/2017/04/10/boxscore.json?api_key=3xbzsfssc3e275uy9r33pvm4");
            Boxscore boxscore = getBoxScore(url);
            List games = boxscore.getGames();
            for(int i = 0; i < games.size(); i++){
                Game g = (Game)games.get(i);
                if(g.getWinner().equals("")){
                    System.out.println((g.getLoser()+": "+g.getScore()).trim());
                }
                else {
                    System.out.println((g.getWinner() + " win over " + g.getLoser() + ": " + g.getScore()).trim());
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static Boxscore getBoxScore(URL url){

        try {
            URLConnection connection = url.openConnection();
            Object o = connection.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader((InputStream)o));
            Boxscore boxscore = new Boxscore(reader.readLine());
            return boxscore;
        } catch (Exception ioe) {
            System.out.println(ioe);
            return null;
        }
    }
}
