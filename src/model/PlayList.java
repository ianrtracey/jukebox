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
//	    waiter	  = new ObjectWaitingForSongToEnd(this);
		size = 0;
	}
	
	public void queueSong(Song song) {
		if (song == null) {
			throw new NullPointerException("Song being added to Queue is null");
		} else {
		this.playQueue.addFirst(song);
		size++;
		}
	}
	
	public void registerWaiter(ObjectWaitingForSongToEnd waiter) {
		this.waiter = waiter;
	}
	
	public Song dequeueSong() {
		return this.playQueue.pollLast();
	}
	
	
	public ArrayList<Song> getPlayQueue() {
		ArrayList<Song> playQueueSongs = new ArrayList<Song>();
		if ( !playQueue.isEmpty() ) {
			for(Iterator itr = playQueue.iterator(); itr.hasNext(); ) {
				playQueueSongs.add((Song)itr.next());
			}
		}
		return playQueueSongs;
	}
	
	public ArrayList<String> getPlayQueueAsStrings() {
		ArrayList<String> playQueueSongs = new ArrayList<String>();
		if ( !playQueue.isEmpty() ) {
			for(Iterator itr = playQueue.iterator(); itr.hasNext(); ) {
				playQueueSongs.add( itr.next().toString() );
			}
		}
		return playQueueSongs;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void play() {
		size--;
		SongPlayer.playFile(waiter, playQueue.peekLast().getFileName());
	}
	


	  /**
	   * An inner class that allows an instance of this to receive a
	   * songFinishedPlaying when the audio file has been played. Note: static was
	   * added here because it is called from main.
	   */

	
	
  }
  



