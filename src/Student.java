import java.time.LocalDate;

import model.Song;

public class Student {
	
	private String id;
	private int password;
	private int numOfSongsPlayedToday;
	private int lifetimeSecondsRemaining;
	private LocalDate lastTimeSelectedSong; 
	
	
	public Student(String id, int password) {
		
		this.id 	  = id;
		this.password = password;
		this.numOfSongsPlayedToday = 0;
		this.lifetimeSecondsRemaining = (1500 * 60);
		this.lastTimeSelectedSong = LocalDate.now();
	}
	
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
	}
	
		
	public boolean canPlaySong(int songLength) {
		
		return hasStudentPlayedNumOfSongsToday(3) && willStudentExceedTimeLimit(songLength);
		
	}
	
	private boolean hasStudentPlayedNumOfSongsToday(int numOfSongsAllowed) {
		
		return this.numOfSongsPlayedToday < numOfSongsAllowed;
	}
	
	private boolean willStudentExceedTimeLimit(int songLength) {
		
		return (this.getLifetimeSecondsRemaining() - songLength) > 0;
	}
	
	
	
	/*
	 *  GETTERS AND SETTERS
	 */
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public int getNumOfSongsPlayedToday() {
		return numOfSongsPlayedToday;
	}

	public void setNumOfSongsPlayedToday(int numOfSongsPlayedToday) {
		this.numOfSongsPlayedToday = numOfSongsPlayedToday;
	}

	public int getLifetimeSecondsRemaining() {
		return lifetimeSecondsRemaining;
	}

	public void setLifetimeSecondsRemaining(int lifetimeSecondsPlayed) {
		this.lifetimeSecondsRemaining = lifetimeSecondsPlayed;
	}
	
	

}
