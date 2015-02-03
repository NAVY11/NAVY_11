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
		jsonAddData.put("Trolls",NewGame.lstTrolls);
		
		//Saving DEMONS		
		jsonAddData.put("Demons",NewGame.lstDemons);
		
		//Saving Players		
		jsonAddData.put("Players",NewGame.lstPlayers);
		
		int PlayerID = 1;
		
		for(Player objPlayer: NewGame.lstPlayers)
		{
			
			//Saving BUILDINGS			
			jsonAddData.put("Buildings_"+PlayerID,objPlayer.lstBuildings);

			//Saving MINIONS					
			jsonAddData.put("Minions_"+PlayerID, objPlayer.lstMinions);
			
			//Saving GOLD COINS
			jsonAddData.put("GoldCoins_Avail_"+PlayerID,objPlayer.objGoldCoin.getCoin_Available());
			
			//Saving SILVER COINS
			jsonAddData.put("SilverCoins_Avail_"+PlayerID,objPlayer.objSilverCoin.getCoin_Available());
			
			PlayerID++;
			
		}
		
			jsonWriter.write(jsonAddData.toString());
			jsonWriter.flush();
			jsonWriter.close();										
	}

}
