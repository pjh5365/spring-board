package pjh5365.springboard.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

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

		Post post = new Post(1L, "제목입니다.", "내용입니다.");
		postRepository.save(post);

		assertEquals(post, postRepository.findById(1L).get());
	}

	@Test
	void 게시글_삭제_테스트() {

		Post post = new Post(1L, "제목입니다.", "내용입니다.");
		postRepository.save(post);
		postRepository.delete(post);

		assertEquals(Optional.empty(), postRepository.findById(1L));
	}
}