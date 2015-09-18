import java.util.HashMap;

public class SongCollection {

	HashMap<String, Song> songs = new HashMap<String, Song>();
	
	public SongCollection(){
		populateSongs();
	}
	

	
	
	public int getSize() {
		return songs.size();
	}
	
	public boolean add(Song song) {
		if (!songs.containsKey(String.format("%s/%s", song.getTitle(), song.getArtist()))) {
			songs.put(String.format("%s/%s", song.getTitle(), song.getArtist()), song);
			return true;
		}
		
		return false;
	}
	
	public Song get(String songName) {
		return songs.get(songName);
	}
	
	private void populateSongs(){
		songs.put("Where Brooklyn At?/Biggie Smalls", new Song("Where Brooklyn At?",  "Biggie Smalls", 180));
		
		
	}
	
	
}
