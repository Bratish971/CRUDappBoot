package com.bratish971.CRUDappBoot.dao;

import com.bratish971.CRUDappBoot.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
