public class Song {
	
	private int timesPlayedToday;
	private int durationInSeconds;
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
	
	public void playSong(){
		
		if(this.timesPlayedToday >= 3 ){
			System.out.println("Sorry, this song was already played three times today!");
		}
		else{
			// song.play();
			this.timesPlayedToday++;
		}
	} // Ends Method playSong
	

}
