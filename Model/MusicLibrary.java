package Model;

import java.util.*;

/**
 * @author Nestor Quiroga
 * @author Laura Gutierrez
 * Class MusicLibrary general class to contains the methods
 */
public class MusicLibrary {
    /**
     * Represents the list of general songs
     */
    private ArrayList<Song> songs;

    /**
     * Represents the list of playlists
     */
    private ArrayList<Playlist> playLists;

    /**
     * Constructor class MusicLibrary, set empty lists for the attribute 'songs' and 'playlists'.
     */
    public MusicLibrary() {
        this.songs= new ArrayList<>();
        this.playLists= new ArrayList<>();
    }

    /**
     * Overloaded method filter
     * @param library General Song's List, type arrayList
     * @param gender Key for filter, type string
     * @return Returns the values that satisfy the condition GENDER in a new arrayList
     */
    public ArrayList<Song> filter(ArrayList<Song> library,String gender){
        ArrayList<Song> genderSongs= new ArrayList<>();
        for (Song s:library) {
            if(s.getGender().equals(gender)){
                genderSongs.add(s);
            }
        }
        return genderSongs;
    }

    /**
     * Overloaded method filter
     * @param library General Song's List, type arrayList
     * @param year Key for filter, type int
     * @return Returns the values that satisfy the condition YEAR in a new arrayList
     */
    public ArrayList<Song> filter(ArrayList<Song> library,  int year){
        ArrayList<Song> yearSongs= new ArrayList<>();
        for (Song s:library) {
            if(s.getPublicationDate().get(Calendar.YEAR)==year){
                yearSongs.add(s);
            }
        }
        return yearSongs;
    }

    /**
     * Method FilterSong, filter for ID
     * @param library General Song's List, type arrayList
     * @param idSong Key for filter, type int
     * @return findSong If found a song with this ID, return this song else returns a value null.
     */
    public Song idFilterSong(ArrayList<Song> library, int idSong) {
        Song findSong;
        for (Song s : library) {
            if (s.getId() == idSong) {
                findSong = s;
                return findSong;
            }
        }
        return null;
    }

    /**
     *
     * @param playLists List of playlists, type arrayList
     * @param idList Key for filter, type int
     * @return findPlayList If found a playList with this ID, return this playList else returns a value null.
     */
    public Playlist idFilterPlayList(ArrayList<Playlist> playLists,  int idList){
        Playlist findPlayList;
        for (Playlist p : playLists) {
            if (p.getId() == idList) {
                findPlayList = p;
                return findPlayList;
            }
        }
        return null;
    }

    /**
     *
     * @param songs Current Song's List, type arrayList
     * @return currentlyGenders with the currently genders without repeat, type arraylist
     */
    public ArrayList<String> findGenders(ArrayList<Song> songs){
        ArrayList<String> currentlyGenders= new ArrayList<>();
        for (Song s:songs) {
            if(!currentlyGenders.contains(s.getGender())){
                currentlyGenders.add(s.getGender());
            }
        }
        return currentlyGenders;
    }

    /**
     *
     * @param songs Current Song's List, type arrayList
     * @return returns the currently songs ordered for duration in a new array, type arraylist
     */
    public ArrayList<Song> sortSongsDuration(ArrayList<Song> songs){
        ArrayList<Song> unSortSongs= (ArrayList<Song>)songs.clone();
        unSortSongs.sort(Comparator.comparing(Song::getDuration));
        return unSortSongs;
    }

    /**
     *
     * @param songs Current Song's List, type arrayList
     * @return returns the currently songs ordered for date publish in a new array, type arraylist
     */
    public ArrayList<Song> sortSongsDate(ArrayList<Song> songs){
        ArrayList<Song> unSortSongs= (ArrayList<Song>) songs.clone();
        unSortSongs.sort(Comparator.comparing(Song::getPublicationDate));
        return unSortSongs;
    }

    /**
     * Get general songs list
     * @return returns the library's songs type Arraylist
     */
    public ArrayList<Song> getSongs() {
        return songs;
    }

