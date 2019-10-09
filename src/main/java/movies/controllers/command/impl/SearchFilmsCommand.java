package movies.controllers.command.impl;

import movies.beans.Film;
import movies.controllers.PageEnum;
import movies.controllers.command.ActionCommand;
import movies.controllers.command.impl.util.ForwardRedirectHelper;
import movies.service.impl.FilmServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchFilmsCommand implements ActionCommand {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp, String logginedUser) throws ServletException, IOException {
        preparePage(req, logginedUser);
        String path = PageEnum.FILMS_PAGE.toString();
        ForwardRedirectHelper.provideForward(req, resp, path);
    }

    private void preparePage(HttpServletRequest request, String loggined) {
        String searchType = request.getParameter("search_type");
        request.setAttribute("loggined", loggined);

        FilmServiceImpl filmService = new FilmServiceImpl();
        List<Film> films = filmService.getAllFilms();
        String searchValue = request.getParameter("criterion");

        if (searchType.equals("filmName"))
        films = filmService.searchFilmsByName(searchValue);
        else if (searchType.equals("genreName"))
            films = filmService.searchFilmsByGenre(searchValue);

        request.setAttribute("films_list", films);
    }
}
