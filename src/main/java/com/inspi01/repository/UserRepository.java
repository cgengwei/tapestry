package com.inspi01.repository;

import org.springframework.stereotype.Repository;

import com.inspi01.domain.User;
import com.inspi01.repository.base.GenericRepository;

/**
 * @author Inspireso Team
 */
@Repository
public interface UserRepository extends GenericRepository<User> {

    User findById(String id);



}
