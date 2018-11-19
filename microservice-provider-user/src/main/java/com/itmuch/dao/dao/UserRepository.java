package com.itmuch.dao.dao;

import com.itmuch.dao.entity.UserPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserPo, Long> {


}
