package kr.co.lottemarket.dto;

import java.time.LocalDateTime;
import java.util.List;

import kr.co.lottemarket.entity.ArticleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {

	private int no;
	private int parent;
	private int group;
	private int cate1;
	private int cate2;
	private String uid;
	private String title;
	private String content;
	private LocalDateTime rdate;
	
	//추가필드
	private String group_name;
	private String cate1_name;
	private String cate1_description;
	private String cate2_name;
	
	
	 public ArticleEntity toEntity(){
	        return ArticleEntity.builder()
	                .no(no)
	                .parent(parent)
	                .group(group)
	                .cate1(cate1)
	                .cate2(cate2)
	                .uid(uid)
	                .title(title)
	                .content(content)
	                .rdate(rdate)
	                .build();
	    }
}
