/*+----------------------------------------------------------------------
 ||
 ||  Class Song
 ||
 ||        Purpose:  Represents a Song entry into the JukeBox Implementation
 ||
 |+-----------------------------------------------------------------------
 ||
 ||        Methods: public Song(String name, String artist, String filename, int duration)
 ||					public int getTimesPlayedToday()
 ||					public int getDurationOfSong()
 ||					public String getTitle()
 ||					public String getArtist()
 ||					public String getFileName()
 ||					public void setLastTimePlayed(LocalDate date)
 ||					public void updateNumOfPlays()
 ||					public void play()
 ||					public boolean canPlay()
 ||
 ++-----------------------------------------------------------------------*/
package model;
import java.time.LocalDate;

public class Song {
	
	private int timesPlayedToday = 0;					// How many times played today?
	private int durationInSeconds;						// How long is the song in seconds?
	private LocalDate lastTimePlayed = LocalDate.now();	// What was the last time played?
	private String myTitle;								// What is the song title?
	private String myArtist;							// Who is the song artist?
	private String filename;							// What is the song filename?
	
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
	
	public String getFileName(){
		return this.filename;
	} // Ends Method getArtist
	
	// Used for testing
	public void setLastTimePlayed(LocalDate date) {
		this.lastTimePlayed = date;
	} // Ends setLastTimePlayed
	
	public void updateNumOfPlays() {
		if( this.lastTimePlayed.equals(LocalDate.now())) {
			this.timesPlayedToday++;
		} else {
			this.lastTimePlayed = LocalDate.now();
			this.timesPlayedToday = 1;
		}
	} // Ends Method updateNumOfPlays
	
	public void play(){
		if( canPlay() ){
			updateNumOfPlays();
			// song do stuff
		}
		else{
			// dont play
		}
	} // Ends Method play
	
	public boolean canPlay() {
		if ( this.timesPlayedToday < 3 || !this.lastTimePlayed.equals(LocalDate.now())) {
			return true;
		} 
		return false;
	} // Ends Method canPlay
} // Ends Class Song
