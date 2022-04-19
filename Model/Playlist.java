package Model;

import java.util.ArrayList;
import java.util.Calendar;

public class Playlist {
    private final int Id;
    private final String name;
    private final ArrayList<Song> songs;
    private final Calendar creationDate;

    public Playlist(int Id, String name) {
        this.Id=Id;
        this.name=name;
        this.creationDate = Calendar.getInstance();
        this.creationDate.getTime();
        this.songs= new ArrayList<>();
    }

    public int getId() {
        return Id;
    }


    public String getName() {
        return name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSong(Song song) {
        this.songs.add(song);
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public void showInformationPL(Playlist pl) {
        System.out.println("\n--------------Id Playlist: " + pl.getId()+"--------------" + "\n\tName: " + pl.getName() + "\n\tDate: " + pl.getCreationDate().get(Calendar.YEAR) + "/" + pl.getCreationDate().get(Calendar.MONTH) +
                "/" + pl.getCreationDate().get(Calendar.DAY_OF_MONTH)+"\t"+ pl.getCreationDate().get(Calendar.HOUR_OF_DAY)+":"+pl.getCreationDate().get(Calendar.MINUTE));
        if (pl.getSongs().size() != 0) {
            System.out.println("\tLong: " + pl.getSongs().size() + "\n\tSongs: ");
            for (Song j : pl.getSongs()) {
                System.out.println("\n\tId Song: " + j.getId() + "\n\t\tTitle: " + j.getName() + "\n\t\tAuthor: " + j.getAuthor());
            }
        } else {
            System.out.println("\tLong: "+pl.getSongs().size()+"\n\tSongs: Empty");
        }
        System.out.print("------------------------------------------\n\n");
    }

}
