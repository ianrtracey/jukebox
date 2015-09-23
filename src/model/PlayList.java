package model;

import java.util.ArrayDeque;
import java.util.Calendar;
import java.util.GregorianCalendar;

import songplayer.EndOfSongEvent;
import songplayer.EndOfSongListener;
import songplayer.SongPlayer;


public class PlayList {
	
	ArrayDeque<Song> playQueue;
	int size;
    public static String baseDir = System.getProperty("user.dir")
  	      + System.getProperty("file.separator") + "songfiles"
  	      + System.getProperty("file.separator");
    ObjectWaitingForSongToEnd waiter;
	
	public PlayList() {
		playQueue = new ArrayDeque<Song>();
	    waiter	  = new ObjectWaitingForSongToEnd();
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
	
	public Song dequeueSong() {
		size--;
		return this.playQueue.pollLast();
	}
	
	public void play() {

		waiter.setIsPlaying(true);
		SongPlayer.playFile(waiter, baseDir + "flute.aif");
		while( waiter.isPlaying() ) {
			System.out.println("playing....");
		}
		
			
		
		

	}
	


//    SongPlayer.playFile(waiter, baseDir + "tada.wav");
//
//    SongPlayer.playFile(waiter, baseDir + "SwingCheese.mp3");

  }
  
	// Singleton

  /**
   * An inner class that allows an instance of this to receive a
   * songFinishedPlaying when the audio file has been played. Note: static was
   * added here because it is called from main.
   */
  class ObjectWaitingForSongToEnd implements EndOfSongListener {
	  
	public boolean currentlyPlaying;
	
	public ObjectWaitingForSongToEnd() {
		currentlyPlaying = false;
	}
	
	public void setIsPlaying(boolean b) {
		currentlyPlaying = b;
	}
	
	public boolean isPlaying() {
		return currentlyPlaying;
	}
	
    public void songFinishedPlaying(EndOfSongEvent eosEvent) {
    	
    	this.currentlyPlaying = false;
    	System.out.println("Stopped playing");
    }
    
    


    
  }
	



