import java.util.HashMap;

public class JukeBox {

	HashMap<String, Song> Songs = new HashMap<String, Song>();
	
	public JukeBox(){
		populateSongs();
	}
	
	private void RunJukeBox(){	
		// accept user input
		// add to queue if player / song is able
		// keep running till shutdown
	}
	
	private void populateSongs(){
		Songs.put("Where Brooklyn At/Biggie Smalls", new Song("Where Brooklyn At?",  "Biggie Smalls", 180));
		
	}
	
	
}
