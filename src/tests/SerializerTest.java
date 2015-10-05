package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.PlayList;
import model.Serializer;
import model.Song;
import model.SongCollection;
import model.StudentCollection;

public class SerializerTest {

	@Test
	public void testSerializer() {
		SongCollection songCollection = new SongCollection();
		StudentCollection studentCollection =  new StudentCollection();
		PlayList playQueue = new PlayList();
		assertTrue( Serializer.serializeSongCollection(songCollection) );
		assertTrue( Serializer.serializeStudentCollection(studentCollection) );
		assertTrue( Serializer.serializePlayQueue(playQueue) );
		
		assertNotNull( Serializer.deserializeSongCollection() );
		assertNotNull( Serializer.deserializeStudentCollection() );
		assertNotNull( Serializer.deserializePlayQueue() );
		
		songCollection = Serializer.deserializeSongCollection();
		studentCollection = Serializer.deserializeStudentCollection();
		playQueue = Serializer.deserializePlayQueue();
		
		assertEquals (4, studentCollection.getSize() );
		assertEquals (7, songCollection.getSize() );
		assertEquals (0, playQueue.getSize() );
	
		assertEquals(1, studentCollection.get("Chris").getPassword());
		
		
		
	}

}
