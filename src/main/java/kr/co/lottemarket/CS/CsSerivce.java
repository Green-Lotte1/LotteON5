package kr.co.lottemarket.CS;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import groovy.util.logging.Log4j2;
import kr.co.lottemarket.dto.ArticleDTO;
import kr.co.lottemarket.dto.cs.PageRequestDTO;
import kr.co.lottemarket.dto.cs.PageResponseDTO;
import kr.co.lottemarket.entity.ArticleEntity;
import kr.co.lottemarket.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;

@lombok.extern.log4j.Log4j2
@RequiredArgsConstructor
@Service
public class CsSerivce {

	private final ArticleRepository articleRepository;
	private final ModelMapper modelMapper;

	public PageResponseDTO findByParentAndGroupAndCate1(PageRequestDTO pageRequestDTO){
		
		Pageable pageable = pageRequestDTO.getPageable("no");
		
		Page<ArticleEntity> result = articleRepository.findByParentAndGroupAndCate1(0, pageRequestDTO.getGroup(), pageRequestDTO.getCate1(), pageable);
		
		List<ArticleDTO> dtoList = result.getContent()
										.stream()
										.map(entity -> modelMapper.map(entity, ArticleDTO.class))
										.toList();
		
		 int totalElement = (int)result.getTotalElements();  //전체 게시글 갯수


     	return PageResponseDTO.builder()
                              .pageRequestDTO(pageRequestDTO)
                              .dtoList(dtoList)
                              .total(totalElement)
                              .build();
		
	}
	
	
	public PageResponseDTO findByParentAndGroup(PageRequestDTO pageRequestDTO){
		
		Pageable pageable = pageRequestDTO.getPageable("no");
		
		Page<ArticleEntity> result = articleRepository.findByParentAndGroup(0, pageRequestDTO.getGroup(), pageable);
		
		List<ArticleDTO> dtoList = result.getContent()
										.stream()
										.map(entity -> modelMapper.map(entity, ArticleDTO.class))
										.toList();
		
		 int totalElement = (int)result.getTotalElements();  


     	return PageResponseDTO.builder()
                              .pageRequestDTO(pageRequestDTO)
                              .dtoList(dtoList)
                              .total(totalElement)
                              .build();
		
	}
	
	public ArticleDTO findLotteON_boardByNo(int no) {
		
		Optional<ArticleEntity> result = articleRepository.findLotteON_boardByNo(no);
		
		ArticleDTO dtoArticle = result.get().toDTO();
					 						
		return dtoArticle;
		
	}
	
	//글 등록
	 public void insertArticle(ArticleDTO dto){
		 log.info("service dto" +  dto.getUid());
		 // 글 등록
		 ArticleEntity insertArticle = articleRepository.save(dto.toEntity());
	 }
	 
	 
	 
	 public List<ArticleDTO> nfindByParentAndGroupCate1(ArticleDTO articleDTO) {
		 
		 List<ArticleDTO> articles = articleRepository
				 						.findByParentAndGroupAndCate1OrderByNoDesc(0, articleDTO.getGroup(), articleDTO.getCate1())
				 						.stream()
				 						.map(entity -> modelMapper.map(entity, ArticleDTO.class))
				 						.toList();
		 
		 return articles;
	 }
	    
	
	
	
}
