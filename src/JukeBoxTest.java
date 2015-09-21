import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import model.Song;

public class JukeBoxTest {

	@Test
	public void testStudentCollectionAddAndLookup() {
		StudentCollection studentCollection = new StudentCollection();
		Student student1 = new Student("Chri",  1);
		Student student2 = new Student("Devon", 22);
		Student student3 = new Student("River", 333);
		Student student4 = new Student("Ryan",  444);
		assertTrue(studentCollection.add(student1));
		assertTrue(studentCollection.add(student2));
		assertTrue(studentCollection.add(student3));
		assertTrue(studentCollection.add(student4));
		Student queriedStudent = studentCollection.get("Chri");
		assertTrue(queriedStudent.getId() == "Chri" && queriedStudent.getPassword() == 1);
		queriedStudent = studentCollection.get("Devon");
		assertTrue(queriedStudent.getId() == "Devon" && queriedStudent.getPassword() == 22);
		queriedStudent = studentCollection.get("River");
		assertTrue(queriedStudent.getId() == "River" && queriedStudent.getPassword() == 333);
		queriedStudent = studentCollection.get("Ryan");
		assertTrue(queriedStudent.getId() == "Ryan" && queriedStudent.getPassword() == 444);
		
		// tests duplicate players being added
		Student dupStudent = new Student("Ryan", 90210);
		assertFalse(studentCollection.add(dupStudent));
		Student originalStudent = studentCollection.get(dupStudent.getId());
		assertTrue(originalStudent.getId() == "Ryan" && originalStudent.getPassword() == 444);
	
	}
	
	@Test
	public void testStudentMinuteLimit() {
		StudentCollection studentCollection = new StudentCollection();
		Student student1 = new Student("Chri",  1);
		Student student2 = new Student("Devon", 22);
		Student student3 = new Student("River", 333);
		Student student4 = new Student("Ryan",  444);
		assertTrue(studentCollection.add(student1));
		assertTrue(studentCollection.add(student2));
		assertTrue(studentCollection.add(student3));
		assertTrue(studentCollection.add(student4));
		assertTrue( studentCollection.get(student3.getId()).getLifetimeSecondsRemaining() == (1500 * 60) );
		assertFalse(student1.canPlaySong(1501*60));
		student1.setNumOfSongsPlayedToday(3);
		assertFalse(student1.canPlaySong(300));
		assertTrue(student2.canPlaySong(30));
		
	}
	
	@Test
	public void testStudent3PlaysPerDay() {
		StudentCollection studentCollection = new StudentCollection();
		Student student1 = new Student("Chri",  1);
		Student student2 = new Student("Devon", 22);
		Student student3 = new Student("River", 333);
		Student student4 = new Student("Ryan",  444);
		assertTrue(studentCollection.add(student1));
		assertTrue(studentCollection.add(student2));
		assertTrue(studentCollection.add(student3));
		assertTrue(studentCollection.add(student4));
		Song song = new Song("Song1", "Ian Tracey", "songtest.mp3", 90);
		assertTrue(student1.selectSong(song));
		assertTrue(student1.selectSong(song));
		assertTrue(student1.selectSong(song));
		// doesn't allow a 4th play
		assertFalse(student1.selectSong(song));
		// doesnt allow a playing a song greater than 1500 minutes		
	
	}
	
	@Test
	public void testJukeBoxQueue() {
		StudentCollection studentCollection = new StudentCollection();
		Student student1 = new Student("Chri",  1);
		Student student2 = new Student("Devon", 22);
		Student student3 = new Student("River", 333);
		Student student4 = new Student("Ryan",  444);
		
		SongCollection songCollection = new SongCollection();
		
		JukeBox jukebox = new JukeBox(studentCollection, songCollection);
		
		// Cant add the same song twice
		assertTrue(jukebox.getSongCollection().add( new Song("SongTest", "Worst Artist", "songtest.mp3", 90) ));
		assertFalse(jukebox.getSongCollection().add( new Song("SongTest", "Worst Artist", "songtest.mp3", 90) ));

		
		jukebox.queueSong(jukebox.getSongCollection().getSong("Are You Gonna Go My Way?/Lenny Kravitz"));
		jukebox.queueSong(jukebox.getSongCollection().getSong("SongTest/Worst Artist"));
		
		assertTrue( jukebox.dequeueSong().getTitle() == "Are You Gonna Go My Way?");
		assertTrue( jukebox.dequeueSong().getTitle() == "SongTest");
		assertNull( jukebox.dequeueSong());
	}
	
	@Test 
	public void testTimesSongPlayed() {
		Song song = new Song("tester", "nas", "tester.mp3", 70);
		assertTrue(song.canPlay());
		song.play();
		assertTrue(song.canPlay());
		song.play();
		assertTrue(song.canPlay());
		song.play();
		assertFalse(song.canPlay());
		// makes the last time played yesterday
		song.setLastTimePlayed(LocalDate.now().minusDays(1));
		assertTrue(song.canPlay());
		song.play();
		assertTrue(song.canPlay());
		song.play();
		assertTrue(song.canPlay());
		song.play();
		assertFalse(song.canPlay());	
	}
	
	@Test
	public void testJukeboxLogin() {
		SongCollection songs       = new SongCollection();
		StudentCollection students = new StudentCollection();
		
		students.add( new Student("Chri",  1) );
		students.add( new Student("Devon", 22) );
		students.add( new Student("River", 333) );
		students.add( new Student("Ryan",  444) );
		
		JukeBox jukebox = new JukeBox(students, songs);
		
		assertFalse(jukebox.login("Chris", 1));
		assertFalse(jukebox.login("Chri", 10));
		assertTrue(jukebox.login("Chri", 1));
		
	}

}