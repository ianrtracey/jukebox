package model;
import java.util.HashMap;

public class SongCollection {

	HashMap<String, Song> songs = new HashMap<String, Song>(); // Contains all the songs in this jukebox's library
	
	public SongCollection(){
		populateSongs();
	} // Ends Constructor
	
	public int getSize() {
		return songs.size();
	} // Ends Method getSize
	
	public boolean add(Song song) {
		if (!songs.containsKey(String.format("%s/%s", song.getTitle(), song.getArtist()))) {
			songs.put(String.format("%s/%s", song.getTitle(), song.getArtist()), song);
			return true;
		}
		return false;
	} // Ends Method add
	
	public Song getSong(String songName) {
		return songs.get(songName);
	} // Ends Method getSong
		
	private void populateSongs(){
		songs.put("Are You Gonna Go My Way?/Lenny Kravitz", new Song("Are You Gonna Go My Way?", "Lenny Kravitz", "filename.mp3", 284));
		songs.put("Satisfied/8stops7", new Song("Satisfied", "8stops7", "filename.mp3", 185));
		songs.put("Stop the Rock (Mint Royale Mix)/Apollo 440", new Song("Stop the Rock (Mint Royale Mix)", "Apollo 440", "filename.mp3", 372));
		songs.put("Mad Skillz � Mic Chekka/BT", new Song("Mad Skillz � Mic Chekka", "BT", "filename.mp3", 336));
		songs.put("Break In/CiRRUS", new Song("Break In", "CiRRUS", "filename.mp3", 285));
		songs.put("Sky Scraper/Daiki Kasho", new Song("Sky Scraper", "Daiki Kasho", "filename.mp3", 335));
		songs.put("Go Gran Turismo/Dave Aude", new Song("Go Gran Turismo", "Dave Aude", "filename.mp3", 185));
		songs.put("Call It Brisco (And Why Not?)/Elite Force", new Song("Call It Brisco (And Why Not?)", "Elite Force", "filename.mp3", 410));
		songs.put("99 Red Balloons/Goldfinger", new Song("99 Red Balloons", "Goldfinger", "filename.mp3", 212));
		songs.put("Champion/Grinspoon", new Song("Champion", "Grinspoon", "filename.mp3", 162));
		songs.put("Stone Free/Jimi Hendrix", new Song("Stone Free", "Jimi Hendrix", "filename.mp3", 216));
		songs.put("Sober (Saint US Mix)/Muse", new Song("Sober (Saint US Mix)", "Muse", "filename.mp3", 248));
		songs.put("Def Beat/Junkie XL", new Song("Def Beat", "Junkie XL", "filename.mp3", 208));
		songs.put("Crash/Methods of Mayhem", new Song("Crash", "Methods of Mayhem", "filename.mp3", 202));
		songs.put("Kickstart My Heart/M�tley Cr�e", new Song("Kickstart My Heart", "M�tley Cr�e", "filename.mp3", 288));
		songs.put("Never Enough/Papa Roach", new Song("Never Enough", "Papa Roach", "filename.mp3", 214));
		songs.put("Super Nova Goes Pop/Powerman 5000", new Song("Super Nova Goes Pop", "Powerman 5000", "filename.mp3", 213));
		songs.put("Determination/Raekwon", new Song("Determination", "Raekwon", "filename.mp3", 192));
		songs.put("Dogg's Turismo 3/Snoop Dogg", new Song("Dogg's Turismo 3", "Snoop Dogg", "filename.mp3", 289));
		songs.put("She Sells Sanctuary/The Cult", new Song("She Sells Sanctuary", "The Cult", "filename.mp3", 263));
		songs.put("Againa/Lenny Kravitz", new Song("Againa", "Lenny Kravitz", "filename.mp3", 225));
		songs.put("Just a Day (Alan Moulder Mix)/Feeder", new Song("Just a Day (Alan Moulder Mix)", "Feeder", "filename.mp3", 233));
		songs.put("Shark/Ash", new Song("Shark", "Ash", "filename.mp3", 199));
		songs.put("Stompbox/Overseer", new Song("Stompbox", "Overseer", "filename.mp3", 237));
		songs.put("Turbo Lover/Judas Priest", new Song("Turbo Lover", "Judas Priest", "filename.mp3", 631));
	} // Ends Method populateSongs
	
} // Ends Class SongCollection
