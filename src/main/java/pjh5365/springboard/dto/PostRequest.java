package pjh5365.springboard.dto;

import lombok.Getter;

/**
 * @author : parkjihyeok
 * @since : 2024/04/06
 */
@Getter
public class PostRequest {

	private String title;
	private String content;

	public PostRequest(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
