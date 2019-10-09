package movies.controllers.command.impl;

import movies.beans.Company;
import movies.beans.Film;
import movies.controllers.PageEnum;
import movies.controllers.command.ActionCommand;
import movies.controllers.command.impl.util.ForwardRedirectHelper;
import movies.service.impl.CommentServiceImpl;
import movies.service.impl.CompanyServiceImpl;
import movies.service.impl.FilmServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeleteSelectedCompanyCommand implements ActionCommand {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp, String logginedUser) throws ServletException, IOException {
        int selectedCompanyId = Integer.parseInt(req.getParameter("company_select_delete"));
        CompanyServiceImpl companyService = new CompanyServiceImpl();
        Company myCompany = companyService.getCompanyById(selectedCompanyId);

        if (companyService.getListOfFilms(myCompany).size() > 0)
            req.setAttribute("delete_company_error", "Нельзя удалить компанию, пока она содержит фильмы");
        else companyService.deleteCompany(myCompany);

        req.setAttribute("loggined", logginedUser);

        FilmServiceImpl filmService = new FilmServiceImpl();
        int filmsNum = filmService.getAllFilms().size();
        req.setAttribute("films_number", filmsNum);

        companyService = new CompanyServiceImpl();
        int comaniesNum = companyService.getAllCompanies().size();
        req.setAttribute("companies_number", comaniesNum);

        List<Film> filmList = filmService.getAllFilms();
        req.setAttribute("films_list", filmList);

        List<Company> companyList = companyService.getAllCompanies();
        req.setAttribute("companies_list", companyList);

        String path = PageEnum.SITEMAP_PAGE.toString();
        ForwardRedirectHelper.provideForward(req, resp, path);
    }
}
