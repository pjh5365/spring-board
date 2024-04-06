package pjh5365.springboard.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pjh5365.springboard.dto.PostRequest;
import pjh5365.springboard.entity.Post;
import pjh5365.springboard.repository.PostRepository;

/**
 * @author : parkjihyeok
 * @since : 2024/03/23
 */
@SpringBootTest
class PostServiceTest {

	@Autowired
	PostRepository postRepository;
	@Autowired
	PostService postService;

	@Test
	void 게시글_저장_테스트() {
		PostRequest postRequest = new PostRequest( "제목", "내용");
		postService.addPost(postRequest);

		Post result = postRepository.findByTitle("제목");
		assertAll(
				() -> assertEquals(postRequest.getTitle(), result.getTitle()),
				() -> assertEquals(postRequest.getContent(), result.getContent())
		);
	}
}