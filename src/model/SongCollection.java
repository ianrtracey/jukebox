/*+----------------------------------------------------------------------
 ||
 ||  Class SongCollection
 ||
 ||        Purpose:  Represents a collection of Song objects for the
 ||                  JukeBox implementation
 ||
 |+-----------------------------------------------------------------------
 ||
 ||        Methods: public SongCollection()
 ||                 public int getSize()
 ||					public boolean add(Song song)
 ||                 public Song getSong(String songName)
 ||                 public HashMap<String, Song> getSongsMap()
 ||                 private void populateSongs()
 ||
 ++-----------------------------------------------------------------------*/
package model;
import java.util.HashMap;

public class SongCollection {

	// Contains all the songs in this jukebox's library
	private HashMap<String, Song> songs = new HashMap<String, Song>();
	
	private static String baseDir = System.getProperty("user.dir")
		      + System.getProperty("file.separator") + "songfiles"
		      + System.getProperty("file.separator");

	public SongCollection(){
		populateSongs();
	} // Ends Constructor
	
	public int getSize() {
		return songs.size();
	} // Ends Method getSize
	
	public boolean add(Song song) {
		if (!songs.containsKey(String.format("%s/%s", song.getTitle(), song.getArtist()))) {
			songs.put(String.format("%s/%s", song.getTitle(), song.getArtist()), song);
			return true;
		}
		return false;
	} // Ends Method add
	
	public Song getSong(String songName) {
		return songs.get(songName);
	} // Ends Method getSong
	
	public HashMap<String, Song> getSongsMap(){
		return songs;		
	} // Ends Method getSongsMap
	
	// Hard-coding the additions here
	private void populateSongs(){
		
        songs.put("Space Music/Sun Microsystems", new Song("Space Music", "Sun Microsytems", baseDir + "spacemusic.au", 7) );
        songs.put("Flute/Sun Microsytems", new Song("Flute", "Sun Microsytems", baseDir + "flute.aif", 50));
        songs.put("tada/Mercer" , new Song("tada", "Mercer", baseDir + "tada.wav", 2));
		
        songs.put("Fresh Prince Theme/Will Smith" , new Song("Fresh Prince Theme", "Will Smith", baseDir + "freshPrince.wav", 2));
        songs.put("The Riviera Affair/Neil Richardson" , new Song("The Riviera Affair", "Neil Richardson", baseDir + "RivieraAffair.wav", 2));
        songs.put("Living in the Sunlight/Tiny Tim" , new Song("Living in the Sunlight", "Tiny Tim", baseDir + "tinyTim.wav", 2));
        songs.put("Mr. Wilson Rap/Game Grumps" , new Song("Mr. Wilson Rap", "Game Grumps", baseDir + "mrWilsonRap.wav", 2));
        
	} // Ends Method populateSongs
} // Ends Class SongCollection
