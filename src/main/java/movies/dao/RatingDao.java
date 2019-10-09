package movies.dao;

import movies.beans.Film;
import movies.beans.Rating;

import java.util.List;

public interface RatingDao {
    Rating findByKey(String filmRating);

    List<Rating> findAll();

    List<Film> findListOfFilms(String filmRating);
}
