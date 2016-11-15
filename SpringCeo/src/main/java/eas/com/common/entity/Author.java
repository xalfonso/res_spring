package eas.com.common.entity;

import javax.persistence.*;

/**
 * Created by eduardo on 11/6/2016.
 */
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, length = 20)
    private long id;

    @Column(name = "firstname", length = 50, nullable = false)
    private String firstName;

    @Column(name = "secondname", length = 50)
    private String secondName;

    @Column(name = "firstsurname", length = 50, nullable = false)
    private String firstSurname;

    @Column(name = "secondSurname", length = 50, nullable = false)
    private String secondSurname;


    public Author(String firstName, String secondName, String firstSurname, String secondSurname) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
    }

    public Author() {
    }


    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", firstSurname='" + firstSurname + '\'' +
                ", secondSurname='" + secondSurname + '\'' +
                '}';
    }

    /*Setter and Getter*/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public Author setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getSecondName() {
        return secondName;
    }

    public Author setSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public Author setFirstSurname(String firtSurname) {
        this.firstSurname = firtSurname;
        return this;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public Author setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
        return this;
    }
}
