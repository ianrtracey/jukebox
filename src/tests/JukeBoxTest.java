package tests;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import model.JukeBox;
import model.PlayList;
import model.Song;
import model.SongCollection;
import model.Student;
import model.StudentCollection;

public class JukeBoxTest {

	@Test
	public void testStudentCollectionAddAndLookup() {
		StudentCollection studentCollection = new StudentCollection();
		Student student1 = new Student("Chri",  1);
		Student student2 = new Student("Devon", 22);
		Student student3 = new Student("River", 333);
		Student student4 = new Student("Ryan",  444);
		assertFalse(studentCollection.add(student1));
		assertFalse(studentCollection.add(student2));
		assertFalse(studentCollection.add(student3));
		assertFalse(studentCollection.add(student4));
		
		Student queriedStudent = studentCollection.get("Chri");
		assertTrue(queriedStudent.getId() == "Chri" && queriedStudent.getPassword() == 1);
		queriedStudent = studentCollection.get("Devon");
		assertTrue(queriedStudent.getId() == "Devon" && queriedStudent.getPassword() == 22);
		queriedStudent = studentCollection.get("River");
		assertTrue(queriedStudent.getId() == "River" && queriedStudent.getPassword() == 333);
		queriedStudent = studentCollection.get("Ryan");
		assertTrue(queriedStudent.getId() == "Ryan" && queriedStudent.getPassword() == 4444);
		
		// tests duplicate players being added
		Student dupStudent = new Student("Ryan", 90210);
		assertFalse(studentCollection.add(dupStudent));
		Student originalStudent = studentCollection.get(dupStudent.getId());
		assertTrue(originalStudent.getId() == "Ryan" && originalStudent.getPassword() == 4444);
	
	}
	
	@Test
	public void testStudentMinuteLimit() {
		StudentCollection studentCollection = new StudentCollection();
		
		Student student = studentCollection.get("Devon");
		
		assertTrue( studentCollection.get(student.getId()).getLifetimeSecondsRemaining() == (1500 * 60) );
		assertFalse(student.canPlaySong(1501*60));
		student.setNumOfSongsPlayedToday(3);
		assertFalse(student.canPlaySong(300));
		assertFalse(student.canPlaySong(30));
		
	}
	
	@Test
	public void testStudent3PlaysPerDay() {
		StudentCollection studentCollection = new StudentCollection();
		
		Student student = studentCollection.get("Ryan");
		
		Song song = new Song("Song1", "Ian Tracey", "songtest.mp3", 90);
		assertTrue(student.selectSong(song));
		assertTrue(student.selectSong(song));
		assertTrue(student.selectSong(song));
		// doesn't allow a 4th play
		assertFalse(student.selectSong(song));
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
		
		JukeBox jukebox = new JukeBox();
		
		// Cant add the same song twice
		assertTrue(jukebox.getSongCollection().add( new Song("SongTest", "Worst Artist", "songtest.mp3", 90) ));
		assertFalse(jukebox.getSongCollection().add( new Song("SongTest", "Worst Artist", "songtest.mp3", 90) ));

		PlayList playList = new PlayList();
		playList.queueSong(jukebox.getSongCollection().getSong("Dogg's Turismo 3/Snoop Dogg"));
		playList.queueSong(jukebox.getSongCollection().getSong("SongTest/Worst Artist"));
		
		assertTrue( playList.dequeueSong().getTitle() == "Dogg's Turismo 3");
		assertTrue( playList.dequeueSong().getTitle() == "SongTest");
		assertNull( playList.dequeueSong());
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
		
		assertFalse(students.add( new Student("Chri",  1) ) );
		assertFalse(students.add( new Student("Devon", 22) ) );
		assertFalse(students.add( new Student("River", 333) ) );
		assertFalse(students.add( new Student("Ryan",  444) ) );
		
		JukeBox jukebox = new JukeBox();
		
		assertFalse(jukebox.login("Chris", "1"));
		assertFalse(jukebox.login("Chri", "10"));
		assertTrue(jukebox.login("Chri", "1"));
		
	}

}