package PresentationUtilityCommon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class PresentationUtility {

	static List<Integer> numberAlreadyBeingUsedInGame = new ArrayList<Integer>();
	static Integer randomNumberA = 0;
	
	public static boolean randomIntegerGenerator(Integer startNumber, Integer endNumber){
		
		int randomNumber = 0;
		if (startNumber > endNumber) {
		      throw new IllegalArgumentException("Start cannot exceed End.");
		}
		Random random = new Random();
		long range = (long)endNumber - (long)startNumber + 1;
	    long fraction = (long)(range * random.nextDouble());
	    randomNumber =  (int)(fraction + startNumber); 
	    randomNumberA = randomNumber;
		
		if(!(numberAlreadyBeingUsedInGame.size() == 0)){
			if(numberAlreadyBeingUsedInGame.contains(randomNumber)){
				return false;
			}else{
				numberAlreadyBeingUsedInGame.add(randomNumber);
				return true;
			}
		}else{
			numberAlreadyBeingUsedInGame.add(randomNumber);
			return true;
		}
	}
	
	public static Integer returnRandomNumber(Integer startNumber, Integer endNumber){
		if(randomIntegerGenerator(startNumber, endNumber)){
			System.out.print("Generated Number : "+randomNumberA);
			System.out.print("\n");
			return randomNumberA;
		}else{
			System.out.print("Repeat Number : "+randomNumberA);
			System.out.print("\n");
			randomIntegerGenerator(startNumber, endNumber);
		}
		return 0;
	}
	
	public static void main(String[] args) {
		for(int i = 1; i<=10; i++){
			returnRandomNumber(1, 3);
		}
    }
	
	public static String getPersonalityCardNameById(Integer personalityCardId){
		
		switch (personalityCardId) {
	        case 1:  return IConstants.PersonalityCard1;
	        case 2:  return IConstants.PersonalityCard2;
	        case 3:  return IConstants.PersonalityCard3;
	        case 4:  return IConstants.PersonalityCard4;
	        case 5:  return IConstants.PersonalityCard5;
	        case 6:  return IConstants.PersonalityCard6;
	        default: return IConstants.PersonalityCard7;
		}
	}
	
	public static String getCityAreaCardNameById(Integer cityAreaCard){
		
		switch (cityAreaCard) {
	        case 1:  return IConstants.cityCardArea1;
	        case 2:  return IConstants.cityCardArea2;
	        case 3:  return IConstants.cityCardArea3;
	        case 4:  return IConstants.cityCardArea4;
	        case 5:  return IConstants.cityCardArea5;
	        case 6:  return IConstants.cityCardArea6;
	        case 7:  return IConstants.cityCardArea7;
	        case 8:  return IConstants.cityCardArea8;
	        case 9:  return IConstants.cityCardArea9;
	        case 10:  return IConstants.cityCardArea10;
	        case 11:  return IConstants.cityCardArea11;
	        default: return IConstants.cityCardArea12;
		}
	}
	
public static HashMap<Integer, Boolean> initializeAHashmapWithValue(Integer numberToInitialize){
		
		HashMap<Integer, Boolean> mapToIntialize = new HashMap<Integer, Boolean>();
		
		for (int i = 1; i<numberToInitialize; i++){
			mapToIntialize.put(i, false);
		}
		return mapToIntialize;
	}
	
	public static ArrayList<Integer> initializeAArrayWithValue(Integer numberToInitialize){
		
		ArrayList<Integer> arrToIntialize = new ArrayList<Integer>();
		
		for (int i = 1; i <= numberToInitialize; i++){
			arrToIntialize.add(i);
		}
		
		return arrToIntialize;
	}
	/**
	 * 
	 * @param currentPlayer
	 * @param numberOfPlayers
	 * @return
	 */
	public static Integer nextPlayerTurn(Integer currentPlayer, Integer numberOfPlayers){
		if(currentPlayer == numberOfPlayers){
			System.out.print("Next Player would be : Player " + 1);
			return 1;
		}else{
			System.out.print("Next Player would be : Player "+(currentPlayer+1));
			return (currentPlayer+1);  
		}
	}
	/*
		public static void main(String argv[]){
			nextPlayerTurn(4, 4);
		}
	*/
	
}
