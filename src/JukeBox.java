import java.util.ArrayDeque;

public class JukeBox {
	
	StudentCollection studentCollection;



	SongCollection songCollection;
	ArrayDeque<Song> playQueue  = new ArrayDeque<Song>();
	
	public JukeBox(StudentCollection students, SongCollection songs) {
		this.studentCollection = students;
		this.songCollection    = songs;
	}
	
	private void RunJukeBox(){	
		// accept user input
		// add to queue if player / song is able
		// keep running till shutdown
	}
	
	public boolean login(String id, int password) {
		if( this.studentCollection.get(id) != null ) { 
			if( this.studentCollection.get(id).getPassword() == password) {
				return true;
			}
		}
		
		return false;
	}
	
	
	/*
	 * QUEUE OPERATIONS 
	 */
	
	public void queueSong(Song song) {
		if (song == null) {
			throw new NullPointerException("Song being added to Queue is null");
		} else {
		this.playQueue.addFirst(song);
		}
	}
	
	public Song dequeueSong() {
		return this.playQueue.pollLast();
	}
	
	
	/*
	 * GETTERS AND SETTERS
	 */
	
	public StudentCollection getStudentCollection() {
		return studentCollection;
	}


	public SongCollection getSongCollection() {
		return songCollection;
	}

}
