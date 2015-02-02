package ankhmorpork.GameLoad;
import ankhmorpork.Game.Game;
import ankhmorpork.GameObjects.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
//import org.json.simple.JSONArray;
import org.json.JSONException;
import org.json.JSONML;
import org.json.JSONObject;
//import org.json.simple.JSONObject;
import org.json.JSONString;
import org.json.JSONStringer;
import org.json.JSONTokener;
import org.json.JSONWriter;
import org.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Iterator;

import jdk.nashorn.internal.runtime.Source;


public class GameSave {

	public static void SaveGame(String File, Game NewGame) throws IOException, JSONException
	{												
		FileWriter jsonWriter = new FileWriter(File);
		JSONObject jsonAddData = new JSONObject();
		//Saving TROLLS
		JSONObject jsonGameTrolls = new JSONObject();
//		jsonGameTrolls.put("Trolls",NewGame.lstTrolls);
//		jsonWriter.write(jsonGameTrolls.toString());
		jsonAddData.put("Trolls",NewGame.lstTrolls);
		
		//Saving DEMONS
		JSONObject jsonGameDeamons = new JSONObject();
//		jsonGameDeamons.put("Demons",NewGame.lstDemons);
//		jsonWriter.write(jsonGameDeamons.toString());
		jsonAddData.put("Demons",NewGame.lstDemons);
		
		//Saving Players
		JSONObject jsonGamePlayers = new JSONObject();	
//		jsonGamePlayers.put("Players",NewGame.lstPlayers);
//		jsonWriter.write(jsonGamePlayers.toString());
		jsonAddData.put("Players",NewGame.lstPlayers);
		
		int PlayerID = 1;
		
		for(Player objPlayer: NewGame.lstPlayers)
		{
			
			//Saving BUILDINGS
			JSONObject jsonPlayerBuildings = new JSONObject();
//			jsonPlayerBuildings.put("Buildings_"+PlayerID,objPlayer.lstBuildings);
//			jsonWriter.write(jsonPlayerBuildings.toString());
			jsonAddData.put("Buildings_"+PlayerID,objPlayer.lstBuildings);

			//Saving MINIONS
			JSONObject jsonPlayerMinions = new JSONObject();
			//jsonPlayerMinions.put("Minions_"+PlayerID, objPlayer.lstMinions);
			//jsonWriter.write(jsonPlayerMinions.toString());
			jsonAddData.put("Minions_"+PlayerID, objPlayer.lstMinions);
			
			jsonAddData.put("GoldCoins_"+PlayerID,objPlayer.lstGoldCoin);
			
			//Saving silvercoins
			jsonAddData.put("SilverCoins_"+PlayerID,objPlayer.lstSilverCoin);
			
			PlayerID++;
//			int i = 1;
//			int j = i;
//			for(Minion objMinion: objPlayer.lstMinions)
//			{
//				
//				JSONObject jsonMinion = new JSONObject();
//				jsonMinion.put("Mnion"+ Integer.toString(j*100+j),objMinion);
//				jsonPlayerMinions.add(jsonMinion);
//				j++;
//			}
//			jsonPlayer.put("lstMinionsPlayer"+i, jsonPlayerMinions);
//			jsonPlayerMinionsXX = jsonPlayerMinions;
//			jsonGamePlayers.add(jsonPlayer);
//			i++;
		}
		//jsonGame.put("lstPlayers",jsonGamePlayers);
		
			
			//Player Player1 = NewGame.lstPlayers.get(0);						
			
			//jsonWriter.write(jsonGame.toString());
			//jsonWriter.write(jsonPlayerMinionsXX.toString());
			jsonWriter.write(jsonAddData.toString());
			jsonWriter.flush();
			jsonWriter.close();											
	}

}
