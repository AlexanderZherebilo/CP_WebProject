package movies.beans;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int user_id;
    private int film_id;
    private int rate;
    private Date date;
    private String article;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "film_id", insertable = false, updatable = false)
    private Film film;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    public Comment() {
    }

    public Comment(int user_id, int film_id, int rate, String article) {
        this.user_id = user_id;
        this.film_id = film_id;
        this.rate = rate;
        this.date = new Date();
        this.article = article;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", film_id=" + film_id +
                ", rate=" + rate +
                ", date=" + date +
                ", article='" + article + '\'' +
                '}';
    }
}