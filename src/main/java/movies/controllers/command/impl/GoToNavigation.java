package movies.controllers.command.impl;

import movies.beans.Company;
import movies.beans.Film;
import movies.controllers.PageEnum;
import movies.controllers.command.ActionCommand;
import movies.controllers.command.impl.util.ForwardRedirectHelper;
import movies.service.impl.CompanyServiceImpl;
import movies.service.impl.FilmServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GoToNavigation implements ActionCommand {
    public void execute(HttpServletRequest req, HttpServletResponse resp, String logginedUser) {
        preparePage(req, logginedUser);
        String path = PageEnum.SITEMAP_PAGE.toString();
        ForwardRedirectHelper.provideForward(req, resp, path);
    }

    private void preparePage(HttpServletRequest request, String loggined) {
        request.setAttribute("loggined", loggined);

        FilmServiceImpl filmService = new FilmServiceImpl();
        int filmsNum = filmService.getAllFilms().size();
        request.setAttribute("films_number", filmsNum);

        CompanyServiceImpl companyService = new CompanyServiceImpl();
        int comaniesNum = companyService.getAllCompanies().size();
        request.setAttribute("companies_number", comaniesNum);

        List<Film> filmList = filmService.getAllFilms();
        request.setAttribute("films_list", filmList);

        List<Company> companyList = companyService.getAllCompanies();
        request.setAttribute("companies_list", companyList);
    }
}
