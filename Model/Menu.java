package Model;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Nestor Quiroga
 * @author Laura Gutierrez
 * Class Menu, contains menus and submenus
 */
public class Menu {

    /**
     * Constructor class menu, is a empty constructor, don't needs information.
     */
    public Menu() {
    }

    /**
     * Menu to choose if init with preloaded data or not.
     * @param separator String with characters for separate lines in the menu
     * @return returns the value corresponding to the option
     */
    public int printPreloadMenu(String separator){
        try{
            int user;
            System.out.println("\n\t\t\t\tSIMPLIFY | MENU"+separator);
            System.out.println("> Do you want preload DATA? (Songs and Playlist)");
            System.out.println("| 1. Yes: (1)");
            System.out.println("| 2. No: (2)");
            System.out.println("\nEnter the number of your process:"+separator);
            Scanner inputPreload = new Scanner(System.in);
            user=inputPreload.nextInt();
            return user;
        }catch (InputMismatchException e ){
            System.out.println("\n\tIncorrect selection data!!\n\nError: "+e);
            return 0;
        }


    }

    /**
     * Menu to choose the main option
     * @param separator String with characters for separate lines in the menu
     * @return returns the value corresponding to the option
     */
    public int printMainMenu(String separator){
        try{
            int user;
            System.out.println("\n\t\t\t\tSIMPLIFY | MENU"+separator);
            System.out.println("| 1. Songs: (1)");
            System.out.println("| 2. Playlists: (2)");
            System.out.println("| 3. Filters Songs: (3)");
            System.out.println("| 4. Sorts Songs: (4)");
            System.out.println("| 5. EXIT APP: (5)"+separator);
            System.out.println("Enter the number of your process:");
            Scanner inputMain = new Scanner(System.in);
            user= inputMain.nextInt();
            return user;
        }catch (InputMismatchException e ){
            System.out.println("\n\tIncorrect selection data, try again.\n\nError: \n"+e);
            return 0;
        }
    }

    /**
     * Submenu with actions to songs
     * @param separator String with characters for separate lines in the menu
     * @return returns the value corresponding to the option
     */
    public int printMenuSong(String separator){
        try{
            int user;
            System.out.println("\n\n\t\t\t\tSONGS | SUBMENU"+separator);
            System.out.println("| 1. Create Song: (1)");
            System.out.println("| 2. View Songs: (2)");
            System.out.println("| 3. Add Song to PlayList: (3)");
            System.out.println("| 4. RETURN MENU: (4)"+separator);
            System.out.println("Enter the number of your process:");
            Scanner inputSongs = new Scanner(System.in);
            user= inputSongs.nextInt();
            return user;
        }catch (InputMismatchException e ){
            System.out.println("\n\tIncorrect selection data, try again.\n\nError: "+e);
            return 0;
        }
    }

    /**
     * Submenu with actions to playlist
     * @param separator String with characters for separate lines in the menu
     * @return returns the value corresponding to the option
     */
    public int printMenuPlayList(String separator) {
        try{
            int user;
            System.out.println("\n\n\t\t\t\tPLAYLIST | SUBMENU" + separator);
            System.out.println("| 1. Create PlayList: (1)");
            System.out.println("| 2. View PlayLists: (2)");
            System.out.println("| 3. RETURN MENU: (3)" + separator);
            System.out.println("Enter the number of your process:");
            Scanner inputPlaylist = new Scanner(System.in);
            user = inputPlaylist.nextInt();
            return user;
        }catch (InputMismatchException e ){
            System.out.println("\n\tIncorrect selection data, try again.\n\nError: "+e);
            return 0;
        }
    }

    /**
     * Submenu with actions to filters
     * @param separator String with characters for separate lines in the menu
     * @return returns the value corresponding to the option
     */
    public int printMenuFilters(String separator){
        try{
            int user;
            System.out.println("\n\n\t\t\tFILTERS SONGS | SUBMENU"+separator);
            System.out.println("| 1. Filter Gender: (1)");
            System.out.println("| 2. Filter Year: (2)");
            System.out.println("| 3. Filter Id: (3)");
            System.out.println("| 4. RETURN MENU: (4)"+separator);
            System.out.println("Enter the number of your process:");
            Scanner inputFilter = new Scanner(System.in);
            user= inputFilter.nextInt();
            return user;
        }catch (InputMismatchException e ){
            System.out.println("\n\tIncorrect selection data, try again.\n\nError: "+e);
            return 0;
        }
    }

    /**
     * Submenu with actions to sorts
     * @param separator String with characters for separate lines in the menu
     * @return returns the value corresponding to the option
     */
    public int printMenuSorts(String separator){
        try{
            int user;
            System.out.println("\n\n\t\t\t\tSORTS SONGS | SUBMENU"+separator);
            System.out.println("| 1. Sort Duration: (1)");
            System.out.println("| 2. Sort Publish Date: (2)");
            System.out.println("| 3. RETURN MENU: (3)"+separator);
            System.out.println("Enter the number of your process:");
            Scanner inputSort = new Scanner(System.in);
            user= inputSort.nextInt();
            return user;
        }catch (InputMismatchException e ){
            System.out.println("\n\tIncorrect selection data, try again.\n\nError: "+e);
            return 0;
        }
    }

}
