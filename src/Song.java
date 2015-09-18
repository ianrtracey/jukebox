public class Song {
	
	private int timesPlayedToday;
	private int durationInSeconds;
	private String myTitle;
	private String myArtist;
	
	
	public Song(String name, String artist, int duration){
		this.myTitle   = name;
		this.myArtist = artist;
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
