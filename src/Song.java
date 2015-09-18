import java.time.LocalDate;

public class Song {
	
	private int timesPlayedToday = 0;
	private int durationInSeconds;
	private LocalDate lastTimePlayed = LocalDate.now();
	private String myTitle;
	private String myArtist;
	
	
	public Song(String name, String artist, int duration){
		this.myTitle   = name;
		this.myArtist = artist;
		this.durationInSeconds = duration;
	}
	
	public int getTimesPlayedToday(){
		return this.timesPlayedToday;
	}
	
	public int getDurationOfSong(){
		return this.durationInSeconds;
	}
	
	public String getTitle(){
		return this.myTitle;
	}
	
	public String getArtist(){
		return this.myArtist;
	}
	
	// Used for testing
	public void setLastTimePlayed(LocalDate date) {
		this.lastTimePlayed = date;
	}
	
	public void updateNumOfPlays() {
		
		if( this.lastTimePlayed.equals(LocalDate.now())) {
			this.timesPlayedToday++;
		} else {
			this.lastTimePlayed = LocalDate.now();
			this.timesPlayedToday = 1;
		}
		
	}
	
	
	public void play(){
		
		if( canPlay() ){
			
			updateNumOfPlays();
			// song do stuff
		}
		else{
			// dont play
		}
	} 
	
	public boolean canPlay() {
		if ( this.timesPlayedToday < 3 || !this.lastTimePlayed.equals(LocalDate.now())) {
			return true;
		} 
		
		return false;
	}
	
	

}
