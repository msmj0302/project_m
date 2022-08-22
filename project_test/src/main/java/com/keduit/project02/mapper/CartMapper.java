package com.keduit.project02.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.keduit.project02.domain.CartVO;
import com.keduit.project02.domain.Criteria;

@Mapper
public interface CartMapper{
	public List<Map<String, Object>> cartList() throws Exception;
	
	public Long insert(CartVO vo);
	
	public CartVO read(Long cno);
	
	public void remove(String no);

	public void delete(String no);
	
	public List<CartVO> listCriteria(Criteria cri);
	
	/*
	 * public int photoRegister(PhotoBookingVO pVo,String id); public int
	 * spaRegister(SpaBookingVO sVo, String id); public CartVO readById(String id);
	 * public void removeById(String id);
	 */




	
	
	
}
