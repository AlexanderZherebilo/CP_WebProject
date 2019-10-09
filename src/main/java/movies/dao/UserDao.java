package movies.dao;

import movies.beans.Comment;
import movies.beans.User;

import java.util.List;

public interface UserDao {
    User findById(int id);

    User findByLogin(String login);

    User findByEmail(String email);

    int getNumber();

    boolean save(User user);

    void update(User user);

    void delete(User user);

    List<User> findAll();

    List<User> findByCountry(String country);

    List<Comment> findListOfComments(String loginUser);

    boolean checkByLogin(String login, String password);

    boolean checkByEmail(String email, String password);
}
