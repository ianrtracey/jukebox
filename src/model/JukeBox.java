/*=============================================================================
 |   Assignment:  Project 3 : Cashless Jukebox Iteration 1
 |      Authors:  Ian Tracey and Steven Eiselen
 |
 |       Course:  CSC 335
 |   Instructor:  Rick Mercer
 |     Due Date:  9/27/15 10:00PM MST
 |
 |  Description:  Partially implements the JukeBox via the spec. 
 |                 - GUIManager contains a main method which displays
 |                   a list of songs via a JScrollPane
 |                 - QueueAndPlay3SongsInOrder contains a main method
 |                   which will play 3 songs in queued order with a 
 |                   two second pause between each
 |                 - The two J-Unit test files in the tests package
 |                   perform testing on the remaining parts of the
 |                   model
 |
 |     Language:  Java 8 (Because of Time Imports / Tools)
 |                
 | Deficiencies:  None. This program's tests pass, Code Coverage (via ECLemma)
 |                is at or beyond required spec, the three songs play in queued
 |                order and the GUI Window shows up per spec in its main method
 *===========================================================================*/

/*+----------------------------------------------------------------------
 ||
 ||  Class JukeBox
 ||
 ||        Purpose:  Represents a Jukebox and implements its functions.
 ||
 |+-----------------------------------------------------------------------
 ||
 ||        Methods: public JukeBox(StudentCollection students, SongCollection songs)
 ||                 private void RunJukeBox()
 ||					public boolean login(String id, int password)
 ||                 public void queue(Song song)
 ||                 public StudentCollection getStudentCollection()
 ||                 public StudentCollection getSongCollection()
 ||
 ++-----------------------------------------------------------------------*/
package model;
import java.util.ArrayDeque;

public class JukeBox {
	
	private StudentCollection studentCollection;	// Contains all students registered in Jukebox
	private SongCollection songCollection;			// Contains all songs in the Jukebox
	private PlayList playlist;						// Contains the current playlist (queue)
	
	public JukeBox() {
		this.studentCollection = new StudentCollection();
		this.songCollection    = new SongCollection();
	} // Ends Constructor
	
	private void RunJukeBox(){	
		// TODO: Stub Until Iteration II
		//    accept user input
		//    add to queue if player / song is able
		//    keep running till shutdown
	} // Ends Method RunJukeBox
	
	public boolean login(String id, String password) {
		if( this.studentCollection.get(id) != null ) { 
			if( this.studentCollection.get(id).getPassword() == Integer.parseInt(password)) {
				return true;
			} // Ends password conditional
		} // Ends userID conditional
		return false;
	} // Ends Method login
	
	// Queue Operation
	public void queue(Song song) {
		this.playlist.queueSong(song);
	} // Ends Method queue
	
	// GETTERS AND SETTERS
	public StudentCollection getStudentCollection() {
		return studentCollection;
	} // Ends Method getStudentCollection
	
	public SongCollection getSongCollection() {
		return songCollection;
	} // Ends Method getSongCollection
} // Ends Class JukeBox
