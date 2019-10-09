package movies.dao.impl;

import movies.beans.Comment;
import movies.beans.Film;
import movies.dao.FilmDao;
import movies.utils.HibernateSessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class FilmDaoImpl implements FilmDao {
    @Override
    public Film findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Film film = session.get(Film.class, id);
        session.close();
        return film;
    }

    @Override
    public Film findByName(String filmName) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From Film where name=:filmName");
        query.setParameter("filmName", filmName);
        Film film = (Film) query.uniqueResult();
        session.close();
        return film;
    }

    @Override
    public List<Film> searchByGenre(String genre) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Film WHERE genre LIKE :genre");
        query.setParameter("genre", genre);
        List<Film> films = (List<Film>) query.getResultList();
        session.close();
        return films;
    }

    @Override
    public List<Film> searchByName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Film WHERE name LIKE :name");
        query.setParameter("name", name);
        List<Film> films = (List<Film>) query.getResultList();
        session.close();
        return films;
    }

    @Override
    public List<Film> findByMinRate(double minRate) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Film WHERE rate>=:minRate");
        query.setParameter("minRate", minRate);
        List<Film> films = (List<Film>) query.getResultList();
        session.close();
        return films;
    }

    @Override
    public List<Film> findByBudget(double min_budget, double max_budget) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Film WHERE budget>=:minBudget AND budget<=:maxBudget");
        query.setParameter("minBudget", min_budget);
        query.setParameter("maxBudget", max_budget);
        List<Film> films = (List<Film>) query.getResultList();
        session.close();
        return films;
    }

    @Override
    public List<Film> findByBoxOffice(double min_boxOffice, double max_boxOffice) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Film WHERE box_office>=:minBoxOffice AND box_office<=:maxBoxOffice");
        query.setParameter("minBoxOffice", min_boxOffice);
        query.setParameter("maxBoxOffice", max_boxOffice);
        List<Film> films = (List<Film>) query.getResultList();
        session.close();
        return films;
    }

    @Override
    public boolean save(Film film) {
        boolean flag = false;
        Transaction tx1 = null;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
            tx1 = session.beginTransaction();
            session.save(film);
            tx1.commit();
            flag = true;
        }
        catch (HibernateException e) {
            e.printStackTrace();
            tx1.rollback();
        }
        session.close();
        return flag;
    }

    @Override
    public void update(Film film) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(film);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Film film) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(film);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Film> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Film> films = (List<Film>) session.createQuery("From Film order by name").list();
        session.close();
        return films;
    }

    @Override
    public List<Film> findAllReverse() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Film> films = (List<Film>) session.createQuery("From Film order by name desc ").list();
        session.close();
        return films;
    }

    @Override
    public List<Comment> findListOfComments(String filmName) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Film WHERE name=:filmName");
        query.setParameter("filmName", filmName);
        Film film = (Film) query.uniqueResult();
        List<Comment> commentsToFilm = film.getComments();
        return commentsToFilm;
    }
}
