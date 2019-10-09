package movies.controllers.command.impl;

import movies.beans.Film;
import movies.controllers.PageEnum;
import movies.controllers.command.ActionCommand;
import movies.controllers.command.impl.util.ForwardRedirectHelper;
import movies.service.impl.FilmServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GoToFilmsList implements ActionCommand {
    public void execute(HttpServletRequest req, HttpServletResponse resp, String logginedUser) {
        preparePage(req, logginedUser);
        String path = PageEnum.FILMS_PAGE.toString();
        ForwardRedirectHelper.provideForward(req, resp, path);
    }

    private void preparePage(HttpServletRequest request, String loggined) {
        request.setAttribute("loggined", loggined);
        FilmServiceImpl filmService = new FilmServiceImpl();
        List<Film> films = filmService.getAllFilms();
        request.setAttribute("films_list", films);
    }
}
