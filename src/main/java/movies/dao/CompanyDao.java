package movies.dao;

import movies.beans.Company;
import movies.beans.Film;

import java.util.List;

public interface CompanyDao {
    Company findById(int id);

    Company findByName(String companyName);

    int getNumber();

    boolean save(Company company);

    void update(Company company);

    void delete(Company company);

    List<Company> findAll();

    List<Company> findByCountry(String country);

    List<Company> findByYears(int minYear, int maxYear);

    List<Film> findListOfFilms(int companyId);
}
