import static org.junit.Assert.*;

import org.junit.Test;

public class SongTester {

	Song mySong; // init Song obj var
	@Test
	public void test_Title_Artist_Duration() {
		mySong = new Song("Where Brooklyn At?", "Biggie Smalls", "where_brookyln_at", 180 );
		assertEquals("Where Brooklyn At?", mySong.getTitle());
		assertEquals("Biggie Smalls", mySong.getArtist());
		assertEquals(180, mySong.getDurationOfSong());	
	}
	
	@Test
	public void test_timesPlayed() {
		mySong = new Song("Can't Forget About You", "Nas", "cant_forget.wav", 180 );
		assertEquals(0, mySong.getTimesPlayedToday());
		mySong.play();
		assertEquals(1, mySong.getTimesPlayedToday());
		mySong.play();
		assertEquals(2, mySong.getTimesPlayedToday());
		mySong.play();
		assertEquals(3, mySong.getTimesPlayedToday());
		mySong.play();
		assertNotEquals(4, mySong.getTimesPlayedToday());
	}
	

}
