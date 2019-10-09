package movies.service;

import movies.beans.Comment;

public interface CommentService {
    void addComment(Comment comment);

    Comment getCommentById(int commentId);

    void deleteComment(Comment comment);
}
