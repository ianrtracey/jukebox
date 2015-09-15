import static org.junit.Assert.*;

import org.junit.Test;

public class SongTester {

	Song mySong; // init Song obj var
	@Test
	public void test_Title_Artist_Duration() {
		mySong = new Song("Where Brooklyn At?", 180, "Biggie Smalls");
		assertEquals("Where Brooklyn At?", mySong.getTitle());
		assertEquals("Biggie Smalls", mySong.getArtist());
		assertEquals(180, mySong.getDurationOfSong());	
	}
	
	@Test
	public void test_timesPlayed() {
		mySong = new Song("Can't Forget About You", 180, "Nas");
		assertEquals(0, mySong.getTimesPlayedToday());
		mySong.playSong();
		assertEquals(1, mySong.getTimesPlayedToday());
		mySong.playSong();
		assertEquals(2, mySong.getTimesPlayedToday());
		mySong.playSong();
		assertEquals(3, mySong.getTimesPlayedToday());
		mySong.playSong();
		assertNotEquals(4, mySong.getTimesPlayedToday());
	}
	

}