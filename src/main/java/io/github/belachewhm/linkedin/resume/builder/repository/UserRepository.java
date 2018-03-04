package io.github.belachewhm.linkedin.resume.builder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.belachewhm.linkedin.resume.builder.model.UserBean;
 
public interface UserRepository extends JpaRepository<UserBean, String> {
 
     UserBean findByEmail(String email);
 
}
