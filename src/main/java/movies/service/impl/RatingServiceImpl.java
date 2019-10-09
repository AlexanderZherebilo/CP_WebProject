package movies.service.impl;

import movies.beans.Film;
import movies.beans.Rating;
import movies.dao.impl.RatingDaoImpl;
import movies.service.RatingService;

import java.util.List;

public class RatingServiceImpl implements RatingService {
    private RatingDaoImpl ratingDao = new RatingDaoImpl();

    @Override
    public Rating getByKey(String filmRating) {
        return ratingDao.findByKey(filmRating);
    }

    @Override
    public List<Rating> getAll() {
        return ratingDao.findAll();
    }

    @Override
    public List<Film> getListOfFilms(String filmRating) {
        return ratingDao.findListOfFilms(filmRating);
    }
}
