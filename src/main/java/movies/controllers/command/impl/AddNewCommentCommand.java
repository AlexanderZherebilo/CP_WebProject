package movies.controllers.command.impl;

import movies.beans.Comment;
import movies.beans.Film;
import movies.beans.User;
import movies.controllers.PageEnum;
import movies.controllers.command.ActionCommand;
import movies.controllers.command.impl.util.ForwardRedirectHelper;
import movies.controllers.command.impl.util.ParameterEnum;
import movies.service.impl.CommentServiceImpl;
import movies.service.impl.FilmServiceImpl;
import movies.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AddNewCommentCommand implements ActionCommand {
    public void execute(HttpServletRequest req, HttpServletResponse resp, String logginedUser) {

        int rate = Integer.parseInt(req.getParameter(ParameterEnum.RATE.toString()));
        String article = req.getParameter(ParameterEnum.COMMENT.toString());

        String login = req.getParameter(ParameterEnum.LOGIN_TO_COMMENT.toString());
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.getUserByLogin(login);
        int userId = user.getId();

        int filmId = Integer.parseInt(req.getParameter(ParameterEnum.FILM_ID.toString()));

        FilmServiceImpl filmService = new FilmServiceImpl();
        Film film = filmService.getFilmById(filmId);
        CommentServiceImpl commentService = new CommentServiceImpl();

        if (article.equals("") != true) {
            Comment comment = new Comment(userId, filmId, rate, article);
            commentService.addComment(comment);

            List<Comment> commentList = filmService.getAllComents(film.getName());
            updateRate(commentList, film);
        }
            String filmName = film.getName();
            preparePage(req, logginedUser, filmName);
            String path = PageEnum.SINGLE_FILM.toString();
            ForwardRedirectHelper.provideForward(req, resp, path);
    }

    private void updateRate(List<Comment> commentsOfFilm, Film film) {
        int sum = 0;
        for (int i=0; i<commentsOfFilm.size(); i++)
            sum += commentsOfFilm.get(i).getRate();
        int number = commentsOfFilm.size();
        double totalRate = (double) sum/number;
        film.setRate(totalRate);
        FilmServiceImpl filmService = new FilmServiceImpl();
        filmService.updateFilm(film);
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
