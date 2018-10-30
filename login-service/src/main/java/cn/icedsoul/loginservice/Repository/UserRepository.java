package cn.icedsoul.loginservice.Repository;

import cn.icedsoul.loginservice.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
