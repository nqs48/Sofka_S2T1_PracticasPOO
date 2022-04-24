package Model;


import java.util.Calendar;

/**
 * @author Nestor Quiroga
 * @author Laura Gutierrez
 * Class Song
 */
public class Song{
    /**
     * Song's title
     */
    private final String name;

    /**
     * Song's id
     */
    private final int id;

    /**
     * Song's author
     */
    private final String author;

    /**
     * Song's publicationDate
     */
    private final Calendar publicationDate ;

    /**
     * Song's duration
     */
    private final int duration;

    /**
     * Song's gender
     */
    private final String gender;

    /**
     * Song's cover link
     */
    private final String cover;

    /**
     * Song's cover description
     */
    public final String description;


    /**
     *  Constructor class Song
     * @param name value to song's name
     * @param id value to song's id
     * @param duration value to song's duration
     * @param gender value to song's gender
     * @param cover value to song's cover
     * @param description value to song's description
     */
    public Song(String name, String author, int id, int duration,int year,int month, int day, String gender, String cover, String description) {
        this.name=name;
        this.author= author;
        this.id = id;
        this.publicationDate = Calendar.getInstance();
        this.publicationDate.set(year,month,day);
        this.duration = duration;
        this.gender = gender;
        this.cover = cover;
        this.description = description;
    }


    /*GETTERS ONLY, The functionality of the application does not allow changes in this parameters*/

    /**
     * Get the current song's title
     * @return returns the song's title type string
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the current song's id
     * @return returns the song's id type string
     */
    public int getId() { return id; }

    /**
     * Get the current song's author
     * @return returns the song's author type string
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Get the current song's publication date
     * @return returns the song's publication date type calendar
     */
    public Calendar getPublicationDate() {
        return publicationDate;
    }

    /**
     * Get the current song's duration
     * @return returns the song's duration type string
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Get the current song's gender
     * @return returns the song's gender type string
     */
    public String getGender() {
        return gender;
    }

    /**
     * Get the current song's cover link
     * @return returns the song's cover link type string
     */
    public String getCover() { return cover; }

    /**
     * Get the current song's description
     * @return returns the song's description type string
     */
    public String getDescription() { return description; }

    /**
     * Show the song's information formatted
     */
    public void showInformation() {
        System.out.println("\n++++++++++++++ Id Song: " + getId() +" ++++++++++++++" + "\n\tTitle: " + getName() + "\n\tAuthor: " + getAuthor() +
                "\n\tDate: " + getPublicationDate().get(Calendar.YEAR) + "/" + getPublicationDate().get(Calendar.MONTH) +
                "/" + getPublicationDate().get(Calendar.DAY_OF_MONTH)+ "\n\tDuration: " + getDuration()+
                " seconds\n\tGender: " + getGender() + "\n\tCover: " + getCover() + "\n\tDescription: "+getDescription()+"\n");
        System.out.print("-----------------------------------------\n\n");
    }


}
