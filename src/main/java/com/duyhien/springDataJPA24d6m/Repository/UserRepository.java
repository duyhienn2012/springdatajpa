package com.duyhien.springDataJPA24d6m.Repository;

import com.duyhien.springDataJPA24d6m.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
