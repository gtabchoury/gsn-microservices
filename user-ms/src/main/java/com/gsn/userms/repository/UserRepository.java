package com.gsn.userms.repository;

import com.gsn.userms.model.persistence.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    User getById(Long id);
    User findUserByEmail(String email);
}
