package pjh5365.springboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String postList(Model model) {
		List<Post> list = postService.findAll();

		model.addAttribute("list", list);
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
