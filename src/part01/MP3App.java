package part01;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class MP3App extends MP3Player {

	static Scanner input = new Scanner(System.in);	
	static MP3Player myPlayer = new MP3Player();

	public static void main(String[] args) throws FileNotFoundException {
		String menuOptions[] = { "Select from Full List", "Select Tune by Artist", "Select Tune by Genre",
				"Add New Tune", "Display the Top 10", "Switch On", "Switch Off", "Exit"};
		Menu appMenu = new Menu("MP3 Player", menuOptions);
		addSomeTunes();
		
		int option = appMenu.getUserChoice();
		while (option != menuOptions.length) {
				processOption(option);
				option = appMenu.getUserChoice();
		}
		System.out.println("Goodbye!");

	}
	
	public static void addSomeTunes() {
		try {
			myPlayer.addTune("One1", "U2", 380, Genre.ROCK);
			myPlayer.addTune("Four Seasons - Winter1", "Vivaldi", 5500, Genre.CLASSICAL);
			myPlayer.addTune("The Chain1", "Fleetwood Mac", 750, Genre.ROCK);
			myPlayer.addTune("Graceland1", "Paul Simon", 350, Genre.POP);
			myPlayer.addTune("Help1", "The Beatles", 300, Genre.POP);
			myPlayer.addTune("One2", "U2", 380, Genre.ROCK);
			myPlayer.addTune("Four Seasons - Winter2", "Vivaldi", 5500, Genre.CLASSICAL);
			myPlayer.addTune("The Chain2", "Fleetwood Mac", 750, Genre.ROCK);
			myPlayer.addTune("Graceland2", "Paul Simon", 350, Genre.POP);
			myPlayer.addTune("Help2", "The Beatles", 300, Genre.POP);
			myPlayer.addTune("One3", "U2", 380, Genre.ROCK);
			myPlayer.addTune("Four Seasons - Winter3", "Vivaldi", 5500, Genre.CLASSICAL);
			myPlayer.addTune("The Chain3", "Fleetwood Mac", 750, Genre.ROCK);
			myPlayer.addTune("Graceland3", "Paul Simon", 350, Genre.POP);
			myPlayer.addTune("Help3", "The Beatles", 300, Genre.POP);
		} catch  (Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	
	public static void processOption(int choice) throws FileNotFoundException {
		switch(choice) {
		case 1	:	selectFullList();
					System.out.println();
					break; 
		case 2	:	selectByArtist();
					System.out.println();
					break; 
		case 3	:	selectByGenre();
					System.out.println();
					break; 
		case 4	:	addNewTune();
					System.out.println();
					break; 
		case 5	:	displayTopTen();
					System.out.println();
					break; 
		case 6	:	turnOn();
					System.out.println();
					break; 
		case 7	:	turnOff();
					System.out.println();
					break; 

		default: System.out.println("Option "+choice+" is invalid.");
					
		}
		System.out.println();
	}

	private static void bubbleSort(String[] data) {
		int swaps;
		do {
			swaps = 0;
			for(int index=0;index<data.length-1;index++) {
				if (data[index].compareTo(data[index+1]) > 0) {
					String temp = data[index];
					data[index] = data[index+1];
					data[index+1] = temp;
					swaps++;
				}
			}
		}
		while(swaps>0);
	}
	
	private static void selectFullList() {
		if (myPlayer.getTuneInfo()!=null) {
			String[] allList = myPlayer.getTuneInfo();
			String[] tempList = new String[allList.length];
			int index = 0;
			for (String s: allList
			) {
				tempList[index]=s;
				index++;
			}
			for (int i = 0; i < allList.length; i++) {
				String[] allSplitted = allList[i].split(",",6);
				allList[i] = allSplitted[1]+" by "+allSplitted[2];
			}
			Menu menu = new Menu("Select a Tune",allList );
			int choice = menu.getUserChoice();
			int selected = Integer.parseInt(tempList[choice-1].split(",", 5)[0]);
			String[] selectedTune = myPlayer.play(selected).split(",");
			System.out.println("Now Playing ...\t" + selectedTune[1]+", by"+selectedTune[2]);
		}
		else{
			System.out.println("No such tune found!");
		}
	}
	public static boolean contains(ArrayList<String> allArtists, String value){
		for (int i = 0; i < allArtists.size(); i++) {
			if (value.equals(allArtists.get(i))){
				return true;
			}
		}
		return false;
	}
	private static void selectByArtist() {
		ArrayList<String> allArtists = new ArrayList<String>();
		try{
			for (String tune : myPlayer.getTuneInfo()) {
				if (!contains(allArtists,tune.split(",", 5)[2])) {
					allArtists.add(tune.split(",", 5)[2]);
				}
			}
			String[] allStringsArray = allArtists.toArray(new String[0]);
			Menu menu = new Menu("All Artists", allStringsArray);
			int choice = menu.getUserChoice();
			String[] artistTunes = myPlayer.getTuneInfo(allStringsArray[choice - 1]);
			if (artistTunes != null) {
				String[] tempList = new String[artistTunes.length];
				int index = 0;
				for (String s: artistTunes
					 ) {
					tempList[index]=s;
					index++;
				}
				for (int i = 0; i < artistTunes.length; i++) {
					String[] allSplitted = artistTunes[i].split(",",6);
					artistTunes[i] = allSplitted[1]+" by "+allSplitted[2];
				}

				menu = new Menu("Select a Tune - Artist: "+allStringsArray[choice - 1], artistTunes);
				choice = menu.getUserChoice();
				int selected = Integer.parseInt(tempList[choice - 1].split(",", 5)[0]);
				String[] selectedTune = myPlayer.play(selected).split(",");
				System.out.println("Now Playing ...\t" + selectedTune[1]+", by"+selectedTune[2]);
			} else {
				System.out.println("No such tune found!");
			}
		}catch (Exception e){
			System.out.println(e);
			System.out.println("No artist found!");
		}
	}
	
	private static void selectByGenre() {
		String[] allGenre = new String[Genre.values().length];
		int counter=0;
		for (Genre genre:Genre.values()){
			allGenre[counter]=genre.toString();
			counter++;
		}
		Menu menu = new Menu("All Generes",allGenre);
		int choice = menu.getUserChoice();
		String[] genreTunes = myPlayer.getTuneInfo(Genre.values()[choice-1]);
		if(genreTunes!=null){
			String[] tempList = new String[genreTunes.length];
			int index = 0;
			for (String s: genreTunes
			) {
				tempList[index]=s;
				index++;
			}

			for (int i = 0; i < genreTunes.length; i++) {
				String[] allSplitted = genreTunes[i].split(",",6);
				genreTunes[i] = allSplitted[1]+" by "+allSplitted[2];
			}

			menu = new Menu("Select a Tune - Genre: "+allGenre[choice - 1],genreTunes);
			choice = menu.getUserChoice();
			int selected = Integer.parseInt(tempList[choice-1].split(",", 5)[0]);
			String[] selectedTune = myPlayer.play(selected).split(",");
			System.out.println("Now Playing ...\t" + selectedTune[1]+", by"+selectedTune[2]);
		}
		else{
			System.out.println("No such tune found!");
		}
	}

	private static void addNewTune() {
		try {
			Scanner myObj = new Scanner(System.in);
			System.out.println("Enter Tune Title: ");
			String title = myObj.nextLine();
			System.out.println("Enter Tune Artist: ");
			String artist = myObj.nextLine();
			System.out.println("Enter Tune Duration(in seconds): ");
			int duration = myObj.nextInt();
			String[] allGenre = new String[Genre.values().length];
			int counter = 0;
			for (Genre genre : Genre.values()) {
				allGenre[counter] = genre.toString();
				counter++;
			}
			Menu menu = new Menu("Select Tune Genre: ", allGenre);
			int choice = menu.getUserChoice();
			Genre genre = Genre.values()[choice - 1];
			try{
			if (myPlayer.addTune(title, artist, duration, genre)) {
				System.out.println("Tune added successfully:-)");
			} else {
				System.out.println("Something Went Wrong...!");
			}
			}catch (Exception e){
				System.out.println("Turn On MP3 Player!");
			}
		} catch (Exception e) {
			System.out.println("Invalid Input!");
		}
	}

	private static void displayTopTen() {
		if (myPlayer.getTuneInfo()!=null) {
			String[] tunes = myPlayer.getTuneInfo();

			String[] allPlays = new String[tunes.length];
			for (int i = 0; i < tunes.length; i++) {
				allPlays[i]=tunes[i].split(", ", 6)[4];
			}
			bubbleSort(allPlays);
			for (int i = 0; i < allPlays.length; i++) {
				for (int j = 0; j < tunes.length; j++) {
					if(tunes[j].split(", ", 6)[4].equals(allPlays[i])){
						ArrayList allPlaysArrayList = new ArrayList<String>(Arrays.asList(allPlays));
						if(!contains(allPlaysArrayList,tunes[j])) {
							allPlays[i] = tunes[j];
							break;
						}
					}
				}
			}
			String[] topTen = new String[10];
			for (int i = 0; i < topTen.length; i++) {
				topTen[i] = allPlays[i].split(",",6)[0]+"\t"+allPlays[i].split(",",6)[1]+"\t"+allPlays[i].split(",",6)[4];
			}



			String[] temperaryList = new String[topTen.length];
			int index = 0;
			for (String s: topTen
			) {
				temperaryList[index]=s;
				index++;
			}

			for (int i = 0; i < topTen.length; i++) {
				String[] allSplitted = topTen[i].split("\t",6);
				topTen[i] = allSplitted[1]+" played "+allSplitted[2]+" times";
			}
			Menu menu = new Menu("Top ten Tunes",topTen);
			int choice = menu.getUserChoice();
			int selected = Integer.parseInt(temperaryList[choice-1].split("\t")[0]);
			String[] selectedTune = myPlayer.play(selected).split(",");
			System.out.println("Now Playing ...\t" + selectedTune[1]+", by"+selectedTune[2]);
		}
		else{
			System.out.println("No such tune found!");
		}

	}
	
	private static void turnOff() {
		if (myPlayer.switchOff()){
			System.out.println("MP3 Player turned off!");
		}
		else{
			System.out.println("MP3 Player is already turned off!");
		}
		
	}
	
	private static void turnOn() throws FileNotFoundException {
		if (myPlayer.switchOn()){
			System.out.println("MP3 Player turned on!");
		}
		else{
			System.out.println("MP3 Player is already turned on!");
		}
		
	}
	
	
}
