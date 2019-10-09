package movies.service.impl;

import movies.beans.Comment;
import movies.beans.Film;
import movies.dao.impl.FilmDaoImpl;
import movies.service.FilmService;

import java.util.List;

public class FilmServiceImpl implements FilmService {
    FilmDaoImpl filmDao = new FilmDaoImpl();

    @Override
    public List<Film> getAllFilms() {
        return filmDao.findAll();
    }

    @Override
    public List<Film> getAllFilmsReverse() {
        return filmDao.findAllReverse();
    }

    @Override
    public List<Film> searchFilmsByName(String name) {
        return filmDao.searchByName(name);
    }

    @Override
    public List<Film> searchFilmsByGenre(String genre) {
        return filmDao.searchByGenre(genre);
    }

    @Override
    public Film getFilmByName(String film) {
        return filmDao.findByName(film);
    }

    @Override
    public Film getFilmById(int id) {
        return filmDao.findById(id);
    }

    @Override
    public List<Comment> getAllComents(String film) {
        return filmDao.findListOfComments(film);
    }

    @Override
    public void updateFilm(Film film) {
        filmDao.update(film);
    }

    @Override
    public void addFilm(Film film) {
        filmDao.save(film);
    }

    @Override
    public void deleteFilm(Film film) {
        filmDao.delete(film);
    }

    @Override
    public List<Comment> getListOfComments(Film film) {
        return filmDao.findListOfComments(film.getName());
    }
}
