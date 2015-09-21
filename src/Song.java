import java.time.LocalDate;

public class Song {
	
	private int timesPlayedToday = 0;
	private int durationInSeconds;
	private LocalDate lastTimePlayed = LocalDate.now();
	private String myTitle;
	private String myArtist;
	private String filename;
	
	
	public Song(String name, String artist, String filename, int duration){
		this.myTitle   = name;
		this.myArtist = artist;
		this.filename = filename;
		this.durationInSeconds = duration;
	} // Ends Constructor
	
	public int getTimesPlayedToday(){
		return this.timesPlayedToday;
	} // Ends Method getTimesPlayedToday
	
	public int getDurationOfSong(){
		return this.durationInSeconds;
	} // Ends Method getDurationOfSong
	
	public String getTitle(){
		return this.myTitle;
	} // Ends Method getTitle
	
	public String getArtist(){
		return this.myArtist;
	} // Ends Method getArtist
	
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
