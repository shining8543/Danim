package com.pd.danim.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.danim.Form.Response.StoryResponse;
import com.pd.danim.Service.HomeService;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	@GetMapping("/myPopular")
	public ResponseEntity<List<List<StoryResponse>>> myPopularStory(HttpServletRequest httpServletRequest){
		homeService.getMyPopularStory(httpServletRequest);
		
		List<List<StoryResponse>> storyResponses = homeService.getMyPopularStory(httpServletRequest); 
		
		return new ResponseEntity<List<List<StoryResponse>>>(storyResponses,HttpStatus.OK);
	}
	
	

	@GetMapping("/popular")
	public ResponseEntity<List<StoryResponse>> popularStory(){
		
		List<StoryResponse> storyResponses = homeService.getPopularStory();
		
		return new ResponseEntity<List<StoryResponse>>(storyResponses,HttpStatus.OK);
	}
}