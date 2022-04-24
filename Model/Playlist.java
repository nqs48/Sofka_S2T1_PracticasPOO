package Model;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author Nestor Quiroga
 * @author Laura Gutierrez
 * Class Playlist
 */
public class Playlist {
    /**
     * Playlist's id
     */
    private final int Id;

    /**
     * Playlist's title
     */
    private final String name;

    /**
     * Playlist's songs
     */
    private final ArrayList<Song> songs;

    /**
     * Playlist's creation date
     */
    private final Calendar creationDate;

    /**
     * Constructor class Playlist, set values for the playlist's attributes.
     * @param Id Value for set the playlist's id
     * @param name Value for set the playlist's name
     */
    public Playlist(int Id, String name) {
        this.Id=Id;
        this.name=name;
        this.creationDate = Calendar.getInstance();
        this.creationDate.getCalendarType();
        this.songs= new ArrayList<>();
    }

    /**
     * Get the current playlist's id
     * @return returns the playlist's id type int
     */
    public int getId() {
        return Id;
    }

    /**
     * Get the current playlist's name
     * @return returns the playlist's name type string
     */
    public String getName() {
        return name;
    }

    /**
     * Get the current playlist's songs
     * @return returns the playlist's songs type arrayList
     */
    public ArrayList<Song> getSongs() {
        return songs;
    }

    /**
     * Set a new song to playlist
     * @param song Contains the new song to set, type Song
     */
    public void setSong(Song song) {
        this.songs.add(song);
    }

    /**
     * Get the current playlist's creation date
     * @return returns the playlist's creation date type calendar
     */
    public Calendar getCreationDate() {
        return creationDate;
    }

    /**
     * Show the playlist's information formatted
     */
    public void showInformation() {
        System.out.println("\n--------------Id Playlist: " + getId()+"--------------" + "\n\tName: " + getName() + "\n\tDate: " + getCreationDate().getTime());
        if (getSongs().size() != 0) {
            System.out.println("\tLong: " + getSongs().size() + "\n\tSongs: ");
            for (Song j : getSongs()) {
                System.out.println("\n\tId Song: " + j.getId() + "\n\t\tTitle: " + j.getName() + "\n\t\tAuthor: " + j.getAuthor());
            }
        } else {
            System.out.println("\tLong: "+getSongs().size()+"\n\tSongs: Empty");
        }
        System.out.print("------------------------------------------\n\n");
    }

}
