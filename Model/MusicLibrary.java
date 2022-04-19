package Model;

import Model.Song;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;

public class MusicLibrary {
    private ArrayList<Song> songs;
    private ArrayList<Playlist> playLists;


    /**
     * Constructor class MusicLibrary, set the preLoadedMusic for the attribute 'songs', and it declares a new array for attribute 'playlist'.
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
            if(s.getDatePublish().get(Calendar.YEAR)==year){
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

    public ArrayList<String> findGenders(ArrayList<Song> songs){
        ArrayList<String> currentlyGenders= new ArrayList<>();
        for (Song s:songs) {
            if(!currentlyGenders.contains(s.getGender())){
                currentlyGenders.add(s.getGender());
            }
        }
        return currentlyGenders;
    }


    public ArrayList<Song> sortSongsDuration(ArrayList<Song> songs){
        ArrayList<Song> unSortSongs= (ArrayList<Song>)songs.clone();
        unSortSongs.sort(Comparator.comparing(Song::getDuration));
        return unSortSongs;
    }

    public ArrayList<Song> sortSongsDate(ArrayList<Song> songs){
        ArrayList<Song> unSortSongs= (ArrayList<Song>) songs.clone();
        unSortSongs.sort(Comparator.comparing(Song::getDatePublish));
        return unSortSongs;
    }


    //GETTERS

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public ArrayList<Playlist> getPlayLists() {
        return playLists;
    }


    public void preLoadedMusic(){
        ArrayList<Song> preloadedSongs= new ArrayList<>();
        preloadedSongs.add(new Song("Don't Cry","Guns n Roses", 1, 180, 1989, 3, 22, "Rock", "link0000001.jpg", "This song is the greatest hits"));
        preloadedSongs.add(new Song("Believer","Imagine Dragon", 2, 220, 2012, 9, 22, "Pop", "link0000002.jpg", "This song is the greatest hits"));
        preloadedSongs.add(new Song("Faded","Alan Walker", 3, 187, 2016, 3, 22, "Electronic", "link0000003.jpg", "This song is the greatest hits"));
        preloadedSongs.add(new Song("November Rain","Guns n Roses", 4, 190, 1993, 6, 22, "Rock", "link0000004.jpg", "This song is the greatest hits"));
        preloadedSongs.add(new Song("Colors","Halsey", 5, 212, 2019, 7, 22, "Pop", "link0000005.jpg", "This song is the greatest hits"));
        preloadedSongs.add(new Song("Stay","Alessia Cara", 6, 156, 2019, 2, 22, "Pop", "link0000006.jpg", "This song is the greatest hits"));
        preloadedSongs.add(new Song("Safe and Sound","Capital Cites", 7, 149, 2017, 2, 22, "Electronic", "link0000007.jpg", "This song is the greatest hits"));
        this.songs= preloadedSongs;
    }

    public void preLoadedPlayList(){
        ArrayList<Playlist> preloadedPlayLists=new ArrayList<>();
        preloadedPlayLists.add(new Playlist(1,"Favorites"));
        this.playLists=preloadedPlayLists;
    }


}
