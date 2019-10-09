package movies.dao;

import movies.beans.Comment;
import movies.beans.Film;
import movies.beans.User;

import java.util.List;

public interface CommentDao {
    Comment findById(int id);

    List<Comment> findAll();

    boolean save(Comment comment);

    void update(Comment comment);

    void delete(Comment comment);
}
