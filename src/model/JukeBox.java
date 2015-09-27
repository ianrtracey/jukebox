package model;
import java.util.ArrayDeque;

import songplayer.PlayList;

public class JukeBox {
	
	StudentCollection studentCollection;
	SongCollection songCollection;
	PlayList playlist;
	
	
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
	public void queue(Song song) {
		this.playlist.queueSong(song);
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
