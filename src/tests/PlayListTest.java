package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.PlayList;
import model.Song;

public class PlayListTest {

	@Test
	public void test() {
		PlayList playlist = new PlayList();
		playlist.queueSong(new Song("test1", "artist1", PlayList.baseDir + "flute.aif", 90));
		playlist.queueSong(new Song("test1", "artist1", PlayList.baseDir + "SwingCheese.mp3", 90));
		playlist.queueSong(new Song("test1", "artist1", PlayList.baseDir + "UntameableFire.mp3", 90));
		assertTrue( playlist.getSize() == 3 );
		assertTrue("\"test1\" by artist1".equals(playlist.getPlayQueueAsStrings().get(0)));
		playlist.play();
		playlist.play();
		assertEquals(1, playlist.getSize());
	}

}
