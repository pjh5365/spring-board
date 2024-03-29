package pjh5365.springboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pjh5365.springboard.entity.Post;
import pjh5365.springboard.service.PostService;

/**
 * 게시글을 담당하는 컨트롤러
 *
 * @author : parkjihyeok
 * @since : 2024/03/16
 */
@Controller
public class PostController {

	private final PostService postService;

	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}

	// http://localhost:8080/write
	@GetMapping("/write")
	public String write() {
		return "writeForm";
	}

	@PostMapping("/write")
	public String addPost(Post post) {
		postService.addPost(post);
		System.out.println(post);
		return "redirect:/";
	}

	@GetMapping("/")
	public String postList(Model model, @PageableDefault(size = 3) Pageable pageable) {
		Page<Post> list = postService.findAll(pageable);
		int startPage;
		int endPage;

		if (list.getTotalPages() < 5) {
			startPage = 1;
			endPage = list.getTotalPages();
		} else if (pageable.getPageNumber() < 3) {
			startPage = 1;
			endPage = 5;
		} else if(pageable.getPageNumber() >= list.getTotalPages() - 3) {   // 현재 페이지가 총 페이지 - 3 보다 크거나 같을 때는
			startPage = list.getTotalPages() - 4;
			endPage = list.getTotalPages();
		}
		else { // 나머지 경우
			startPage = list.getPageable().getPageNumber() - 1;    // 4페이지 보일 때 원래 페이지는 3이므로 1을 빼서 2로 설정
			endPage = list.getPageable().getPageNumber() + 3;   // 원래 페이지인 3에 3을 더해 6 로 설정 (2,3,4,5,6 까지 설정 가능)
		}
		model.addAttribute("list", list);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);

		System.out.println(list);
		return "index";
	}

	@GetMapping("/posts/{id}")
	public String getPost(@PathVariable Long id, Model model) {
		Post post = postService.findById(id);
		model.addAttribute("post", post);

		return "postView";
	}
}
