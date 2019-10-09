package movies.beans;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @Column(name = "film_rating")
    private String filmRating;
    private String name;
    @Column(name = "min_age")
    private int minAge;
    private String article;

    @OneToMany(mappedBy = "rating", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Film> films;

    public Rating() {
    }

    public Rating(String filmRating, String name, int minAge) {
        this.filmRating = filmRating;
        this.name = name;
        this.minAge = minAge;
    }

    public String getFilmRating() {
        return filmRating;
    }

    public void setFilmRating(String filmRating) {
        this.filmRating = filmRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
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

    @Override
    public String toString() {
        return "Rating{" +
                "filmRating='" + filmRating + '\'' +
                ", name='" + name + '\'' +
                ", minAge=" + minAge +
                ", article =" + article +
                '}';
    }
}
