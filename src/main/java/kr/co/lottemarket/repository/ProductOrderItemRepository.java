package kr.co.lottemarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.lottemarket.entity.product.ProductOrderItemEntity;

@Repository
public interface ProductOrderItemRepository extends JpaRepository<ProductOrderItemEntity, String>{

}