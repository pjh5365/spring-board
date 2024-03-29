package pjh5365.springboard.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 게시글 엔티티
 *
 * @author : parkjihyeok
 * @since : 2024/03/23
 */
@Entity
@Setter
@Getter
@EqualsAndHashCode
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String content;

	@Override
	public String toString() {
		return "Post{" +
				"id=" + id +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				'}';
	}

	public Post() {
	}

	public Post(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public Post(Long id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}
}
