package movies.service;

import movies.beans.User;

import java.util.List;

public interface UserService {
    User getUserById(int id);

    User getUserByLogin(String login);

    User getUserByEmail(String email);

    int getNumber();

    boolean signIn(String login, String password);

    boolean signUp(User user);

    boolean deleteUser(User user);

    boolean updateUser(User user);

    List<User> findAllUsers();

    List<User> findByCountry(String country);
}
