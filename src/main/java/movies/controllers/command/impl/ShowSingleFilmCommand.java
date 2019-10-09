package movies.controllers.command.impl;

import movies.beans.Comment;
import movies.beans.Film;
import movies.controllers.PageEnum;
import movies.controllers.command.ActionCommand;
import movies.controllers.command.impl.util.ForwardRedirectHelper;
import movies.controllers.command.impl.util.ParameterEnum;
import movies.service.impl.FilmServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowSingleFilmCommand implements ActionCommand {
    public void execute(HttpServletRequest req, HttpServletResponse resp, String logginedUser) {
        String filmName = req.getParameter(ParameterEnum.FILM_NAME.toString());
        preparePage(req, logginedUser, filmName);
        String path = PageEnum.SINGLE_FILM.toString();
        ForwardRedirectHelper.provideForward(req, resp, path);
    }

    private void preparePage(HttpServletRequest request, String loggined, String filmName) {
        request.setAttribute("loggined", loggined);
        FilmServiceImpl filmService = new FilmServiceImpl();
        Film film = filmService.getFilmByName(filmName);
        request.setAttribute("single_film", film);
        List<Comment> comments = filmService.getAllComents(film.getName());
        request.setAttribute("comment_list", comments);
        int comments_number = comments.size();
        request.setAttribute("comment_number", comments_number);
    }
}
