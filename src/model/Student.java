/*+----------------------------------------------------------------------
 ||
 ||  Class Student
 ||
 ||        Purpose:  Represents a Student entry into the JukeBox Implementation
 ||
 |+-----------------------------------------------------------------------
 ||
 ||        Methods: public Student(String id, int password)
 ||                 public boolean selectSong(Song song)
 ||					public boolean canPlaySong(int songLength)
 ||                 private boolean hasStudentPlayedNumOfSongsToday(int numOfSongsAllowed)
 ||                 private boolean willStudentExceedTimeLimit(int songLength)
 ||                 public String getId()
 ||					public void setId(String id)
 ||					public int getPassword() 
 ||					public void setPassword(int password)
 ||					public int getNumOfSongsPlayedToday()
 ||					public void setNumOfSongsPlayedToday(int numOfSongsPlayedToday)
 ||					public int getLifetimeSecondsRemaining()
 ||					public void setLifetimeSecondsRemaining(int lifetimeSecondsPlayed)
 ||
 ++-----------------------------------------------------------------------*/
package model;
import java.io.Serializable;
import java.time.LocalDate;

public class Student implements Serializable {
	
	private String id;						// Student ID
	private int password;					// Student's password
	private int numOfSongsPlayedToday;		// How many times did the student request a song today?
	private int lifetimeSecondsRemaining;   // How many more seconds of time does this student have?
	private LocalDate lastTimeSelectedSong; // What was the last time this student requested a song?
	
	public Student(String id, int password) {
		this.id 	  = id;
		this.password = password;
		this.numOfSongsPlayedToday = 0;
		this.lifetimeSecondsRemaining = (1500 * 60);
		this.lastTimeSelectedSong = LocalDate.now();
	} // Ends Constructor
	
	public boolean selectSong(Song song) {
		if ( !canPlaySong(song.getDurationOfSong()) ) {	
			return false;		
		}
		if ( this.lastTimeSelectedSong.equals(LocalDate.now()) ){
			numOfSongsPlayedToday++;		
		} else {
			this.lastTimeSelectedSong = LocalDate.now();
			numOfSongsPlayedToday = 1;	
		}
			this.lifetimeSecondsRemaining = this.lifetimeSecondsRemaining - song.getDurationOfSong();
			return true;
	} // Ends Method selectSong
	
	public boolean canPlaySong(int songLength) {
		return hasStudentPlayedNumOfSongsToday(3) && willStudentExceedTimeLimit(songLength);
	} // Ends Method canPlaySong
	
	private boolean hasStudentPlayedNumOfSongsToday(int numOfSongsAllowed) {	
		return this.numOfSongsPlayedToday < numOfSongsAllowed;
	} // Ends Method hasStudentPlayedNumOfSongsToday
	
	private boolean willStudentExceedTimeLimit(int songLength) {
		return (this.getLifetimeSecondsRemaining() - songLength) > 0;
	} // Ends Method willStudentExceedTimeLimit
	
	// GETTERS AND SETTERS
	public String getId() {
		return id;
	} // Ends Method getId

	public void setId(String id) {
		this.id = id;
	} // Ends Method setId

	public int getPassword() {
		return password;
	} // Ends Method getPassword

	public void setPassword(int password) {
		this.password = password;
	} // Ends Method setPassword

	public int getNumOfSongsPlayedToday() {
		return numOfSongsPlayedToday;
	} // Ends Method getNumSongsPlayedToday

	public void setNumOfSongsPlayedToday(int numOfSongsPlayedToday) {
		this.numOfSongsPlayedToday = numOfSongsPlayedToday;
	} // Ends Method setNumOfSongsPlayedToday

	public int getLifetimeSecondsRemaining() {
		return lifetimeSecondsRemaining;
	} // Ends Method getLifetimeSecondsRemaining

	public void setLifetimeSecondsRemaining(int lifetimeSecondsPlayed) {
		this.lifetimeSecondsRemaining = lifetimeSecondsPlayed;
	} // Ends Method setLifetimeSecondsRemaining
} // Ends Class Student
