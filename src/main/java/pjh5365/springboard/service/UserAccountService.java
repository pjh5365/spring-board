package pjh5365.springboard.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pjh5365.springboard.dto.UserAccountRequest;
import pjh5365.springboard.entity.UserAccount;
import pjh5365.springboard.repository.UserAccountRepository;

/**
 * @author : parkjihyeok
 * @since : 2024/04/13
 */
@Service
public class UserAccountService {

	private final UserAccountRepository userAccountRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserAccountService(UserAccountRepository userAccountRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userAccountRepository = userAccountRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public void join(UserAccountRequest request) {
		UserAccount user = UserAccount.builder()
				.userId(request.getUserId())
				.password(bCryptPasswordEncoder.encode(request.getPassword()))
				.build();
		userAccountRepository.save(user);
	}

	public UserAccount login(UserAccountRequest request) {
		String userId = request.getUserId();
		Optional<UserAccount> getUser = userAccountRepository.findByUserId(userId);
		if (getUser.isPresent()) {
			UserAccount user = getUser.get();
			if (user.getPassword().equals(request.getPassword())) {
				return user;
			}
		}
		return null;
	}
}
