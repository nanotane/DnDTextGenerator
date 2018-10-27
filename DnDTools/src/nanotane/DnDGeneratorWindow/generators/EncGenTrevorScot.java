package nanotane.DnDGeneratorWindow.generators;

import java.util.ArrayList;
import java.util.Random;

public class EncGenTrevorScot implements IEncounterGenerator{
	
	@Override
	public String gererateString() {
		int randomNum = (int)(Math.random() * 100);
		String toReturn = "";
		if(isBetween(randomNum, 0, 35)){
			toReturn = genPeopleActivity();
		} else if(isBetween(randomNum, 31, 35)){
			toReturn = genAmbush();
		} else if(isBetween(randomNum, 36, 45)){
			toReturn = genDangerousAnimal();
		} else if(isBetween(randomNum, 46, 55)){
			toReturn = genHazard();
		} else if(isBetween(randomNum, 56, 65)){
			toReturn = genOfValue();
		} else if(isBetween(randomNum, 66, 100)){
			toReturn = genBenign();
		}
		return toReturn;
	}
	
	/** 
	 * [People][Activity]
	 * @return
	 */
	private String genPeopleActivity(){
		Random rand = new Random();
		int people = rand.nextInt(sPeople.size());
		int activity = rand.nextInt(sActivities.size());
		String person = sPeople.get(people);
		String active = sActivities.get(activity);
		if(person.equals("[Professional]")){
			person = sProfessional.get(rand.nextInt(sProfessional.size()));
		} else if(active.equals("[Working Class]")) {
			person = sWorkingClass.get(rand.nextInt(sProfessional.size()));
		}
		return sPeople.get(people) + " " + sActivities.get(activity);
	}
	
	/**
	 * [Ambush] [Ruse] [Strategy]
	 * @return
	 */
	private String genAmbush(){
		Random rand = new Random();
		int ambush = rand.nextInt(sAmbush.size());
		int ruse = rand.nextInt(sRuse.size());
		int strategy = rand.nextInt(sStrategy.size());
		return sAmbush.get(ambush) + " " + sRuse.get(ruse) + " " + sStrategy.get(strategy);
	}
	
	/**
	 * Dangerous Animal] [Size]
	 * @return
	 */
	private String genDangerousAnimal(){
		Random rand = new Random();
		int animal = rand.nextInt(sAnimal.size());
		return sAnimal.get(animal);
	}
	
	/**
	 * [Hazard]
	 * @return
	 */
	private String genHazard(){
		Random rand = new Random();
		int hazard = rand.nextInt(sHazards.size());
		return sHazards.get(hazard);
	}
	
	/**
	 * [Of Value]
	 * @return
	 */
	private String genOfValue(){
		Random rand = new Random();
		int value = rand.nextInt(sLoot.size());
		return sLoot.get(value);
	}
	
	/**
	 * [Benign]
	 * @return
	 */
	private String genBenign(){
		Random rand = new Random();
		int benign = rand.nextInt(sBenign.size());
		return sBenign.get(benign);
	}
	
	private boolean isBetween(int toCheck, int pLow, int pHigh) {
		if(toCheck >= pLow && toCheck <= pHigh)
		{
			return true;
		} else {
			return false;
		}
	}
	
	private static final ArrayList<String> sActivities = ReadFileUtil.getList("CivilizedCountrySide_Activity.txt");
	private static final ArrayList<String> sAmbush = ReadFileUtil.getList("CivilizedCountrySide_Ambush.txt");
	private static final ArrayList<String> sAnimal = ReadFileUtil.getList("CivilizedCountrySide_Animal.txt");
	private static final ArrayList<String> sBenign = ReadFileUtil.getList("CivilizedCountrySide_Benign.txt");
	private static final ArrayList<String> sHazards = ReadFileUtil.getList("CivilizedCountrySide_Hazards.txt");
	private static final ArrayList<String> sLoot = ReadFileUtil.getList("CivilizedCountrySide_Loot.txt");
	private static final ArrayList<String> sPeople = ReadFileUtil.getList("CivilizedCountrySide_People.txt");
	private static final ArrayList<String> sProfessional = ReadFileUtil.getList("CivilizedCountrySide_Professional.txt");
	private static final ArrayList<String> sRuse = ReadFileUtil.getList("CivilizedCountrySide_Ruse.txt");
	private static final ArrayList<String> sStrategy = ReadFileUtil.getList("CivilizedCountrySide_Strategy.txt");
	private static final ArrayList<String> sWorkingClass = ReadFileUtil.getList("CivilizedCountrySide_WorkingClass.txt");
	
}
