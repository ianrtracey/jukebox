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
	
	public void queueSong(Song song) {
		this.playQueue.addFirst(song);
	}
	
	public Song dequeueSong() {
		return this.playQueue.pollLast();
	}

}
