package org.superbiz.rest.dao;

import org.superbiz.rest.model.User;

import java.util.List;

public interface UserDAO {


    User create(String name, String pwd, String mail);

    List<User> list(int first, int max);

    User find(long id);

    void delete(long id);

    User update(long id, String name, String pwd, String mail);
}
