package nanotane.DnDGeneratorWindow.TrevorScot;

import java.util.ArrayList;

import nanotane.DnDGeneratorWindow.generators.ReadFileUtil;

public final class TrevoScotLists {
	
	//Civilized Country side
	public static final ArrayList<String> ACTIVITES = ReadFileUtil.getList("CivilizedCountrySide_Activity.txt");
	public static final ArrayList<String> CIV_COUNTRYSIDE_AMBUSH = ReadFileUtil.getList("CivilizedCountrySide_Ambush.txt");
	public static final ArrayList<String> ANIMAL = ReadFileUtil.getList("CivilizedCountrySide_Animal.txt");
	public static final ArrayList<String> CIV_COUNTRYSIDE_BENIGN = ReadFileUtil.getList("CivilizedCountrySide_Benign.txt");
	public static final ArrayList<String> HAZARDS = ReadFileUtil.getList("CivilizedCountrySide_Hazards.txt");
	public static final ArrayList<String> CIV_COUNTRYSIDE_LOOT = ReadFileUtil.getList("CivilizedCountrySide_Loot.txt");
	public static final ArrayList<String> PEOPLE = ReadFileUtil.getList("CivilizedCountrySide_People.txt");
	public static final ArrayList<String> PROFESSIONAL = ReadFileUtil.getList("CivilizedCountrySide_Professional.txt");
	public static final ArrayList<String> CIV_COUNTRYSIDE_RUSE = ReadFileUtil.getList("CivilizedCountrySide_Ruse.txt");
	public static final ArrayList<String> AMBUSH_STRATEGY = ReadFileUtil.getList("CivilizedCountrySide_Strategy.txt");
	public static final ArrayList<String> WORKING_CLASS = ReadFileUtil.getList("CivilizedCountrySide_WorkingClass.txt");
	//Urban Safe
	public static final ArrayList<String> URBAN_SAFE_AMBUSH = ReadFileUtil.getList("UrbanSafe_Ambush.txt");
	public static final ArrayList<String> URBAN_SAFE_BENIGN = ReadFileUtil.getList("UrbanSafe_Benign.txt");
	public static final ArrayList<String> URBAN_SAFE_RUSE = ReadFileUtil.getList("UrbanSafe_Ruse.txt");
}
