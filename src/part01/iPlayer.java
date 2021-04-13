package part01;

import java.io.FileNotFoundException;

public interface iPlayer {
	public String[] getTuneInfo();
	public String[] getTuneInfo(String artist);
	public String[] getTuneInfo(Genre gen);
	public String play(int tuneId);
	public boolean addTune(String title, String artist, int duration, Genre gen);
	public boolean switchOn() throws FileNotFoundException;
	public boolean switchOff();
}
