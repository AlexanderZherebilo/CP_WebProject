package movies.dao.impl;

import movies.beans.Film;
import movies.beans.Rating;
import movies.dao.RatingDao;
import movies.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RatingDaoImpl implements RatingDao {
    @Override
    public Rating findByKey(String filmRating) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From Rating where film_rating=:filmrating");
        query.setParameter("filmrating", filmRating);
        Rating rating = (Rating) query.uniqueResult();
        session.close();
        return rating;
    }

    @Override
    public List<Rating> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Rating> rating = (List<Rating>) session.createQuery("From Rating ORDER BY min_age").list();
        session.close();
        return rating;
    }

    @Override
    public List<Film> findListOfFilms(String filmRating) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Rating WHERE film_rating=:rating");
        query.setParameter("rating", filmRating);
        Rating rating = (Rating) query.uniqueResult();
        List<Film> filmsWithThisRating = rating.getFilms();
        return filmsWithThisRating;
    }
}
