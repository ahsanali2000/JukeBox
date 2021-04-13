package part01;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MP3Player implements iPlayer {
		
	protected ArrayList<Tune> soundData;
	
	public MP3Player() {
		
		this.soundData = new ArrayList<Tune>();
		
	}
	private void bubbleSort(String[] data) {
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
	
	public String[] getTuneInfo() {
		try {
			String[] tunes = new String[soundData.size()];

			if (soundData.size() > 0) {
				for (int index = 0; index < soundData.size(); index++) {
					Tune tune = soundData.get(index);
					String str = tune.toString();
					tunes[index] = str;
				}
				String[] allTitles = new String[tunes.length];
				for (int i = 0; i < tunes.length; i++) {
					allTitles[i] = tunes[i].split(", ", 6)[1];
				}
				int counter = 0;
				bubbleSort(allTitles);

				for (int i = 0; i < allTitles.length; i++) {
					for (int j = 0; j < tunes.length; j++) {
						if (tunes[j].split(", ", 6)[1].equals(allTitles[i])) {
							allTitles[i] = tunes[j];
							break;
						}
					}
				}
				return allTitles;
			}
			return null;
		}catch(Exception e){
			System.out.println("No tune to fetch!");
			return null;
		}
	}

	public String[] getTuneInfo(String artist) {
		try{
			ArrayList<String> tunes = new ArrayList<String>();
			for (Tune tune : soundData) {
				if (tune.getArtist().replaceAll("\\s", "").equals(artist.replaceAll("\\s", ""))){
					tunes.add(tune.toString());
				}
			}
			if(tunes.size()>0) {
				return (String[]) tunes.toArray(new String[0]);
			}
			return null;
		}catch(Exception e){
			System.out.println("MP3 Player is switched off!");
			return null;
		}
	}

	public String[] getTuneInfo(Genre gen) {
		try {
			ArrayList<String> tunes = new ArrayList<String>();
			for (Tune tune : soundData) {
				if (tune.getGenre().equals(gen)){
					tunes.add(tune.toString());
				}
			}
			if(tunes.size()>0) {
				return (String[]) tunes.toArray(new String[0]);
			}
			return null;
		}catch(Exception e){
			System.out.println("No tune to fetch!");
			return null;
		}
		
	}

	public String play(int tuneId) {
		for (Tune tune : soundData) {
			if (tune.getSongId()==(tuneId)){
				int plays = tune.getPlayCount();
				tune.setPlayCount(++plays);
				return tune.toString();
			}
		}
		return null;
	}

	public boolean addTune(String title, String artist, int duration, Genre gen) {
		for (Tune tune : soundData) {
			if (tune.getTitle().equals(title) && tune.getArtist().equals(artist) && tune.getDuration()==duration && tune.getGenre().equals(gen)){
				return false;
			}
		}
		soundData.add(new Tune(title, artist, duration, gen));
		return true;

	}
	

	public boolean switchOn() throws FileNotFoundException {
		if (soundData==null){
			new MP3Player();
			return true;
		}
		return false;
	}

	public boolean switchOff() {
		if(soundData==null){
			return false;
		}
		soundData=null;
		return true;
	}
		
}
