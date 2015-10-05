package songplayer;

import java.io.Serializable;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

import model.PlayList;

public class ObjectWaitingForSongToEnd implements EndOfSongListener, Serializable {
	  
	public boolean currentlyPlaying;
	public PlayList playlist;
	public DefaultListModel listModel;
	public JButton playButton;
	
	
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
	
	public void registerPlayButton(JButton playButton){
		this.playButton = playButton;
		
	}
	
	public boolean isPlaying() {
		return currentlyPlaying;
	}
	
  public void songFinishedPlaying(EndOfSongEvent eosEvent) {
	if (playlist.getSize() == 0) {
		this.playButton.setEnabled(true);
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