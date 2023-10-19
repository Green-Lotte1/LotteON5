package kr.co.lottemarket.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import kr.co.lottemarket.dto.ArticleDTO;
import kr.co.lottemarket.dto.cs.ArticleCate2DTO;
import kr.co.lottemarket.entity.product.ProductCate1Entity;
import kr.co.lottemarket.entity.product.ProductCate2Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "lotte_board")
public class ArticleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	private int parent;
	@Column(name = "\"group\"")
	private int group;
	private int cate1;
	private int cate2;
	private String uid;
	private String title;
	private String content;
	
	// 카테필드 추가
	@OneToOne
	@JoinColumn(name = "cate1_name")
	private ArticleCate1Entity cate1_name;
	@OneToOne
	@JoinColumn(name = "cate2_name")
	private ArticleCate2Entity cate2_name;
	
	@CreationTimestamp
	private LocalDateTime rdate;
	
	
	
	 public ArticleDTO toDTO(){
	        return ArticleDTO.builder()
	                .no(no)
	                .parent(parent)
	                .group(group)
	                .cate1(cate1)
	                .cate2(cate2)
	                .cate1_name(cate1_name)
	                .cate2_name(cate2_name)
	                .uid(uid)
	                .title(title)
	                .content(content)
	                .rdate(rdate)
	                .build();
	    }



}
