package View;

import Model.MusicLibrary;
import Model.Playlist;
import Model.Song;
import Model.Menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        MusicLibrary simplify = new MusicLibrary();
        String separator="\n==================================================";
        int userPreload, user,userSongs, userPlaylist, userFilter, userSort;

        userPreload = menu.printPreloadMenu(separator);
            if (userPreload == 1){
                System.out.println("\n\t>> Library init with Preloaded data:");
                simplify.preLoadedMusic();
                simplify.preLoadedPlayList();
            }else if(userPreload == 2){
                System.out.println("\n>> Library init empty");
            }else{
                System.out.println("\n>> Invalid Selection, The library will be init empty");
            }
        do {
            user = menu.printMainMenu(separator);
            switch (user) {
                case 1 -> {
                    do {
                        userSongs= menu.printMenuSong(separator);
                        switch (userSongs) {
                            case 1 -> {
                                try {
                                    System.out.println("\n\n\t\t\t\t+CREATE SONG" + separator);
                                    Song s= simplify.collectSongData();
                                    System.out.println("\n\t>> The song -"+s.getName()+"- was created successfully!!\n");
                                    simplify.getSongs().add(s);
                                    s.showInformation();
                                }catch (InputMismatchException e ){
                                    System.out.println("\n\tIncorrect selection data!!  \n"+e);
                                }
                            }
                            case 2 -> {
                                System.out.println("\n\n\t\t\t\t\t+VIEW SONGS"+separator);
                                if (simplify.getSongs().size() != 0) {
                                    for (Song i : simplify.getSongs()) {
                                        i.showInformation();
                                    }
                                } else {
                                    System.out.println("\n\tThere aren't Songs, add a new song!!\n");
                                }
                            }
                            case 3 -> {
                                System.out.println("\n\n\t\t\t+ADD SONG TO PLAYLIST"+separator);
                                Song songToAdd = simplify.chooseSong();
                                if(songToAdd != null) {
                                    System.out.println("\n>> Song: " + songToAdd.getName() + " to  => ");
                                    Playlist playListSelected = simplify.choosePlaylist();
                                    if (playListSelected != null) {
                                        playListSelected.setSong(songToAdd);
                                        System.out.println("\nAdded successfully!!\n\n\t>> Song: " + songToAdd.getName() + " to  => " + playListSelected.getName() + "!!\n");
                                    }
                                }
                            }
                        }
                    } while (userSongs != 4);
                }
                case 2 -> {
                    do {
                        userPlaylist= menu.printMenuPlayList(separator);
                        switch (userPlaylist) {
                            case 1 -> {
                                System.out.println("\n\n\t\t\t\t+CREATE PLAYLIST"+separator);
                                System.out.println("\nEnter the PlayList's name: ");
                                Scanner namePlaylist = new Scanner(System.in);
                                String plNamePlaylist = namePlaylist.nextLine();
                                int autogenerateId = simplify.getPlayLists().size() + 1;
                                Playlist pl = new Playlist(autogenerateId, plNamePlaylist);
                                simplify.getPlayLists().add(pl);
                                System.out.println("\n" + pl.getName() + " was created successfully !!");
                                pl.showInformation();
                            }
                            case 2 -> {
                                System.out.println("\n\n\t\t\t\t+VIEW PLAYLISTS"+separator);
                                if (simplify.getPlayLists().size() != 0) {
                                    simplify.getPlayLists().forEach(Playlist::showInformation);
                                } else {
                                    System.out.println("\n\tThere aren't Playlist, add a new Playlist!!\n");
                                }
                            }
                        }
                    } while (userPlaylist != 3);
                }
                case 3 -> {
                    do {
                        userFilter=menu.printMenuFilters(separator);
                        switch (userFilter) {
                            case 1 -> {
                                System.out.println("\n\n\t\t\t\t+FILTER GENDER"+separator);
                                System.out.println("\nCurrent Genders: \n");
                                if(simplify.getSongs().size() != 0){
                                    simplify.findGenders(simplify.getSongs()).forEach((s)-> System.out.print("-> "+s+"\t\t"));
                                    System.out.println("\n\nEnter the Song's Gender to Filter: ");
                                    Scanner genderSong = new Scanner(System.in);
                                    String genderSelected = genderSong.nextLine();
                                    ArrayList<Song> filteredSongs = simplify.filter(simplify.getSongs(), genderSelected);
                                    if (filteredSongs.size() != 0) {
                                        System.out.println("\n\n\tSongs gender "+genderSelected.toUpperCase()+"\t-\tCant: " + filteredSongs.size());
                                        for (Song s:filteredSongs) {s.showInformation(); }
                                    } else {
                                        System.out.println("\n\tCan't find Songs in this gender!!\n");
                                    }
                                }else{
                                    System.out.println("\n\tThere aren't Songs, add a new song!!\n");
                                }
                            }
                            case 2 -> {
                                System.out.println("\n\n\t\t\t\t+FILTER YEAR"+separator);
                                if(simplify.getSongs().size() != 0) {
                                    try{
                                        System.out.println("\nEnter the Song's Year to Filter: ");
                                        Scanner yearSong = new Scanner(System.in);
                                        int yearSelected = yearSong.nextInt();
                                        ArrayList<Song> yearSongs = simplify.filter(simplify.getSongs(), yearSelected);
                                        if (yearSongs.size() != 0) {
                                            System.out.println("\n\n\tSongs year " + yearSelected + "\t-\tCant: " + yearSongs.size());
                                            for (Song s : yearSongs) {
                                                s.showInformation();
                                            }
                                        } else {
                                            System.out.println("\n\tCan't find Songs on this year!!\n");
                                        }
                                    }catch (InputMismatchException e ){
                                        System.out.println("\n\tIncorrect input data, try again.\n\nError: "+e);
                                    }
                                }else{
                                    System.out.println("\n\tThere aren't Songs, add a new song!!\n");
                                }
                            }
                            case 3 -> {
                                System.out.println("\n\n\t\t\t\t+FILTER ID"+separator);
                                if(simplify.getSongs().size() != 0) {
                                    try{
                                        System.out.println("\nEnter the Song's ID to Filter: ");
                                        Scanner idSong = new Scanner(System.in);
                                        int idSelected = idSong.nextInt();
                                        Song songFind = simplify.idFilterSong(simplify.getSongs(), idSelected);
                                        if (songFind != null) {
                                            songFind.showInformation();
                                        } else {
                                            System.out.println("\n\tCan't find Song with this ID!!\n");
                                        }
                                    }catch (InputMismatchException e ){
                                        System.out.println("\n\tIncorrect input data, try again.\n\nError: "+e);
                                    }
                                }else{
                                    System.out.println("\n\tThere aren't Songs, add a new song!!\n");
                                }
                            }
                        }
                    } while (userFilter != 4);
                }
                case 4 -> {
                    do {
                        userSort=menu.printMenuSorts(separator);
                        switch (userSort) {
                            case 1 -> {
                                System.out.println("\n\n\t\t\t\t+SORT DURATION"+separator);
                                ArrayList<Song> sortSongsDuration = simplify.sortSongsDuration(simplify.getSongs());
                                if (sortSongsDuration.size() != 0) {
                                    System.out.println("\n\n\tSort for DURATION \t-\tCant: " + sortSongsDuration.size());
                                    for( Song s :sortSongsDuration){
                                        s.showInformation();
                                    }
                                    System.out.println("\n\t\t>> Songs Ordered "+sortSongsDuration.size()+ "Songs !!\n");
                                }else {
                                    System.out.println("\n\tCan't find Songs, Add Songs!!\n");
                                }
                            }
                            case 2 -> {
                                System.out.println("\n\n\t\t\t\t+SORT PUBLISH DATE"+separator);
                                ArrayList<Song> sortSongsDate = simplify.sortSongsDate(simplify.getSongs());
                                if (sortSongsDate.size() != 0) {
                                    System.out.println("\n\n\tSort for PUBLISH DATE \t-\tCant: " + sortSongsDate.size());
                                    for( Song s :sortSongsDate){
                                        s.showInformation();
                                    }
                                    System.out.println("\n\t\t>> Songs Ordered "+sortSongsDate.size()+ "Songs !!\n");
                                } else {
                                    System.out.println("\n\tCan't find Songs, Add Songs!!\n");
                                }
                            }
                        }
                    } while (userSort != 3);
                }
            }
        } while (user != 5);
        System.out.println("\nThe program is over");
        System.out.println("\nCreated By:\t< Nestor Quiroga />\t< Laura Gutierrez />");

    }
}
