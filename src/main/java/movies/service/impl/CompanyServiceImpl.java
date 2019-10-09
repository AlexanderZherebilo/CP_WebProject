package movies.service.impl;

import movies.beans.Company;
import movies.beans.Film;
import movies.dao.impl.CompanyDaoImpl;
import movies.service.CompanyService;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {
    CompanyDaoImpl companyDao = new CompanyDaoImpl();

    @Override
    public List<Company> getAllCompanies() {
        return companyDao.findAll();
    }

    @Override
    public Company getCompanyByName(String name) {
        return companyDao.findByName(name);
    }

    @Override
    public void addCompany(Company company) {
        companyDao.save(company);
    }

    @Override
    public Company getCompanyById(int id) {
        return companyDao.findById(id);
    }

    @Override
    public List<Film> getListOfFilms(Company company) {
        return companyDao.findListOfFilms(company.getId());
    }

    @Override
    public void deleteCompany(Company company) {
        companyDao.delete(company);
    }

    @Override
    public void editCompany(Company company) {
        companyDao.update(company);
    }
}
