package View;

import Model.MusicLibrary;
import Model.Playlist;
import Model.Song;
import Model.Menu;

import java.util.*;

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
                                System.out.println("\n\n\t\t\t\t+CREATE SONG"+separator);
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
                                int autogenerateId = simplify.getSongs().size() + 1;
                                Song s1 = new Song(s1Name, s1author, autogenerateId, s1Duration, s1Year, s1Month, s1Day, s1Gender, s1Cover, s1Description);
                                simplify.getSongs().add(s1);
                                System.out.println("\n\tThe song was created successfully!!");
                                s1.showInformationS(s1);
                            }
                            case 2 -> {
                                System.out.println("\n\n\t\t\t\t+VIEW SONGS"+separator);
                                if (simplify.getSongs().size() != 0) {
                                    for (Song i : simplify.getSongs()) {
                                        i.showInformationS(i);
                                    }
                                } else {
                                    System.out.println("\n\tThere aren't Songs, add a new song!!\n");
                                }
                            }
                            case 3 -> {
                                System.out.println("\n\n\t\t\t+ADD SONG TO PLAYLIST"+separator);
                                if (simplify.getPlayLists().size() != 0 && simplify.getSongs().size() != 0) {
                                    for (Song i : simplify.getSongs()) {
                                        i.showInformationS(i);
                                    }
                                    System.out.println("\nEnter the song's ID to add: ");
                                    Scanner idSong = new Scanner(System.in);
                                    int idFilter = idSong.nextInt();

                                    Song songToAdd = simplify.idFilterSong(simplify.getSongs(), idFilter);
                                    if(songToAdd != null){
                                        System.out.println("\n>> Song: " +songToAdd.getName() +" to  => ");
                                        System.out.println("\nCurrent Playlists : ");
                                        for (Playlist i : simplify.getPlayLists()) {
                                            i.showInformationPL(i);
                                        }
                                        System.out.println("\nEnter the playList's ID to select: ");
                                        Scanner idList = new Scanner(System.in);
                                        int idFilterList = idList.nextInt();
                                        Playlist playListSelected = simplify.idFilterPlayList(simplify.getPlayLists(), idFilterList);
                                        if (playListSelected != null){
                                            playListSelected.setSong(songToAdd);
                                            System.out.println("\nAdded successfully!!\n\n\t>> Song: " +songToAdd.getName() +" to  => "+ playListSelected.getName() + "!!\n");
                                        }else{
                                            System.out.println("\n\tThere aren't any PLAYLIST  with this ID !!\n");
                                        }
                                    }else {
                                        System.out.println("\n\tThere aren't any SONG with this ID !!\n");
                                    }
                                } else {
                                    System.out.println("\n\tThere aren't PLAYLISTS or SONGS, verify your currently DATA!!\n");
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
                                pl.showInformationPL(pl);
                            }
                            case 2 -> {
                                System.out.println("\n\n\t\t\t\t+VIEW PLAYLISTS"+separator);
                                if (simplify.getPlayLists().size() != 0) {
                                    for (Playlist i : simplify.getPlayLists()) {
                                        i.showInformationPL(i);
                                    }
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
                                simplify.findGenders(simplify.getSongs()).forEach((s)-> System.out.print("-> "+s+"\t\t"));
                                System.out.println("\n\nEnter the Song's Gender to Filter: ");
                                Scanner genderSong = new Scanner(System.in);
                                String genderSelected = genderSong.nextLine();

                                ArrayList<Song> filteredSongs = simplify.filter(simplify.getSongs(), genderSelected);
                                if (filteredSongs.size() != 0) {
                                    System.out.println("\n\n\tSongs gender "+genderSelected.toUpperCase()+"\t-\tCant: " + filteredSongs.size());
                                    filteredSongs.forEach((s)->s.showInformationS(s));
                                } else {
                                    System.out.println("\n\tCan't find Songs in this gender!!\n");
                                }
                            }
                            case 2 -> {
                                System.out.println("\n\n\t\t\t\t+FILTER YEAR"+separator);
                                System.out.println("\nEnter the Song's Year to Filter: ");
                                Scanner yearSong = new Scanner(System.in);
                                int yearSelected = yearSong.nextInt();

                                ArrayList<Song> yearSongs = simplify.filter(simplify.getSongs(), yearSelected);
                                if (yearSongs.size() != 0) {
                                    System.out.println("\n\n\tSongs year "+yearSelected+"\t-\tCant: " + yearSongs.size());
                                    yearSongs.forEach((s)->s.showInformationS(s));
                                } else {
                                    System.out.println("\n\tCan't find Songs on this year!!\n");
                                }
                            }
                            case 3 -> {
                                System.out.println("\n\n\t\t\t\t+FILTER ID"+separator);
                                System.out.println("\nEnter the Song's ID to Filter: ");
                                Scanner idSong = new Scanner(System.in);
                                int idSelected = idSong.nextInt();
                                Song songFind = simplify.idFilterSong(simplify.getSongs(), idSelected);
                                if (songFind != null) {
                                    songFind.showInformationS(songFind);
                                } else {
                                    System.out.println("\n\tCan't find Song with this ID!!\n");
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
                                    sortSongsDuration.forEach((s)->s.showInformationS(s));
                                } else {
                                    System.out.println("\n\tCan't find Songs, Add Songs!!\n");
                                }
                            }
                            case 2 -> {
                                System.out.println("\n\n\t\t\t\t+SORT PUBLISH DATE"+separator);
                                ArrayList<Song> sortSongsDate = simplify.sortSongsDate(simplify.getSongs());
                                if (sortSongsDate.size() != 0) {
                                    System.out.println("\n\n\tSort for PUBLISH DATE \t-\tCant: " + sortSongsDate.size());
                                    sortSongsDate.forEach((s)->s.showInformationS(s));
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
        System.out.println("\nCreated By:\t<Nestor Quiroga<>\t<>Laura Gutierrez/>");
    }
}
