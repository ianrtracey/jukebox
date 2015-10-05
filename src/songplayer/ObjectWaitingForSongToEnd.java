package songplayer;

import java.io.Serializable;

import javax.swing.DefaultListModel;

import model.PlayList;

public class ObjectWaitingForSongToEnd implements EndOfSongListener, Serializable {
	  
	public boolean currentlyPlaying;
	public PlayList playlist;
	public DefaultListModel listModel;
	
	public ObjectWaitingForSongToEnd(PlayList playList) {
		currentlyPlaying = false;
		this.playlist = playList;
	}
	
	public void setIsPlaying(boolean b) {
		currentlyPlaying = b;
	}
	
	public void registerJList(DefaultListModel listModel) {
		this.listModel = listModel;
	}
	
	public boolean isPlaying() {
		return currentlyPlaying;
	}
	
  public void songFinishedPlaying(EndOfSongEvent eosEvent) {
	if (playlist.getSize() == 0) {
  	  	playlist.dequeueSong();
  	  	this.listModel.remove(0);
	}

  	if(playlist.getSize() > 0) {
  		try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  	  	playlist.dequeueSong();
  	  	this.listModel.remove(0);
  		playlist.play();
  		
  	} else {
  	}
  
  	
  }
  
 
}