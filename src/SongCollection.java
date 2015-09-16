import java.util.HashMap;

public class SongCollection {

	HashMap<String, Song> songs = new HashMap<String, Song>();
	
	public SongCollection(){
		populateSongs();
	}
	

	
	private void populateSongs(){
		songs.put("Where Brooklyn At/Biggie Smalls", new Song("Where Brooklyn At?",  "Biggie Smalls", 180));
		
	}
	
	public int getSize() {
		return songs.size();
	}
	
	
}
