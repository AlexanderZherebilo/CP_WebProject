package movies.controllers.command.impl;

import movies.beans.Company;
import movies.beans.Rating;
import movies.controllers.PageEnum;
import movies.controllers.command.ActionCommand;
import movies.controllers.command.impl.util.ForwardRedirectHelper;
import movies.service.impl.CompanyServiceImpl;
import movies.service.impl.RatingServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GoToAddingFilmCommand implements ActionCommand {

    public void execute(HttpServletRequest req, HttpServletResponse resp, String logginedUser) {
        preparePage(req, logginedUser);
        String path = PageEnum.ADDING_FILM_PAGE.toString();
        ForwardRedirectHelper.provideForward(req, resp, path);
    }

    private void preparePage(HttpServletRequest request, String loggined) {
        request.setAttribute("loggined", loggined);

        CompanyServiceImpl companyService = new CompanyServiceImpl();
        List<Company> companyList = companyService.getAllCompanies();
        request.setAttribute("companies_list", companyList);

        RatingServiceImpl ratingService = new RatingServiceImpl();
        List<Rating> ratingList = ratingService.getAll();
        request.setAttribute("rating_list", ratingList);
    }
}
