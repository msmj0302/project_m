package com.keduit.project02.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.keduit.project02.domain.CartVO;
import com.keduit.project02.domain.Criteria;
import com.keduit.project02.domain.PageMaker;
import com.keduit.project02.mapper.CartMapper;
import com.keduit.project02.service.CartService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;

	@RequestMapping("/cartList")
	public ModelAndView showReserList() throws Exception {
		ModelAndView mv = new ModelAndView("cartList");

		List<Map<String, Object>> list = cartService.cartList();
		mv.addObject("list", list);

		return mv;
	}

	// 장바구니 버튼 눌렀을때 가져오도록
	@PostMapping("/register")
	public String register(CartVO vo, RedirectAttributes rttr) {

		Long cno = cartService.register(vo);

		rttr.addFlashAttribute("result", vo.getCno());

		return "redirect:/cartList";
	}
	
	//체크박스 체크 후 삭제하기 누르면 삭제되도록
	@RequestMapping(value = "/remove")
	public String ajaxTest(HttpServletRequest request) {
		
		String[] ajaxMsg = request.getParameterValues("valueArr");
		int size = ajaxMsg.length;
		for(int i =0; i<size; i++) {
			cartService.delete(ajaxMsg[i]);
		}
		return "redirect:/cartList";
	}
	

	
	@RequestMapping(value = "/cartList", method = RequestMethod.GET)
	public String listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		
		/* logger.info(cri.toString()); */
		
		model.addAttribute("list", cartService.listCriteria(cri));  //글 리스트
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(cartService.listCountCriteria(cri));
		
		model.addAttribute("pageMaker", pageMaker);  //하단의 페이징 관련, 이전페이지, 페이지 링크 , 다음 페이지
		
		return "/cartList";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
