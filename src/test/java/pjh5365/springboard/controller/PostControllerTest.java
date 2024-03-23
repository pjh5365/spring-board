package pjh5365.springboard.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import pjh5365.springboard.service.PostService;

/**
 * @author : parkjihyeok
 * @since : 2024/03/23
 */
@WebMvcTest(PostController.class)
class PostControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	PostService postService;

	@Test
	void 게시글_작성_테스트() throws Exception {

		mockMvc.perform(post("/write")
				.param("title", "제목")
				.param("content", "내용"))
				.andExpect(status().is3xxRedirection());

		verify(postService).addPost(any());
	}
}