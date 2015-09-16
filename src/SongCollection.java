import java.util.HashMap;

public class SongCollection {

	HashMap<String, Song> Songs = new HashMap<String, Song>();
	
	public SongCollection(){
		populateSongs();
	}
	

	
	private void populateSongs(){
		Songs.put("Where Brooklyn At/Biggie Smalls", new Song("Where Brooklyn At?",  "Biggie Smalls", 180));
		
	}
	
	
}
