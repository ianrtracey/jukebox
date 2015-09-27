/*+----------------------------------------------------------------------
 ||
 ||  Class QueueAndPlay3SongsInOrder
 ||
 ||        Purpose:  Queues and plays 3 songs in order, delayed by 2 seconds
 ||                  between each song
 ||
 |+-----------------------------------------------------------------------
 ||
 ||        Methods: public static void main(String[] args)
 ||					public void run()
 ||
 ++-----------------------------------------------------------------------*/
package demoSongPlayer;
import songplayer.PlayList;
import model.Song;

// This is Rick's version for a separate test that a type exists to queue up songs and
// play them in FIFO order entirely and without overlapping.  This code needs a Song type
// with a very specific constructor and a PlayList type with a specific method, both
// of which are unlikely to exist in your design. 
public class QueueAndPlay3SongsInOrder {

  public static String baseDir = System.getProperty("user.dir")
      + System.getProperty("file.separator") + "songfiles"
      + System.getProperty("file.separator");

  public static void main(String[] args) {
    // Assign the responsibility of queuing Songs and playing them in order, and not overlapping
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        PlayList playList = new PlayList();

        Song a = (new Song("Space Music", "Sun Microsytems", baseDir + "spacemusic.au", 7) );
        Song b = (new Song("Flute", "Sun Microsytems", baseDir + "flute.aif", 50));
        Song c = (new Song("tada", "Mercer", baseDir + "tada.wav", 2));
      
        // Play 3 songs in FIFO order
        playList.queueSong(a);
        playList.queueSong(b);
        playList.queueSong(c);
        playList.play();
      }
    });
  }
} // Ends Class QueueAndPlay3SongsInOrder