    /**
     * Get general playlist list
     * @return returns the library's playlist type Arraylist
     */
    public ArrayList<Playlist> getPlayLists() {
        return playLists;
    }

    /**
     * Collect data to create a new song
     * @return returns a new song type Song
     */
    public Song collectSongData(){
        System.out.println("\nEnter the song's name: ");
        Scanner name = new Scanner(System.in);
        String s1Name = name.nextLine();
        System.out.println("\nEnter the song's Author:");
        Scanner author = new Scanner(System.in);
        String s1author = author.nextLine();
        System.out.println("\nPublication date: \nEnter the year: (4 Digits):");
        Scanner year = new Scanner(System.in);
        int s1Year = year.nextInt();
        System.out.println("\nEnter the month: (1 or 2 Digits):");
        Scanner month = new Scanner(System.in);
        int s1Month = month.nextInt();
        System.out.println("\nEnter the day (1 or 2  Digits): ");
        Scanner day = new Scanner(System.in);
        int s1Day = day.nextInt();
        System.out.println("\nEnter the song's duration (seconds): ");
        Scanner duration = new Scanner(System.in);
        int s1Duration = duration.nextInt();
        System.out.println("\nEnter the song's gender: ");
        Scanner gender = new Scanner(System.in);
        String s1Gender = gender.nextLine();
        System.out.println("\nEnter the link song's cover: ");
        Scanner cover = new Scanner(System.in);
        String s1Cover = cover.nextLine();
        System.out.println("\nEnter the song's description: ");
        Scanner description = new Scanner(System.in);
        String s1Description = description.nextLine();
        int autogenerateId = getSongs().size() + 1;
        return new Song(s1Name,s1author,autogenerateId,s1Duration,s1Year,s1Month,s1Day,s1Gender,s1Cover,s1Description);
    }

    /**
     * Choose the song for the ID
     * @return If found a song with this ID, return this song else returns a value null.
     */
    public Song chooseSong(){
        Song songToAdd;
        if (getSongs().size() != 0) {
            System.out.println("\nCurrent Songs : ");
            getSongs().forEach((s)->System.out.println("\n\tId Song: " + s.getId() + "\n\t\tTitle: " + s.getName() + "\n\t\tAuthor: " + s.getAuthor()+"\n"));
            System.out.println("\nEnter the song's ID to add: ");
            Scanner idSong = new Scanner(System.in);
            int idFilter = idSong.nextInt();
            songToAdd = idFilterSong(getSongs(), idFilter);
        } else {
            System.out.println("\n\tThere aren't SONGS, verify your currently DATA!!\n");
            return null;
        }
        return songToAdd;
    }

    /**
     * Choose the playlist for the ID
     * @return If found a playlist with this ID, return this playlist else returns a value null.
     */
    public Playlist choosePlaylist(){
        Playlist playListSelected;
        if (getPlayLists().size() != 0){
            System.out.println("\nCurrent Playlists : ");
            getPlayLists().forEach(Playlist::showInformation);
            System.out.println("\nEnter the playList's ID to select: ");
            Scanner idList = new Scanner(System.in);
            int idFilterList = idList.nextInt();
            playListSelected = idFilterPlayList(getPlayLists(), idFilterList);
        }else {
            System.out.println("\n\tThere aren't PLAYLIST, verify your currently DATA!!\n");
            return null;
        }
        return playListSelected;
    }

