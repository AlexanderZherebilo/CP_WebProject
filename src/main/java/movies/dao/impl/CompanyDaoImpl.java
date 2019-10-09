package movies.dao.impl;

import movies.beans.Company;
import movies.beans.Film;
import movies.dao.CompanyDao;
import movies.utils.HibernateSessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CompanyDaoImpl implements CompanyDao {
    @Override
    public Company findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Company company = session.get(Company.class, id);
        session.close();
        return company;
    }

    @Override
    public Company findByName(String companyName) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From Company where name=:companyName");
        query.setParameter("companyName", companyName);
        Company company = (Company) query.uniqueResult();
        session.close();
        return company;
    }

    @Override
    public int getNumber() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        int number = session.createQuery("From Company").list().size();
        session.close();
        return number;
    }

    @Override
    public boolean save(Company company) {
        boolean flag = false;
        Transaction tx1 = null;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
            tx1 = session.beginTransaction();
            session.save(company);
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
    public void update(Company company) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(company);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Company company) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(company);
        tx1.commit();
        session.close();
    }

    @Override
    public List<Company> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Company> companies = (List<Company>) session.createQuery("From Company ORDER BY name").list();
        session.close();
        return companies;
    }

    @Override
    public List<Company> findByCountry(String country) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Company WHERE country=:country");
        query.setParameter("country", country);
        List<Company> companies = (List<Company>) query.getResultList();
        session.close();
        return companies;
    }

    @Override
    public List<Company> findByYears(int minYear, int maxYear) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Company WHERE year>=:minYear AND year<=:maxYear");
        query.setParameter("minYear", minYear);
        query.setParameter("maxYear", maxYear);
        List<Company> companies = (List<Company>) query.getResultList();
        session.close();
        return companies;
    }

    @Override
    public List<Film> findListOfFilms(int companyId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Company WHERE id=:companyId");
        query.setParameter("companyId", companyId);
        Company company = (Company) query.uniqueResult();
        List<Film> filmsByComany = company.getFilms();
        return filmsByComany;
    }
}
