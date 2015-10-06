/*+----------------------------------------------------------------------
 ||
 ||  Class JukeBox
 ||
 ||        Purpose:  Represents a Jukebox and implements its functions.
 ||
 |+-----------------------------------------------------------------------
 ||
 ||        Methods: public JukeBox(StudentCollection students, SongCollection songs)
 ||					public boolean login(String id, int password)
 ||                 public void queue(Song song)
 ||                 public StudentCollection getStudentCollection()
 ||                 public StudentCollection getSongCollection()
 ||	                public PlayList getPlaylist() {
 ||	                public ArrayList<Song> getPlayList() {
 ||
 ++-----------------------------------------------------------------------*/
package model;
import java.util.ArrayList;

public class JukeBox {
	private StudentCollection studentCollection;	// Contains all students registered in Jukebox
	private SongCollection songCollection;			// Contains all songs in the Jukebox
	private PlayList playlist;						// Contains the current playlist (queue)
	private boolean loadData;
	
	public JukeBox(boolean loadData) {
		this.loadData = loadData;
		
		if (loadData) {
			
		if (Serializer.deserializeStudentCollection() != null) {
			this.studentCollection = Serializer.deserializeStudentCollection();
		} else {
			this.studentCollection = new StudentCollection();
		}
		
		if (Serializer.deserializeSongCollection() != null) {
			this.songCollection = Serializer.deserializeSongCollection();
		} else {
			this.songCollection = new SongCollection();
		}
		
		if (Serializer.deserializePlayQueue() != null) {
			this.playlist = Serializer.deserializePlayQueue();
		} else {
			this.playlist = new PlayList();
		}
		} else {
			this.studentCollection = new StudentCollection();
			this.songCollection = new SongCollection();
			this.playlist = new PlayList();
		}
	} // Ends Constructor
		
	public boolean login(String id, String password) {
		if( this.studentCollection.get(id) != null ) { 
			if( this.studentCollection.get(id).getPassword() == Integer.parseInt(password)) {
				System.out.println(Integer.parseInt(password));
				return true;
			} // Ends password conditional
		} // Ends userID conditional
		return false;
	} // Ends Method login
	
	// Queue Operation
	public void queue(Song song) {
		this.playlist.queueSong(song);
	} // Ends Method queue
	
	public boolean getIsDataLoaded() {
		return loadData;
	}
	
	// GETTERS AND SETTERS
	public StudentCollection getStudentCollection() {
		return studentCollection;
	} // Ends Method getStudentCollection
	
	public PlayList getPlaylist() {
		return this.playlist;
	} // Ends Method getPlayList (PlayList return)
	
	public ArrayList<Song> getPlayList() {
		ArrayList<Song> songs = new ArrayList<Song>();
		return songs;
	} // Ends Method getPlayList (ArrayList<Song> return)
	
	public SongCollection getSongCollection() {
		return songCollection;
	} // Ends Method getSongCollection
} // Ends Class JukeBox
