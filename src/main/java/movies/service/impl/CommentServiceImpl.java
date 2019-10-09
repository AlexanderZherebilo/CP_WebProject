package movies.service.impl;

import movies.beans.Comment;
import movies.dao.impl.CommentDaoImpl;
import movies.service.CommentService;

public class CommentServiceImpl implements CommentService {
    CommentDaoImpl commentDao = new CommentDaoImpl();

    @Override
    public void addComment(Comment comment) {
        commentDao.save(comment);
    }

    @Override
    public Comment getCommentById(int commentId) {
        return commentDao.findById(commentId);
    }

    @Override
    public void deleteComment(Comment comment) {
        commentDao.delete(comment);
    }
}
