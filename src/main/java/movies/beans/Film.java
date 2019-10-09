package movies.beans;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String genre;
    @Column(name = "company_id")
    private int companyId;
    @Column(name = "director_name")
    private String directorName;
    @Column(name = "director_surname")
    private String directorSurname;
    private double rate;
    @Column(name = "film_rating")
    private String filmRating;
    private double budget;
    @Column(name = "box_office")
    private double boxOffice;
    private int year;
    private String article;
    private String image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "film_rating", insertable = false, updatable = false)
    private Rating rating;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    public Film() {
    }

    public Film(String name, String genre, int companyId, String directorName, String directorSurname, String filmRating, double budget, double boxOffice, int year, String article, String image) {
        this.name = name;
        this.genre = genre;
        this.companyId = companyId;
        this.directorName = directorName;
        this.directorSurname = directorSurname;
        this.rate = 0;
        this.filmRating = filmRating;
        this.budget = budget;
        this.boxOffice = boxOffice;
        this.article = article;
        this.image = image;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getDirectorSurname() {
        return directorSurname;
    }

    public void setDirectorSurname(String directorSurname) {
        this.directorSurname = directorSurname;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getFilmRating() {
        return filmRating;
    }

    public void setFilmRating(String filmRating) {
        this.filmRating = filmRating;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(double boxOffice) {
        this.boxOffice = boxOffice;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
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

    public int getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", companyId=" + companyId +
                ", directorName='" + directorName + '\'' +
                ", directorSurname='" + directorSurname + '\'' +
                ", rate=" + rate +
                ", filmRating='" + filmRating + '\'' +
                ", budget=" + budget +
                ", boxOffice=" + boxOffice +
                ", article='" + article + '\'' +
                '}';
    }
}