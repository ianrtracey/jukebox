/*+----------------------------------------------------------------------
 ||
 ||  Class PlayList
 ||
 ||        Purpose:  Represents a playlist model
 ||
 |+-----------------------------------------------------------------------
 ||
 ||        Methods: 	public PlayList()
 ||					    public void queueSong(Song song)
 ||						public void registerWaiter(ObjectWaitingForSongToEnd waiter)
 ||						public Song dequeueSong()
 ||						public ArrayList<Song> getPlayQueue()
 ||						public ArrayList<String> getPlayQueueAsStrings()
 ||						public int getSize()
 ||						public void play()
 ||
 ++-----------------------------------------------------------------------*/
package model;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import model.*;
import songplayer.EndOfSongEvent;
import songplayer.EndOfSongListener;
import songplayer.SongPlayer;
import songplayer.ObjectWaitingForSongToEnd;

public class PlayList implements Serializable {
	ArrayDeque<Song> playQueue;
	int size;
    public static String baseDir = System.getProperty("user.dir")
  	      + System.getProperty("file.separator") + "songfiles"
  	      + System.getProperty("file.separator");
    ObjectWaitingForSongToEnd waiter;
	
	public PlayList() {
		playQueue = new ArrayDeque<Song>();
		size = 0;
	} // Ends Constructor
	
	public void queueSong(Song song) {
		if (song == null) {
			throw new NullPointerException("Song being added to Queue is null");
		} else {
		this.playQueue.addFirst(song);
		size++;
		}
	} // Ends method queueSong
	
	public void registerWaiter(ObjectWaitingForSongToEnd waiter) {
		this.waiter = waiter;
	} // Ends Method registerWaiter
	
	public Song dequeueSong() {
		return this.playQueue.pollLast();
	} // Ends Method dequeueSong
	
	public ArrayList<Song> getPlayQueue() {
		ArrayList<Song> playQueueSongs = new ArrayList<Song>();
		if ( !playQueue.isEmpty() ) {
			for(Iterator itr = playQueue.iterator(); itr.hasNext(); ) {
				playQueueSongs.add((Song)itr.next());
			}
		}
		return playQueueSongs;
	} // Ends Method getPlayQueue()
	
	public ArrayList<String> getPlayQueueAsStrings() {
		ArrayList<String> playQueueSongs = new ArrayList<String>();
		if ( !playQueue.isEmpty() ) {
			for(Iterator itr = playQueue.iterator(); itr.hasNext(); ) {
				playQueueSongs.add( itr.next().toString() );
			}
		}
		return playQueueSongs;
	} // Ends Method getPlayQueueAsStrings()
	
	public int getSize() {
		return this.size;
	} // Ends Method getSize
	
	public void play() {
		size--;
		SongPlayer.playFile(waiter, playQueue.peekLast().getFileName());
	} // Ends Method play
  } // Ends Class PlayList
  



