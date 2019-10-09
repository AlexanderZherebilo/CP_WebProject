package movies.dao.impl;

import movies.beans.Comment;
import movies.beans.User;
import movies.dao.UserDao;
import movies.utils.HibernateSessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public User findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    @Override
    public User findByLogin(String login) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From User where login=:login");
        query.setParameter("login", login);
        User user = (User) query.uniqueResult();
        session.close();
        return user;
    }

    @Override
    public User findByEmail(String email) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From User where email=:email");
        query.setParameter("email", email);
        User user = (User) query.uniqueResult();
        session.close();
        return user;
    }

    @Override
    public List<User> findByCountry(String country) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From User where country=:country");
        query.setParameter("country", country);
        List<User> users = (List<User>) query.getResultList();
        session.close();
        return users;
    }

    @Override
    public int getNumber() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        int number = session.createQuery("From User").list().size();
        session.close();
        return number;
    }

    @Override
    public boolean save(User user) {
        boolean flag = false;
        Transaction tx1 = null;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
            tx1 = session.beginTransaction();
            session.saveOrUpdate(user);
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
    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    @Override
    public List<User> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<User> users = (List<User>) session.createQuery("From User").list();
        session.close();
        return users;
    }

    @Override
    public List<Comment> findListOfComments(String loginUser) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM User WHERE film_rating=:login");
        query.setParameter("login", loginUser);
        User user = (User) query.uniqueResult();
        List<Comment> commentsByThisUser = user.getComments();
        return commentsByThisUser;
    }

    @Override
    public boolean checkByLogin(String login, String password) {
        User user = findByLogin(login);
        if (user != null) {
            if (password.equals(user.getPassword())) {
                return true;
            }
            else return false;
        }
        else return false;
    }

    @Override
    public boolean checkByEmail(String email, String password) {
        User user = findByEmail(email);
        if (user != null) {
            if (password.equals(user.getPassword())) {
                return true;
            }
            else return false;
        }
        else return false;
    }
}
