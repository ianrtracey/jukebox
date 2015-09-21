package model;

import java.util.ArrayDeque;


public class PlayList {
	
	ArrayDeque<Song> playQueue  = new ArrayDeque<Song>();
	
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
	
	public void play() {
		
	}

}
