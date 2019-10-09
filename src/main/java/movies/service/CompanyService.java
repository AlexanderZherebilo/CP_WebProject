package movies.service;

import movies.beans.Company;
import movies.beans.Film;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();

    Company getCompanyByName(String name);

    Company getCompanyById(int id);

    void addCompany(Company company);

    void deleteCompany(Company company);

    void editCompany(Company company);

    List<Film> getListOfFilms(Company company);
}
