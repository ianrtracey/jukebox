package model;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public final class Serializer {
	public static String dataDir = System.getProperty("user.dir")
			  + System.getProperty("file.separator") + "data"
			  + System.getProperty("file.separator");
	
	public static final String songCollectionDir = dataDir+"/songCollection.ser";
	public static final String studentCollectionDir = dataDir+"/studentCollection.ser";
	public static final String playQueueDir = dataDir+"/playQueueCollection.ser";
	

	
	
	public static boolean serializeSongCollection(SongCollection songCollection) {
		try {
			
		FileOutputStream fout = new FileOutputStream(songCollectionDir);
		ObjectOutputStream oos  = new ObjectOutputStream(fout);
		oos.writeObject(songCollection);
		oos.close();
		return true;
		
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}
	public static boolean serializeStudentCollection(StudentCollection studentCollection) {
		try {
			
		FileOutputStream fout = new FileOutputStream(studentCollectionDir);
		ObjectOutputStream oos  = new ObjectOutputStream(fout);
		oos.writeObject(studentCollection);
		oos.close();
		return true;
		
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}
	public static boolean serializePlayQueue(PlayList playQueue) {
		
		try {
			
			FileOutputStream fout = new FileOutputStream(playQueueDir);
			ObjectOutputStream oos  = new ObjectOutputStream(fout);
			oos.writeObject(playQueue);
			oos.close();
			return true;
			
			} catch(Exception ex) {
				ex.printStackTrace();
				return false;
			}
		
	}
	
	public static SongCollection deserializeSongCollection() {
		
		SongCollection songCollection;
		
		if (fileExists(songCollectionDir)) {
			
			try {
				FileInputStream fin = new FileInputStream(songCollectionDir);
				ObjectInputStream ois = new ObjectInputStream(fin);
				songCollection = (SongCollection) ois.readObject();
				ois.close();
			} catch(Exception ex) {
				ex.printStackTrace();
				return null;
			}
			
		} else {
			
			return null;
		}
		
		return songCollection;
		
	}
	
	public static StudentCollection deserializeStudentCollection() {
		
		StudentCollection studentCollection;
		
		if (fileExists(studentCollectionDir)) {
			
			try {
				FileInputStream fin = new FileInputStream(studentCollectionDir);
				ObjectInputStream ois = new ObjectInputStream(fin);
				studentCollection = (StudentCollection) ois.readObject();
				ois.close();
			} catch(Exception ex) {
				ex.printStackTrace();
				return null;
			}
			
		} else {
			
			return null;
		}
		
		return studentCollection;
		
	}
	
	public static PlayList deserializePlayQueue() {
		
		PlayList playQueue;
		
		if (fileExists(playQueueDir)) {
			
			try {
				FileInputStream fin = new FileInputStream(playQueueDir);
				ObjectInputStream ois = new ObjectInputStream(fin);
				playQueue = (PlayList) ois.readObject();
				ois.close();
			} catch(Exception ex) {
				ex.printStackTrace();
				return null;
			}
			
		} else {
			
			return null;
		}
		
		return playQueue;
		
	}
	
	private static boolean fileExists(String filePath) {
		File f = new File(filePath); 
		if(f.exists()) {
			return true;
		}
		return false;
	}
}
