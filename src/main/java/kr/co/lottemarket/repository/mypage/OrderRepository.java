package kr.co.lottemarket.repository.mypage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.lottemarket.entity.product.ProductOrderEntity;
import kr.co.lottemarket.entity.user.UserEntity;

@Repository
public interface OrderRepository extends JpaRepository<ProductOrderEntity, String>{
	
	
}