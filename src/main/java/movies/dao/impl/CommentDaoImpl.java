package movies.dao.impl;

import movies.beans.Comment;
import movies.dao.CommentDao;
import movies.utils.HibernateSessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CommentDaoImpl implements CommentDao {
    @Override
    public Comment findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Comment comment = session.get(Comment.class, id);
        session.close();
        return comment;
    }

    @Override
    public List<Comment> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Comment> comments = (List<Comment>) session.createQuery("From Comment").list();
        session.close();
        return comments;
    }

    @Override
    public boolean save(Comment comment) {
        boolean flag = false;
        Transaction tx1 = null;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
            tx1 = session.beginTransaction();
            session.saveOrUpdate(comment);
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
    public void update(Comment comment) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(comment);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Comment comment) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(comment);
        tx1.commit();
        session.close();
    }
}
