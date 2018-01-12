package guiPlayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogMaker {

	private ArrayList<VideoGame> Catalog;

	public CatalogMaker() {
		Catalog = new ArrayList<VideoGame>();
		Catalog.add(new VideoGame("Portal 2","Valve","2012"));
		Catalog.add(new VideoGame("CS:GO","Valve","2011"));
		Catalog.add(new VideoGame("Overwatch","Blizzard","2015"));
		Catalog.add(new VideoGame("Left 4 Dead 2","Valve","2013"));
		Catalog.add(new VideoGame("Team Fortress 2","Valve","2007"));
		Catalog.add(new VideoGame("HearthStone","Blizzard","2014"));
	}

	public static void main(String[] args) {

		CatalogMaker test = new CatalogMaker();
		System.out.println(test.getCSVContent());
		System.out.println("Type what you would like to add to the Video Game List");
		Scanner in = new Scanner(System.in);
		String a = in.nextLine();
		System.out.println("Type who made it!");
		while(!a.equals("done")) {
			String b = in.nextLine();
			System.out.println("Type when it was released!");
			String c = in.nextLine();
			test.addNewGame(new VideoGame(a,b,c));
			System.out.println("Type who made it or type 'done' to stop.");
			a = in.nextLine();
		}
		System.out.println("Type what you would like the file to be saved as.");
		String fileName = in.nextLine();
		test.testSaveContent(fileName);
		System.out.println("Here is the new CSV file.");
		System.out.println(test.getCSVContent());
		System.out.println("Would you like to load a file? \n");
		a = in.nextLine();
		if(a.equals("yes")) {
			test.testFileLoading();
		}else {
			in.close();
			System.out.println("Okay, Thank you, Goodbye!");
		}
	}

	public String getCSVContent() {
		String data = "Title,Company,Year\n";
		for(VideoGame vg: Catalog) {
			data += vg+"\n";
		}
		return data;
	}

	public void addNewGame(VideoGame vg) {
		Catalog.add(vg);
		System.out.println("Item added!");
	}

	public void testSaveContent(String fileName) {
		try{    
			FileWriter fw = new FileWriter(fileName+".csv");    
			for(VideoGame vg: Catalog)
				fw.write(vg+"\n");
			System.out.println("Success! File \""+fileName+"\" saved!");
			fw.close();
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}
	}

	public List<String> testFileLoading() {
		Scanner in = new Scanner(System.in);
		String fileName = "";
		List<String> content = new ArrayList<String>();
		//use this boolean to control the while loop. The user should have multiple chances to enter a correct filename
		boolean opened = false;
		while(!opened){
			try {
				System.out.println("Enter a file to open");
				fileName = in.nextLine();
				FileReader fileReader = new FileReader(new File(fileName));
				String line = "";
				//a BufferedReader enables us to read the file one line at a time
				BufferedReader br = new BufferedReader(fileReader);
				while ((line = br.readLine()) != null) {
					String[] parem = line.split(",");
					Catalog.add(new VideoGame(parem[0],parem[1],parem[2]));
				}
				br.close();
				opened = true;
			}catch (IOException e) {
				System.out.println("The file name you specified does not exist.");
			}
		}
		//close the Scanner
		in.close();
		return content;
	}
	
	public ArrayList<VideoGame> getCatalog() {
		return Catalog;
	}
} 