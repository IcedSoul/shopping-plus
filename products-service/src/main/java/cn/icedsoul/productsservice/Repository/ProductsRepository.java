package cn.icedsoul.productsservice.Repository;

import cn.icedsoul.productsservice.Domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products,Integer> {
    Optional<Products> findById(Integer id);
    Products findByName(String name);
    List<Products> findAllByType(Integer type);
    List<Products> findAllBySeller(Integer seller);
}
