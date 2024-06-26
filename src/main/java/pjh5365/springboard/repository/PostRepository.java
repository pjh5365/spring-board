package pjh5365.springboard.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import pjh5365.springboard.entity.Post;

/**
 * 게시글 레파지토리
 *
 * @author : parkjihyeok
 * @since : 2024/03/23
 */
public interface PostRepository extends JpaRepository<Post, Long> {
	Post findByTitle(String title);

	Page<Post> findAllByOrderByIdDesc(Pageable pageable);
}
