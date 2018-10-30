package cn.icedsoul.loginservice.Repository;

import cn.icedsoul.loginservice.Domain.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<UserAddress,Integer> {
}
