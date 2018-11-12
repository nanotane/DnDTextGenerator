package nanotane.DnDGeneratorWindow.generators;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Stream;

import javax.swing.JButton;

public class CustomGenerator {
	
	public static final String sCustomListsLoc = "resources/nanotane/customlists/";
	public static Map<String, List<String>> sCustomListsMap = new HashMap<>();

	/**
	 * Load the custom txt files from our custom list location
	 */
	public static void loadFiles()
	{
		//Lets walk through the files
		try (Stream<Path> paths = Files.walk(Paths.get(sCustomListsLoc))) {
			//Check if its a regular file
		    paths.filter(Files::isRegularFile)
		         //Now filter out anything thats not a TXT file
		    	 //Note that this is a simple check and can be fooled!
		    	 .filter(pPath ->pPath.toString().contains(".txt"))
		    	 //Now for each, read the file
		         .forEach(CustomGenerator::readInFile);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * Create and return a list of JButtons based on the custom files loaded.
	 * Their color and action will be set but their their dimensions and location
	 * are not.
	 * @param pBackground background color
	 * @param pForGround forground color
	 * @param pToAdd method that will take in our determined string and do something with it.
	 * Most likely add it to the screen
	 * @return
	 */
	public static List<JButton> getCustomButtons(Color pBackground, Color pForGround, Consumer<String> pToAdd)
	{
		List<JButton> newList = new ArrayList<>();
		sCustomListsMap.forEach((aKey, list) ->{
			JButton aButton = new JButton(aKey);
			aButton.setForeground(pForGround);
			aButton.setBackground(pBackground);
			aButton.addActionListener(event ->{
				Random rand = new Random();
				int loc = rand.nextInt(list.size());
				pToAdd.accept(list.get(loc));
			});
			newList.add(aButton);
		});
		return newList;
	}
	
	private static void readInFile(Path pPath)
	{
        // This will reference one line at a time
        String line = null;
        String buttonName = null;
        ArrayList<String> contents = new ArrayList<String>();

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(pPath.toFile());

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) 
            {
            	//If we have the name of the file
            	if(line.contains("$"))
            	{
            		buttonName = line.substring(1);
            	} else {
            		contents.add(line);
            	}
            }   

            // Always close files.
            bufferedReader.close();     
            
            //Now add things to the map
            sCustomListsMap.put(buttonName, contents);
        }
        catch(FileNotFoundException ex) {
        		System.out.println(
        	                "file '" + 
        	                		pPath + "' not found.");
        } catch (IOException e) {
        	System.out.println("IO Exception ocurred");
			e.printStackTrace();
		}
	}
}
