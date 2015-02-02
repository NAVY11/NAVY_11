package ViewFile;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import PresentationUtilityCommon.PresentationUtility;
import ankhmorpork.GameObjects.Area;
import ankhmorpork.GameObjects.Player;

public class ViewFileAmbg {

	/*public static void main(String[] args) {

		String sb = dataToStoreInTextFile();
	    JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new File("/home/me/Documents"));
	    int retrival = chooser.showSaveDialog(null);
	    if (retrival == JFileChooser.APPROVE_OPTION) {
	        try {
	            FileWriter fw = new FileWriter(chooser.getSelectedFile()+".ambg");
	            fw.write(sb.toString());
	            fw.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	}
	*/
	
	public static String ViewState(ArrayList<Player> lstPlayers){
		return dataToStoreInTextFile(lstPlayers);
	}
	
	public static String dataToStoreInTextFile(ArrayList<Player> lstPlayers){
		String saveTheDetailsInTextFile = "";
		
		saveTheDetailsInTextFile += playerGeneralInfo(lstPlayers);
		saveTheDetailsInTextFile += "\n\n";
		saveTheDetailsInTextFile += areaDetails();
		saveTheDetailsInTextFile += "\n\n";
		saveTheDetailsInTextFile += playerDetails(lstPlayers);
		saveTheDetailsInTextFile += "\n\n";
		saveTheDetailsInTextFile += totalAmountBankOwns();
		
		return saveTheDetailsInTextFile;
	}
	
	/**
	 * The method below is just an random input to play with the method
	 * @return
	 */
	
	public static ArrayList<Player> InitializePlayers(){
		ArrayList<Player> players = new ArrayList<Player>();
		

//		Game Ankh = new Game();
//		try {
//			Ankh = GameLoad.LoadGame("Ankh11");
//			int i=1;
//			for(Player objPlayer: Ankh.lstPlayers)
//			{		
//				//System.out.println("Player "+ i + " Details");
//				//System.out.println("Player ID: "+objPlayer.getPlayer_id()+" Player Name:"+objPlayer.getPlayer_name()+" Player Color:"+objPlayer.getPlayer_color());
//				//System.out.println("Player ID: "+
//				objPlayer.getPlayer_id();
//				objPlayer.getPlayer_name();
//				objPlayer.getPlayer_color();
//				objPlayer.setPlayer_amount((float)1000.00);
//				players.add(objPlayer);
//				i++;
//			}
//			
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		
		
		Player player1 = new Player(1, "naresh", "blue");
		Player player2 = new Player(2, "vijay", "green");
		Player player3 = new Player(3, "ashish", "red");
		
		player1.setPlayer_active(true);
		player1.setPlayer_amount((float)1000.00);
		player1.setPlayer_color("red");
		player1.setPlayer_id(1);
		player1.setPlayer_personality_card_id(1);
		
		player2.setPlayer_active(true);
		player2.setPlayer_amount((float)2000.00);
		player2.setPlayer_color("blue");
		player2.setPlayer_id(2);
		player2.setPlayer_personality_card_id(2);
		
		player3.setPlayer_active(true);
		player3.setPlayer_amount((float)3000.00);
		player3.setPlayer_color("green");
		player3.setPlayer_id(3);
		player3.setPlayer_personality_card_id(3);
		
		players.add(player1);
		players.add(player2);
		players.add(player3);		
		
		return players;
	}
	
	public static String playerGeneralInfo(ArrayList<Player> players){
		
		String playerGeneralInfoStr = "Game State";
		int i = players.size()-1;
		
		playerGeneralInfoStr += "\n-----------------";
		playerGeneralInfoStr += "\nThere are "+players.size()+" players:";
		
		for(Player player: players){
			playerGeneralInfoStr += "\nPlayer "+(players.size() -i)+", "+ player.getPlayer_color()+", "+ PresentationUtility.getPersonalityCardNameById(player.getPlayer_personality_card_id());
			i -= 1;
		}
		return playerGeneralInfoStr;
	}

	public static String areaDetails(){
		
		String areaDetails = "\n\nCurrent State of the Game Board: ";
		areaDetails += "\n\tarea\tminions\t\t\ttrouble?\tbuildings?\tdemons\ttrolls";
		
		for(int i = 1; i < 12; i++){
			areaDetails += "\n\t"+paddingToMakeSixteen(PresentationUtility.getCityAreaCardNameById(i))+"\t"
					+Area.getListOfMinionsByAreaId(i)+ "\t"
					+Area.getListOfTroubleMakersByAreaId(i)+ "\t"
					+Area.getListOfBuildingsByAreaId(i)+ "\t"
					+Area.getListOfDemonsByAreaId(i)+ "\t"
					+Area.getListOfTrollsByAreaId(i)+ "\t";
		}
		return areaDetails;
	}
	
	public static String paddingToMakeSixteen(String areaName){
		
		String emptyString = "";
		if(areaName.length() < 16){
			for(int i = 1; i <= 16-areaName.length(); i++){
				emptyString += " ";
			}
		}
		return areaName+emptyString;
	}
	
	public static String playerDetails(ArrayList<Player> players){
		
		String playerDetails = "";
		int i = players.size()-1;
		for(Player player: players){
			playerDetails += "\nPlayer "+(players.size() -i)+"'s current Inventory:";
			playerDetails += "\n\n\t- "+player.lstMinions.size()+" minions, "+player.lstBuildings.size()+" buildings, "+player.lstMinions.size()+" dollars ";
			playerDetails += "\n\n\t-City Area Cards: ";
			playerDetails += "\n\t\t"; //TODO: Have to print City Area Cards, which player has how much
			playerDetails += "\n\n\t-Player Cards: ";
			playerDetails += "\n\t\tGreen Cards "; 
			playerDetails += "\n\t\tBrown Cards ";
			playerDetails += "\n";
			i -= 1;
		}

		return playerDetails;
		
	}
	
	public static String totalAmountBankOwns(){
		String totalAmountStr = "The bank has "+74+" Ankh-Morpork dollars.";
		
		return totalAmountStr;
		
	}

}
