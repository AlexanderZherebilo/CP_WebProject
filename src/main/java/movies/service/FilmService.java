package movies.service;

import movies.beans.Comment;
import movies.beans.Film;

import java.util.List;

public interface FilmService {
    List<Film> getAllFilms();

    List<Film> getAllFilmsReverse();

    List<Film> searchFilmsByName(String name);

    List<Film> searchFilmsByGenre(String genre);

    Film getFilmByName(String film);

    Film getFilmById(int id);

    List<Comment> getAllComents(String film);

    void updateFilm(Film film);

    void addFilm(Film film);

    void deleteFilm(Film film);

    List<Comment> getListOfComments(Film film);
}