    /**
     * Set preloaded songs data to general songs
     */
    public void preLoadedMusic(){
        ArrayList<Song> preloadedSongs= new ArrayList<>();
        preloadedSongs.add(new Song("Don't Cry","Guns n Roses", 1, 180, 1989, 3, 22, "Rock", "link0000001.jpg", "This song is the greatest hits"));
        preloadedSongs.add(new Song("Believer","Imagine Dragon", 2, 220, 2012, 9, 22, "Pop", "link0000002.jpg", "This song is the greatest hits"));
        preloadedSongs.add(new Song("Faded","Alan Walker", 3, 187, 2016, 3, 22, "Electronic", "link0000003.jpg", "This song is the greatest hits"));
        preloadedSongs.add(new Song("November Rain","Guns n Roses", 4, 190, 1993, 6, 22, "Rock", "link0000004.jpg", "This song is the greatest hits"));
        preloadedSongs.add(new Song("Colors","Halsey", 5, 212, 2019, 7, 22, "Pop", "link0000005.jpg", "This song is the greatest hits"));
        preloadedSongs.add(new Song("Stay","Alessia Cara", 6, 156, 2019, 2, 22, "Pop", "link0000006.jpg", "This song is the greatest hits"));
        preloadedSongs.add(new Song("Safe and Sound","Capital Cites", 7, 149, 2017, 2, 22, "Electronic", "link0000007.jpg", "This song is the greatest hits"));
        preloadedSongs.add(new Song("I miss you","Blink-182",8,228,2004,2,4,"Pop-Rock","link0008.jpg","Created in October 2003 by the American band Blink-182 and released in 2004."));
        preloadedSongs.add(new Song("In the shadows","The Ramous",9,220,2003,2,3,"Rock","link00009.jpg","Song by the finnish band The Rasmus from the album Dead Letters"));
        preloadedSongs.add(new Song("Nubes negras","Los de adentro",10,248,2004,7,16,"Pop-Rock","link00010.jpg","Song by the Colombian band Los de Adentro"));
        preloadedSongs.add(new Song("Perfecta","Miranda y Julieta Venegas",11,220,2007,7,26,"Pop","link000011.jpg","Song by the argentinian band Miranda with the collaboration of Julieta Venegas."));
        preloadedSongs.add(new Song("Instant Crush","Daft-Punk", 12, 337, 2013, 11, 22, "Electronic", "link00000012.jpg", "Song produced by Daft Punk, performed and written by Julian Casablanca."));
        preloadedSongs.add(new Song("Rompe","Daddy Yankee",13,248,2005,8,7,"Reggaeton","link0008.jpg","Song of the Puerto Rican Daddy Yankee from the album BARRIO FINO"));
        preloadedSongs.add(new Song("Adore You","Harry Style",14,208,2019,12,6,"Pop","link000019.jpg","Song of the british artist Harry Style from the album fine line"));
        preloadedSongs.add(new Song("Bones","Imagine Dragons",15,165,2022,3,11,"Pop-Rock","link00015.jpg","Song by the American band Imagine Dragons, used in the trailer of the third season of the series The Boys."));
        preloadedSongs.add(new Song("Waiting for Love","Avicci",16,228,2015,5,22,"Electronic","link000016.jpg","Song produced by Avicii, Martin Garrix, Salem Al Fakir, Vincent Pontare"));
        preloadedSongs.add(new Song("Just the Two of Us","Grover Washington", 17, 438, 1981, 8, 17, "Soul", "link00000021.jpg", "Song recorded by Grover Washington, Jr. and Bill Withers from the album Winelight"));
        preloadedSongs.add(new Song("Procura","Chichi Peralta", 18, 275, 1997, 12, 26, "Musica tropical", "link0000002.jpg", "This song is the greatest hits"));
        preloadedSongs.add(new Song("Un montón de estrellas","Polo Nuñez", 19, 341, 2000, 5, 11, "Musica tropical", "link0000003.jpg", "This song is the greatest hits"));
        preloadedSongs.add(new Song("Salio el sol","Don Omar", 20, 315, 2006, 6, 22, "Reggaeton", "link0000004.jpg", "This song is the greatest hits"));
        preloadedSongs.add(new Song("The Scientist","Coldplay", 21, 309, 2002, 11, 4, "Pop-Rock", "link00000025.jpg", "Song by the British band Coldplay written by lead singer Chris Martin from the album A Rush of Blood to the Head."));
        preloadedSongs.add(new Song("Thunderstruck","AC/DC", 22, 292, 1999, 1, 5, "Rock", "link00000022.jpg", "This song is the greatest hits"));
        preloadedSongs.add(new Song("Stop Crying Your Heart Out","Oasis", 23, 341, 2002, 6, 17, "Rock", "link00000023.jpg", "This song is the greatest hits, used in the sountrack of the movie The Butterfly Effect"));
        preloadedSongs.add(new Song("La vida es un carnaval","Celia Cruz", 24, 277, 1998, 2, 6, "Salsa", "link00000021.jpg", "Song performed by Celia Cruz, written by Victor Daniel, produced and arranged by Isidro Infante."));
        preloadedSongs.add(new Song("Without Me","Eminem", 25, 254, 2002, 4, 6, "Hip hop", "link0000002.jpg", "This song is the greatest hits"));
        preloadedSongs.add(new Song("Careless Whisper","George Michael", 26, 304, 1984, 7, 16, "Pop", "link0000003.jpg", "Song performed, written and produced by the British singer George Michael, used in several soundtracks of romantic or comedy movies."));
        preloadedSongs.add(new Song("Fly Me To The Moon","Frank Sinatra", 27, 148, 1963, 11, 22, "Jazz", "link0000004.jpg", "Song composed by Bart Howard and interpreted by Frank Sinatra, curiously the first song played on the Moon."));
        preloadedSongs.add(new Song("Todo de cabeza","Kaleth Morales", 28, 248, 2006, 6, 23, "Vallenato", "link00000025.jpg", "This song is the greatest hits"));
        preloadedSongs.add(new Song("She Will Be Loved","Maroon 5", 29, 259, 1999, 1, 5, "Pop-Rock", "link00000022.jpg", "This song is the greatest hits"));
        preloadedSongs.add(new Song("Caraluna","Bacilos", 30, 266, 2002, 7, 16, "Pop-Latino", "link00000023.jpg", "This song is the greatest hits"));
        preloadedSongs.add(new Song("Welcome to the Jungle"," Guns N' Roses", 31, 273, 1987, 10, 3, "Rock", "link00000021.jpg", "Song of the American band Guns N' Roses, has been part of the soundtrack of some movies."));
        preloadedSongs.add(new Song("Good 4 u","Olivia Rodrdigo", 32, 178, 2021, 5, 14, "Pop", "link0000002.jpg", "Song performed and written by Olivia Rodrigo, in collaboration with Dan Nigro, but due to copyright the song is also by Hayley Williams, Joshua Neil Farro"));
        preloadedSongs.add(new Song("Locked Out of Heaven","Bruno Mars", 33, 233, 2012, 10, 1, "Pop", "link0000003.jpg", "Song performed and written by Bruno Mars, written in collaboration with The Smeezingtons who were also part of the production."));
        preloadedSongs.add(new Song("Plan A","Paulo Londra", 34, 185, 2022, 4, 6, "Pop", "link0000004.jpg", "This song is the greatest hits"));
        preloadedSongs.add(new Song("Maps","Maroon 5", 35, 189, 2014, 6, 16, "Pop-Rock", "link00000025.jpg", "This song is the greatest hits"));
        preloadedSongs.add(new Song("Devuélveme a mi chica","Hombres G", 36, 194, 1985, 1, 4, "Rock", "link00000022.jpg", "Song by the band Hombres G, written and performed by David Summers."));
        preloadedSongs.add(new Song("Titanium","David Guetta", 37, 245, 2011, 11, 29, "Electronic", "link00000023.jpg", "Song produced by David Guetta, Afrojack and Giorgio Tuinfort and written and performed by Australian singer Sia."));
        this.songs= preloadedSongs;
    }

    /**
     * Set preloaded playlist data to playlists
     */
    public void preLoadedPlayList(){
        ArrayList<Playlist> preloadedPlayLists=new ArrayList<>();
        preloadedPlayLists.add(new Playlist(1,"Favorites"));
        this.playLists=preloadedPlayLists;
    }

}
