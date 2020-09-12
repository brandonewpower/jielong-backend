package com.gtt.wxmini.jielongbackend.repositories;

import com.gtt.wxmini.jielongbackend.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUserId(long userId);
    List<User> findAllByJielongId(long jielongId);
}
