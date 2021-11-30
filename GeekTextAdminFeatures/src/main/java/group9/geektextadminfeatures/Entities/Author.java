package group9.geektextadminfeatures.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "authorcatalog")
public class Author {

    @Id
    private Integer authorID;

    private String authorFirstname;

    private String authorLastName;

    private String authorBio;

    private String authorPub;

    public Author(Integer authorID, String authorFirstname, String authorLastName, String authorBio, String authorPub) {
        this.authorID = authorID;
        this.authorFirstname = authorFirstname;
        this.authorLastName = authorLastName;
        this.authorBio = authorBio;
        this.authorPub = authorPub;
    }

    public Integer getAutorID() {
        return authorID;
    }

    public void setAutorID(Integer autorID) {
        this.authorID = autorID;
    }

    public String getAuthorFirstname() {
        return authorFirstname;
    }

    public void setAuthorFirstname(String authorFirstname) {
        this.authorFirstname = authorFirstname;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getAuthorBio() {
        return authorBio;
    }

    public void setAuthorBio(String authorBio) {
        this.authorBio = authorBio;
    }

    public String getAuthorPub() {
        return authorPub;
    }

    public void setAuthorPub(String authorPub) {
        this.authorPub = authorPub;
    }
}