package part01;

public class Tune implements iTune  {

	private int id; 
	private static int nextId = 1; 
	private String title;



	private String artist;
	private int duration; 
	private int playCount; 
	private Genre style; 
	
	
	public Tune(String title, String artist, int duration, Genre gen) {
		setTitle(title);
		setArtist(artist);
		setDuration(duration);
		setGenre(gen);
		this.id = nextId(); 		
	}
	
	private int nextId() {
		int songId = nextId;
		nextId++;
		return songId;
	}
	
	public void setTitle(String title) {
		if ( title != null ) {
			this.title = title; 
		} else {
			this.title = "Invalid";
		}
	}
	
	public void setArtist(String artist) {
		if ( artist != null ) {
			this.artist = artist; 
		} else {
			this.artist = "Invalid";
		}
	}
	
	public void setDuration(int duration) {
		if ( duration > 0 ) {
			this.duration = duration;
		} else {
			this.duration = 0; 
		}
	}
	
	public void setGenre(Genre gen) {
		if ( gen != null ) {
			this.style = gen; 
		} else {
			this.style = Genre.OTHER;
		}
	}

	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}
	public int getPlayCount() {	return playCount;}
	public int getSongId() {
		return this.id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getArtist() {
		return this.artist;
	}
	
	public int getDuration() {
		return this.duration;
	}
	
	public Genre getGenre() {
		return this.style;
	}

	
	public String toString() {
		String res = "";
		res += this.getSongId() + ", " + this.getTitle() + ", ";
		res += this.getArtist() + ", " + this.getDuration() + ", ";
		res += this.getPlayCount()+", ";
		res += this.style.toString();
		return res;
	}
	
	public String play() {
		return this.toString();
	}
	
}
