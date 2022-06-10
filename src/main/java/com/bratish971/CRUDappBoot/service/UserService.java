package com.bratish971.CRUDappBoot.service;

import com.bratish971.CRUDappBoot.model.User;

public interface UserService {

    Iterable<User> findAll();
    User findById(long id);
    void save(User user);
    void delete(long id);

}
