package demoSongPlayer;


import songplayer.SongPlayer;

public class Play1SongNoListener {

  public static void main(String[] args) {
    SongPlayer.playFile("./songfiles/BlueRidgeMountainMist.mp3");

    System.out
        .println("Song played in a separate Thread so this appears immediately");
    System.out.println("This program terminates only when song finishes...");
  }

}