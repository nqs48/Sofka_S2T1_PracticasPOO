package Model;

import java.util.Calendar;

public class Song{

    private final String name;
    private final int id;
    private final String author;
    private final Calendar publicationDate ;
    private final int duration;
    private final String gender;
    private final String cover;
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


    //GETTER ONLY, The functionality of the application does not allow changes in its parameters

    public String getName() {
        return this.name;
    }

    public int getId() { return id; }

    public String getAuthor() {
        return author;
    }

    public Calendar getDatePublish() {
        return publicationDate;
    }

    public int getDuration() {
        return duration;
    }

    public String getGender() {
        return gender;
    }

    public String getCover() { return cover; }

    public String getDescription() { return description; }


    public void showInformationS(Model.Song i) {
        System.out.println("\n\tId Song: " + i.getId() + "\n\t\tTitle: " + i.getName() + "\n\t\tAuthor: " + i.getAuthor() +
                "\n\t\tDate: " + i.getDatePublish().get(Calendar.YEAR) + "/" + i.getDatePublish().get(Calendar.MONTH) +
                "/" + i.getDatePublish().get(Calendar.DAY_OF_MONTH)+ "\n\t\tDuration: " + i.getDuration()+
                " seconds\n\t\tGender: " + i.getGender() + "\n\t\tCover: " + i.getCover() + "\n\t\tDescription: "+i.getDescription()+"\n");

    }

}
