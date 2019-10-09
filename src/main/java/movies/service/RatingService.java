package movies.service;

import movies.beans.Film;
import movies.beans.Rating;

import java.util.List;

public interface RatingService {
    Rating getByKey(String filmRating);

    List<Rating> getAll();

    List<Film> getListOfFilms(String filmRating);
}
