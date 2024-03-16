package pjh5365.springboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 게시글을 담당하는 컨트롤러
 *
 * @author : parkjihyeok
 * @since : 2024/03/16
 */
@Controller
public class PostController {

	// http://localhost:8080/write
	@GetMapping("/write")
	public String write() {
		return "writeForm";
	}
}
