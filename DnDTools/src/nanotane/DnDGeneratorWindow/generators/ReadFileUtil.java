package nanotane.DnDGeneratorWindow.generators;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * A simple utility class that will read the contents of a 
 * file and export those contents as an array list
 * @author Ian
 *
 */
public class ReadFileUtil
{

	public static final String sListsLocation = "resources/nanotane/DnDTools/generator/lists/";
	private ReadFileUtil()
	{
		//Util class
	}
	/**
	 * This will print all of the contents of a string array
	 * @param contents
	 */
//	public void writeAll(String fileName,  ArrayList<String>contents) {
//		//make the file and handle exceptions
//		FileWriter fw = null;
//		try {
//			fw = new FileWriter(fileName);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		//print things out
//		PrintWriter pw = new PrintWriter(fw, true);
//		for(int i = 0; i < contents.size(); i++)
//		{
//			pw.println(contents.get(i));
//		}
//		
//		//close everything
//		try {
//			fw.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		pw.close();
//	}
	
	/**
	 * Read the contents of the file and return them as an array list
	 * @param fileName
	 * @return contents an array list
	 */
	public static ArrayList<String> getList(String fileName)
	{
        // This will reference one line at a time
        String line = null;
        ArrayList<String> contents = new ArrayList<String>();

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(sListsLocation+fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) 
            {
            	contents.add(line);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
        		System.out.println(
        	                "file '" + 
        	                fileName + "' not found.");
            return null;
        } catch (IOException e) {
        	System.out.println("IO Exception ocurred");
			e.printStackTrace();
			return null;
		}
        
        return contents;
	}
}
