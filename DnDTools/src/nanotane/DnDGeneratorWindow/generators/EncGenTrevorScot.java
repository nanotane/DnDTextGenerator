package nanotane.DnDGeneratorWindow.generators;

import java.util.ArrayList;
import java.util.Random;

import nanotane.DnDGeneratorWindow.TrevorScot.TrevoScotLists;

public class EncGenTrevorScot {
	
	public String generateCivilizedCountrySide()
	{
		int randomNum = (int)(Math.random() * 100);
		String toReturn = "";
		if(isBetween(randomNum, 0, 35)){
			toReturn = genPeopleActivity();
		} else if(isBetween(randomNum, 31, 35)){
			toReturn = genAmbush(TrevoScotLists.CIV_COUNTRYSIDE_AMBUSH, TrevoScotLists.CIV_COUNTRYSIDE_RUSE, TrevoScotLists.AMBUSH_STRATEGY);
		} else if(isBetween(randomNum, 36, 45)){
			toReturn = genDangerousAnimal();
		} else if(isBetween(randomNum, 46, 55)){
			toReturn = genHazard();
		} else if(isBetween(randomNum, 56, 65)){
			toReturn = genOfValue();
		} else if(isBetween(randomNum, 66, 100)){
			toReturn = genBenign(TrevoScotLists.CIV_COUNTRYSIDE_BENIGN);
		}
		return toReturn;
	}
	
	public String generateUrbanString()
	{
		int randomNum = (int)(Math.random() * 100);
		String toReturn = "";
		if(isBetween(randomNum, 0, 40)){
			toReturn = genPeopleActivity();
		} else if(isBetween(randomNum, 41, 50)){
			toReturn = genAmbush(TrevoScotLists.URBAN_SAFE_AMBUSH, TrevoScotLists.URBAN_SAFE_RUSE, TrevoScotLists.AMBUSH_STRATEGY);
		} else if(isBetween(randomNum, 51, 60)){
			toReturn = genDangerousAnimal();
		} else if(isBetween(randomNum, 61, 70)){
			toReturn = genHazard();
		} else if(isBetween(randomNum, 71, 80)){
			toReturn = genOfValue();
		} else if(isBetween(randomNum, 81, 100)){
			toReturn = genBenign(TrevoScotLists.URBAN_SAFE_BENIGN);
		}
		return toReturn;
	}
	
	/** 
	 * [People][Activity]
	 * @return
	 */
	private String genPeopleActivity(){
		Random rand = new Random();
		int people = rand.nextInt(TrevoScotLists.PEOPLE.size());
		int activity = rand.nextInt(TrevoScotLists.ACTIVITES.size());
		String person = TrevoScotLists.PEOPLE.get(people);
		String active = TrevoScotLists.ACTIVITES.get(activity);
		if(person.equals("[Professional]")){
			person = TrevoScotLists.PROFESSIONAL.get(rand.nextInt(TrevoScotLists.PROFESSIONAL.size()));
		} else if(active.equals("[Working Class]")) {
			person = TrevoScotLists.WORKING_CLASS.get(rand.nextInt(TrevoScotLists.PROFESSIONAL.size()));
		}
		return "Random People: " + TrevoScotLists.PEOPLE.get(people) + " " + TrevoScotLists.ACTIVITES.get(activity);
	}
	
	/**
	 * [Ambush] [Ruse] [Strategy]
	 * @return
	 */
	private String genAmbush(ArrayList<String> pAmbush, ArrayList<String> pRuse, 
			ArrayList<String> pStrategy){
		Random rand = new Random();
		int ambush = rand.nextInt(pAmbush.size());
		int ruse = rand.nextInt(pRuse.size());
		int strategy = rand.nextInt(pStrategy.size());
		return "Ambush! " + pAmbush.get(ambush) + " " + pRuse.get(ruse) + " " + pStrategy.get(strategy);
	}
	
	/**
	 * Dangerous Animal] [Size]
	 * @return
	 */
	private String genDangerousAnimal(){
		Random rand = new Random();
		int animal = rand.nextInt(TrevoScotLists.ANIMAL.size());
		return "Escaped Animal! " + TrevoScotLists.ANIMAL.get(animal);
	}
	
	/**
	 * [Hazard]
	 * @return
	 */
	private String genHazard(){
		Random rand = new Random();
		int hazard = rand.nextInt(TrevoScotLists.HAZARDS.size());
		return "Hazard: " + TrevoScotLists.HAZARDS.get(hazard);
	}
	
	/**
	 * [Of Value]
	 * @return
	 */
	private String genOfValue(){
		Random rand = new Random();
		int value = rand.nextInt(TrevoScotLists.CIV_COUNTRYSIDE_LOOT.size());
		return "Random Loot: " + TrevoScotLists.CIV_COUNTRYSIDE_LOOT.get(value);
	}
	
	/**
	 * [Benign]
	 * @return
	 */
	private String genBenign(ArrayList<String> pBenign){
		Random rand = new Random();
		int benign = rand.nextInt(pBenign.size());
		return "Benign Event: " + pBenign.get(benign);
	}
	
	private boolean isBetween(int toCheck, int pLow, int pHigh) {
		if(toCheck >= pLow && toCheck <= pHigh)
		{
			return true;
		} else {
			return false;
		}
	}
}
