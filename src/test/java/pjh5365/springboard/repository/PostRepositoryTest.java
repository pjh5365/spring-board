package pjh5365.springboard.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import pjh5365.springboard.entity.Post;

/**
 * @author : parkjihyeok
 * @since : 2024/03/23
 */
@DataJpaTest
class PostRepositoryTest {

	@Autowired
	PostRepository postRepository;

	@Test
	void 게시글_등록_테스트() {

		Post post = new Post("제목입니다", "내용입니다.");
		postRepository.save(post);

		assertEquals(post, postRepository.findByTitle("제목입니다"));
	}

	@Test
	void 게시글_삭제_테스트() {

		Post post = new Post("제목입니다", "내용입니다.");
		postRepository.save(post);
		postRepository.delete(post);

		assertNull(postRepository.findByTitle("제목입니다"));
	}

	@Test
	void 게시글_수정_테스트() {
		Post post = new Post("제목입니다", "내용입니다.");
		postRepository.save(post);
		postRepository.findById(post.getId());
		Post updatePost = new Post(post.getId(), "업데이트된 내용입니다.", "업데이트된 내용");
		postRepository.save(updatePost);

		Post result = postRepository.findById(post.getId()).get();

		assertAll(
				() -> assertEquals(updatePost.getTitle(), result.getTitle()),
				() -> assertEquals(updatePost.getContent(), result.getContent())
		);

		assertEquals(1, postRepository.findAll().size());
	}
}