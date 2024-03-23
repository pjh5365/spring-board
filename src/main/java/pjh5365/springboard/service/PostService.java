package pjh5365.springboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pjh5365.springboard.entity.Post;
import pjh5365.springboard.repository.PostRepository;

/**
 * 게시글을 담당하는 서비스
 *
 * @author : parkjihyeok
 * @since : 2024/03/23
 */
@Service
public class PostService {

	private final PostRepository postRepository;

	@Autowired
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public void addPost(Post post) {
		postRepository.save(post);
	}

	public List<Post> findAll() {
		return postRepository.findAll();
	}

	public Post findById(Long id) {
		return postRepository.findById(id).get();
	}
}
