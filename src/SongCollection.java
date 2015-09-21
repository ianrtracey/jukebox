import java.util.HashMap;

public class SongCollection {

	HashMap<String, Song> songs = new HashMap<String, Song>();
	
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
	
	public Song get(String songName) {
		return songs.get(songName);
	} // Ends Method get
	
	public void getValues(){
		
		for(Song s : songs.values()){
			System.out.println(s.getArtist() + " " + s.getTitle() + " " + s.getDurationOfSong());
			
			
		}
		
		
	}
	
	private void populateSongs(){
//		songs.put("Are You Gonna Go My Way?/Lenny Kravitz", new Song("Are You Gonna Go My Way?", "Lenny Kravitz", 284));
//		songs.put("Satisfied/8stops7", new Song("Satisfied", "8stops7", 185));
//		songs.put("Stop the Rock (Mint Royale Mix)/Apollo 440", new Song("Stop the Rock (Mint Royale Mix)", "Apollo 440", 372));
//		songs.put("Mad Skillz � Mic Chekka/BT", new Song("Mad Skillz � Mic Chekka", "BT", 336));
//		songs.put("Break In/CiRRUS", new Song("Break In", "CiRRUS", 285));
//		songs.put("Sky Scraper/Daiki Kasho", new Song("Sky Scraper", "Daiki Kasho", 335));
//		songs.put("Go Gran Turismo/Dave Aude", new Song("Go Gran Turismo", "Dave Aude", 185));
//		songs.put("Call It Brisco (And Why Not?)/Elite Force", new Song("Call It Brisco (And Why Not?)", "Elite Force", 410));
//		songs.put("99 Red Balloons/Goldfinger", new Song("99 Red Balloons", "Goldfinger", 212));
//		songs.put("Champion/Grinspoon", new Song("Champion", "Grinspoon", 162));
//		songs.put("Stone Free/Jimi Hendrix", new Song("Stone Free", "Jimi Hendrix", 216));
//		songs.put("Sober (Saint US Mix)/Muse", new Song("Sober (Saint US Mix)", "Muse", 248));
//		songs.put("Def Beat/Junkie XL", new Song("Def Beat", "Junkie XL", 208));
//		songs.put("Crash/Methods of Mayhem", new Song("Crash", "Methods of Mayhem", 202));
//		songs.put("Kickstart My Heart/M�tley Cr�e", new Song("Kickstart My Heart", "M�tley Cr�e", 288));
//		songs.put("Never Enough/Papa Roach", new Song("Never Enough", "Papa Roach", 214));
//		songs.put("Super Nova Goes Pop/Powerman 5000", new Song("Super Nova Goes Pop", "Powerman 5000", 213));
//		songs.put("Determination/Raekwon", new Song("Determination", "Raekwon", 192));
//		songs.put("Dogg's Turismo 3/Snoop Dogg", new Song("Dogg's Turismo 3", "Snoop Dogg", 289));
//		songs.put("She Sells Sanctuary/The Cult", new Song("She Sells Sanctuary", "The Cult", 263));
//		songs.put("Againa/Lenny Kravitz", new Song("Againa", "Lenny Kravitz", 225));
//		songs.put("Just a Day (Alan Moulder Mix)/Feeder", new Song("Just a Day (Alan Moulder Mix)", "Feeder", 233));
//		songs.put("Shark/Ash", new Song("Shark", "Ash", 199));
//		songs.put("Stompbox/Overseer", new Song("Stompbox", "Overseer", 237));
//		songs.put("Turbo Lover/Judas Priest", new Song("Turbo Lover", "Judas Priest", 631));
	} // Ends Method populateSongs
	
} // Ends Class SongCollection
