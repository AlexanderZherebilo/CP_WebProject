package movies.controllers.command.impl;

import movies.beans.Company;
import movies.beans.Film;
import movies.beans.Rating;
import movies.controllers.PageEnum;
import movies.controllers.command.ActionCommand;
import movies.controllers.command.impl.util.ForwardRedirectHelper;
import movies.controllers.command.impl.util.ParameterEnum;
import movies.service.impl.CompanyServiceImpl;
import movies.service.impl.FilmServiceImpl;
import movies.service.impl.RatingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EditSelectedFilmCommand implements ActionCommand {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp, String logginedUser) throws ServletException, IOException {
        int selectedFilmId = Integer.parseInt(req.getParameter("film_select_update"));
        FilmServiceImpl filmService = new FilmServiceImpl();
        Film myFilm = filmService.getFilmById(selectedFilmId);

        preparePage(req, logginedUser, myFilm);
        String path = PageEnum.EDITING_FILM_PAGE.toString();
        ForwardRedirectHelper.provideForward(req, resp, path);
    }

    private void preparePage(HttpServletRequest request, String loggined, Film myFilm) {
        request.setAttribute("loggined", loggined);

        CompanyServiceImpl companyService = new CompanyServiceImpl();
        List<Company> companyList = companyService.getAllCompanies();
        request.setAttribute("companies_list", companyList);

        RatingServiceImpl ratingService = new RatingServiceImpl();
        List<Rating> ratingList = ratingService.getAll();
        request.setAttribute("rating_list", ratingList);

        myFilm.setImage(myFilm.getImage().substring(25));
        request.setAttribute("film_edit", myFilm);
    }

}
