
public class MainManager {
	
	public static void main(String[] args) {
		
		// Declare and Instantiate Student and Song Collections
		StudentCollection allStudents = new StudentCollection();
		SongCollection allSongs = new SongCollection();
		
		// Declare and Instantiate the jukebox object
		JukeBox jukebox = new JukeBox(allStudents, allSongs);
		
		// Declare and Instantiate GUI
		GUIManager GUI = new GUIManager(allSongs);
		GUI.setVisible(true);
		
		allSongs.getValues();
				
		
		
		
		
	}
		
	
	
	

}
