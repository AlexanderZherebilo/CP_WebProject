package movies.beans;

import java.util.List;
import javax.persistence.*;

@Entity
@Table (name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int year;
    private String country;
    @Column(name = "founder_name")
    private String founderName;
    @Column(name = "founder_surname")
    private String founderSurname;
    @Column(name = "head_name")
    private String headName;
    @Column(name = "head_surname")
    private String headSurname;
    private String site;
    private String article;
    private String image;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Film> films;

    public Company() {
    }

    public Company(String name, int year, String country, String founderName, String founderSurname, String headName, String headSurname, String site, String article, String image) {
        this.name = name;
        this.year = year;
        this.country = country;
        this.founderName = founderName;
        this.founderSurname = founderSurname;
        this.headName = headName;
        this.headSurname = headSurname;
        this.site = site;
        this.article = article;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFounderName() {
        return founderName;
    }

    public void setFounderName(String founderName) {
        this.founderName = founderName;
    }

    public String getFounderSurname() {
        return founderSurname;
    }

    public void setFounderSurname(String founderSurname) {
        this.founderSurname = founderSurname;
    }

    public String getHeadName() {
        return headName;
    }

    public void setHeadName(String headName) {
        this.headName = headName;
    }

    public String getHeadSurname() {
        return headSurname;
    }

    public void setHeadSurname(String headSurname) {
        this.headSurname = headSurname;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", country='" + country + '\'' +
                ", founderName='" + founderName + '\'' +
                ", founderSurname='" + founderSurname + '\'' +
                ", headName='" + headName + '\'' +
                ", headSurname='" + headSurname + '\'' +
                ", site='" + site + '\'' +
                ", article '" + article + '\'' +
                '}';
    }
}