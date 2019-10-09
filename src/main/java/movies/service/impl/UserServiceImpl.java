package movies.service.impl;

import movies.beans.User;
import movies.dao.impl.UserDaoImpl;
import movies.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDaoImpl usersDaoImpl = new UserDaoImpl();

    public UserServiceImpl() {
    }

    @Override
    public User getUserById(int id) {
        return usersDaoImpl.findById(id);
    }

    @Override
    public User getUserByLogin(String login) {
        return usersDaoImpl.findByLogin(login);
    }

    @Override
    public int getNumber() {
        return usersDaoImpl.getNumber();
    }

    @Override
    public User getUserByEmail(String email) {
        return usersDaoImpl.findByEmail(email);
    }

    @Override
    public List<User> findByCountry(String country) {
        return usersDaoImpl.findByCountry(country);
    }

    @Override
    public boolean signIn(String login, String password) {
        if (usersDaoImpl.checkByEmail(login, password) == true || usersDaoImpl.checkByLogin(login, password) == true)
            return true;
        else {
            System.out.println("Неверный логин и/или пароль");
            return false;
        }
    }

    @Override
    public boolean signUp(User user) {
        if (getUserByLogin(user.getLoginUser()) == null && getUserByEmail(user.getEmail()) == null) {
            usersDaoImpl.save(user);
            return true;
        }
        else  {
            System.out.println("Вы используете уже занятый логин и/или адрес эл почты");
            return false;
        }
    }

    @Override
    public boolean deleteUser(User user) {
        usersDaoImpl.delete(user);
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        usersDaoImpl.update(user);
        return true;
    }

    @Override
    public List<User> findAllUsers() {
        return usersDaoImpl.findAll();
    }
}
