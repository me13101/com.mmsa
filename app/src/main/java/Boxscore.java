import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by micha on 4/10/2017.
 */
public class Boxscore {

    String box;

    public Boxscore(String box){
        this.box = box;
    }

    public List getGames(){
        List gameList = new ArrayList<Game>();
        try {
            Gson g = new Gson();
            Object obj = g.fromJson(box, Object.class);
            LinkedTreeMap map = (LinkedTreeMap) obj;
            LinkedTreeMap gamesMap = (LinkedTreeMap)map.get("league");
            ArrayList<LinkedTreeMap> games = (ArrayList<LinkedTreeMap>)gamesMap.get("games");
            for (int i = 0; i < games.size(); i++){
                LinkedTreeMap o = (LinkedTreeMap)games.get(i).get("game");
                LinkedTreeMap home = (LinkedTreeMap)o.get("home");
                LinkedTreeMap away = (LinkedTreeMap)o.get("away");
                Game game = new Game(home.get("market").toString()+" "+home.get("name").toString(), away.get("market").toString()+" "+away.get("name").toString(), (Double) home.get("runs"), (Double)away.get("runs"), new Date());
                gameList.add(game);
            }
            //System.out.println(gamesMap);
        }catch (Exception e){
            System.out.print(e);
            return null;
        }
        return gameList;
    }
}
