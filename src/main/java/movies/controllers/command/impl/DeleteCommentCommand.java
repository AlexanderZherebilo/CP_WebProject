package movies.controllers.command.impl;

import movies.beans.Comment;
import movies.beans.Film;
import movies.controllers.PageEnum;
import movies.controllers.command.ActionCommand;
import movies.controllers.command.impl.util.ForwardRedirectHelper;
import movies.controllers.command.impl.util.ParameterEnum;
import movies.service.impl.CommentServiceImpl;
import movies.service.impl.FilmServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeleteCommentCommand implements ActionCommand {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp, String logginedUser) throws ServletException, IOException {
        int idComment = Integer.parseInt(req.getParameter("id_comment"));
        CommentServiceImpl commentService = new CommentServiceImpl();
        Comment comment = commentService.getCommentById(idComment);
        System.out.println(comment);
        commentService.deleteComment(comment);

        int filmId = Integer.parseInt(req.getParameter(ParameterEnum.FILM_ID.toString()));

        FilmServiceImpl filmService = new FilmServiceImpl();
        Film film = filmService.getFilmById(filmId);

        String filmName = film.getName();
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
