package movies.dao;

import movies.beans.Comment;
import movies.beans.Film;

import java.util.List;

public interface FilmDao {
    Film findById(int id);

    Film findByName(String filmName);

    List<Film> searchByGenre(String genre);

    List<Film> searchByName(String name);

    List<Film> findByMinRate (double minRate);

    List<Film> findByBudget (double min_budget, double max_budget);

    List<Film> findByBoxOffice (double min_boxOffice, double max_boxOffice);

    boolean save(Film film);

    void update(Film film);

    void delete(Film film);

    List<Film> findAll();

    List<Film> findAllReverse();

    List<Comment> findListOfComments (String filmName);
}
