package movies.controllers.command.impl;

import movies.beans.Rating;
import movies.controllers.PageEnum;
import movies.controllers.command.ActionCommand;
import movies.controllers.command.impl.util.ForwardRedirectHelper;
import movies.service.impl.RatingServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GoToRaitingList implements ActionCommand {
    public void execute(HttpServletRequest req, HttpServletResponse resp, String logginedUser) {
        preparePage(req, logginedUser);
        String path = PageEnum.RAITING_PAGE.toString();
        ForwardRedirectHelper.provideForward(req, resp, path);
    }

    private void preparePage(HttpServletRequest request, String loggined) {
        request.setAttribute("loggined", loggined);
        RatingServiceImpl ratingService = new RatingServiceImpl();
        List<Rating> ratings = ratingService.getAll();
        request.setAttribute("rating_list", ratings);
    }
}
