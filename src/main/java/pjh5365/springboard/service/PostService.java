package pjh5365.springboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import pjh5365.springboard.dto.PostRequest;
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

	public void addPost(PostRequest postRequest) {
		Post post = new Post(postRequest.getTitle(), postRequest.getContent());
		postRepository.save(post);
	}

	public Page<Post> findAll(Pageable pageable) {
		return postRepository.findAllByOrderByIdDesc(pageable);
	}

	public Post findById(Long id) {
		return postRepository.findById(id).get();
	}

	public void update(Long postId, PostRequest postRequest) {
		Post post = new Post(postId, postRequest.getTitle(), postRequest.getContent());
		postRepository.save(post);
	}

	public void delete(Long postId) {
		postRepository.deleteById(postId);
	}
}
